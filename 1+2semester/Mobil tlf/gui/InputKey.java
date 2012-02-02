package gui;

import java.awt.Insets;

import javax.swing.JButton;

/**
 * An input key on a mobile phone. The InputKey class is designed to be used 
 * to create the keys added to an InputKeysPanel.
 * @author mlch
 * @version 0.5 25.11.2006
 *
 */
public class InputKey extends JButton {
	// this button's digit
	private char digit;
	// this button's characters;
	// a button can have multiple characters (more than shown by the text on the button)
	private String chars;
	// index in chars of the last character returned
	private int index;

	/**
	 * Creates an InputKey.
	 * @param text - the text to display on the key
	 * @param digit - the digit of this key
	 * @param chars - the chars of this key
	 */
	public InputKey(String text, char digit, String chars) {
		super(text);
		this.setMargin(new Insets(1, 1, 1, 1));
		this.digit = digit;
		this.chars = chars;
	}

	/**
	 * Returns the characters of this key.
	 */
	public String getChars() {
		return chars;
	}

	/**
	 * Returns the digit of this key.
	 */
	public char getDigit() {
		return digit;
	}

	/**
	 * Returns the first character of the characters of this key. 
	 */
	public char getFirstChar() {
		index = 0;
		return chars.charAt(0);
	}

	/**
	 * Returns the character following the last character returned. 
	 */
	public char getNextChar() {
		index++;
		if (index == chars.length())
			index = 0;
		return chars.charAt(index);
	}
}
