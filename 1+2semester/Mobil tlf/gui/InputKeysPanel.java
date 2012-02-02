package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.EMenu.InputMode;

/**
 * A panel designed to contain input keys for a mobile phone.
 * The imput keys must have type InputKey.
 * The panel have two modes: InputMode.NUMERIC and InputMode.CHARACTER.
 * When in mode NUMERIC, pressing a key returns a digit.
 * When in mode CHARACTER, pressing a key returns a char.  
 * The panel holds<ul> 
 * <li> the text keyed in with the input keys</li>
 * <li> the offset of the cursor in the text</li>
 * <li> the input mode (default is NUMERIC)</li>
 * <li> the timespan used in CHARACTER input mode to determine, if a key returns
 *      the next character, when pressed multiple times (default is 1000 ms)</li>
 *  </ul>           
 * @author mlch
 * @version 0.5 25.11.2006
 */
public class InputKeysPanel extends JPanel {
	// the text keyed in
	private StringBuilder text = new StringBuilder("");
	// the position of the cursor in the text 
	// (characters are inserted and removed at the cursor position)
	private int offset = 0;
	// the input mode: NUMERIC or CHARACTER
	private InputMode inputMode = InputMode.NUMERIC;
	// the button last pressed
	private InputKey lastPressedButton = null;
	// the timespan within which two presses of the same button 
	// will result in the buttons next character 
	private int nextCharTimespan = 1000; //msec
	// the time when the last button was pressed
	private long lastPressedTime = -nextCharTimespan;

	//listeners to the InputText event
	private ArrayList<InputTextListener> listeners = new ArrayList<InputTextListener>();

	private InputKey mbtn0,mbtn1, mbtn2, mbtn3,mbtn4,mbtn5,mbtn6,mbtn7,mbtn8,mbtn9; //You can add more buttons here.

	private Controller controller = new Controller();

	/**
	 * Creates an InputKeysPanel. 
	 */
	public InputKeysPanel() {
		mbtn0 = new InputKey("0", '0', " 0");
		this.add(mbtn0);
		mbtn0.setSize(50, 25);
		mbtn0.setLocation(150, 130);
		mbtn0.addActionListener(controller);
		
		mbtn1 = new InputKey("1 oo", '1', ".,!?-1");
		this.add(mbtn1);
		mbtn1.setSize(50, 25);
		mbtn1.setLocation(50, 25);
		mbtn1.addActionListener(controller);

		mbtn2 = new InputKey("2 abc", '2', "abcæå2");
		this.add(mbtn2);
		mbtn2.setSize(50, 25);
		mbtn2.setLocation(150, 25);
		mbtn2.addActionListener(controller);

		mbtn3 = new InputKey("3 def", '3', "def3");
		this.add(mbtn3);
		mbtn3.setSize(50, 25);
		mbtn3.setLocation(250, 25);
		mbtn3.addActionListener(controller);
		
		mbtn4 = new InputKey("4 ghi", '4', "ghi4");
		this.add(mbtn4);
		mbtn4.setSize(50, 25);
		mbtn4.setLocation(50, 60);
		mbtn4.addActionListener(controller);

		mbtn5 = new InputKey("5 jkl", '5', "jkl5");
		this.add(mbtn5);
		mbtn5.setSize(50, 25);
		mbtn5.setLocation(150, 60);
		mbtn5.addActionListener(controller);

		mbtn6 = new InputKey("6 mno", '6', "mnoø6");
		this.add(mbtn6);
		mbtn6.setSize(50, 25);
		mbtn6.setLocation(250, 60);
		mbtn6.addActionListener(controller);
		
		mbtn7 = new InputKey("7 pqr", '7', "pqr7");
		this.add(mbtn7);
		mbtn7.setSize(50, 25);
		mbtn7.setLocation(50, 95);
		mbtn7.addActionListener(controller);

		mbtn8 = new InputKey("8 stuv", '8', "stuv8");
		this.add(mbtn8);
		mbtn8.setSize(50, 25);
		mbtn8.setLocation(150, 95);
		mbtn8.addActionListener(controller);

		mbtn9 = new InputKey("9 wxyz", '9', "wxyz9");
		this.add(mbtn9);
		mbtn9.setSize(50, 25);
		mbtn9.setLocation(250, 95);
		mbtn9.addActionListener(controller);
	}

	/**
	 * A listener for action events from buttons.
	 * @author mlch
	 * @version 0.5 25.11.2006
	 */
	private class Controller implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			InputKey source = (InputKey) e.getSource();
			if (inputMode == InputMode.NUMERIC) {
				text.insert(offset, source.getDigit());
				offset++;
				lastPressedButton = null;
			}
			if (inputMode == InputMode.CHARACTER) {
				long now = e.getWhen();
				if (source != lastPressedButton) {
					text.insert(offset, source.getFirstChar());
					offset++;
				} else { //source == lastPressedButton
					if (now - lastPressedTime < nextCharTimespan)
						text.setCharAt(offset - 1, source.getNextChar());
					else {
						text.insert(offset, source.getFirstChar());
						offset++;
					}
				}
				lastPressedTime = now;
				lastPressedButton = source;
			}
			InputTextEvent ie = new InputTextEvent(source, text.toString());
			fireTextChanged(ie);
		}
	}

	// Returns the text, formatted in html, so the character at the cursor is underlined.   
	private String formatText(int lineLength) {
		String s = this.text.toString();
		if (offset == this.text.length())
			s += " ";
		StringBuilder temp = new StringBuilder("<html>");
		int index1 = 0;
		int index2 = Math.min(s.length(), lineLength);
		while (index1 < s.length()) {
			if (index1 <= offset && offset < index2) {
				temp.append(s.substring(index1, offset));
				temp.append("<u>");
				if (s.charAt(offset) == ' ')
					temp.append("&nbsp;");
				else
					temp.append(s.charAt(offset));
				temp.append("</u>");
				temp.append(s.substring(offset + 1, index2));
			} else {
				temp.append(s.substring(index1, index2));
			}
			if (index2 < s.length())
				temp.append("<br>");
			index1 = index2;
			index2 = Math.min(s.length(), index2 + lineLength);
		}
		temp.append("</html>");
		return temp.toString();
	}

	// Invokes textChanged() method on all listeners
	private void fireTextChanged(InputTextEvent e) {
		for (InputTextListener l : listeners) {
			l.textChanged(e);
		}
	}

	/**
	 * Returns the keyed in text.
	 */
	public String getText() {
		return text.toString();
	}

	public int getOffset(){
		return offset;
	}
	
	/**
	 * Returns the keyed in text, formatted in html, so that the character
	 * at the cursor is underlined and the text is broken into lines.
	 * @param lineLength - the length of a line
	 */
	public String getFormattedText(int lineLength) {
		return formatText(lineLength);
	}

	/**
	 * Replaces the text in this InputKeysPanel. 
	 * @param text - the new text that replaces the old text 
	 */
	public void setText(String text) {
		this.text.replace(0, this.text.length(), text);
		this.offset = this.text.length();
	}

	/**
	 * Returns the input mode of this InputKeysPanel.
	 */
	public InputMode getInputMode() {
		return inputMode;
	}

	/**
	 * Sets the input mode of this InputKeysPanel.
	 * @param inputMode - the new input Mode
	 */
	public void setInputMode(InputMode inputMode) {
		this.inputMode = inputMode;
	}

	/**
	 * Returns the timespan used in CHARACTER input mode.
	 */
	public int getNextCharTimespan() {
		return nextCharTimespan;
	}

	/**
	 * Sets the timespan used in CHARACTER input mode.
	 * @param nextCharTimespan - the timespan used in CHARACTER input mode
	 */
	public void setNextCharTimespan(int nextCharTimespan) {
		this.nextCharTimespan = nextCharTimespan;
	}

	/**
	 * Returns the cursor posistion in the text.
	 */
	public int getCursorPosition() {
		return offset;
	}

	/**
	 * Moves the cursor in the text.
	 * @param amount the amount to move the cursor;
	 * negative is to the left, positive is to the right
	 */
	public void moveCursor(int amount) {
		this.offset += amount;
		if (offset < 0)
			offset = 0;
		if (offset > text.length())
			offset = text.length();
	}

	/**
	 * Deletes the char at the cursor position in the text. 
	 */
	public void deleteChar() {
		if (offset > 0) {
			offset--;
			text.deleteCharAt(offset);
		}
	}

	/**
	 * Adds a listener for InputText events.
	 * @param l - an InputTextListener
	 */
	public void addInputTextListener(InputTextListener l) {
		listeners.add(l);
	}
}