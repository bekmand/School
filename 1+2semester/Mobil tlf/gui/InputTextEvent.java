package gui;

import java.util.EventObject;

/**
 * The InputTextEvent is designed to be used together with the InputKeysPanel.
 * This event is generated each time the text in the InputKeysPanel is changed
 * by using one of the input keys.  
 * @author mlch
 * @version 0.5 25.11.2006
 */
public class InputTextEvent extends EventObject {
	private String text;
	
	/**
	 * Creates an InputText event containing text. 
	 * @param source - the source of this event
	 * @param text - the text in this event
	 */
	public InputTextEvent(Object source, String text) {
		super(source);
		this.text = text;
	}
	
	/**
	 * Returns the text in this event.
	 */
	public String getText() {
		return text;
	}
}
