package model;

public class EMenu {
	//Basic
	public static enum phoneState {FORSIDE, MENU, OPKALD, SMS, KONTAKT, ERROR};
	
	//Hoved menu
	public static enum menuStates {FORSIDE, OPRET, LAES, REDIGER, SEND};
	
	/**
	 * The input modes of a InputKeysPanel. 
	 * @author mlch
	 * @version 0.5 25.11.2006
	 */
	public static enum InputMode {
		NUMERIC, CHARACTER
	}

}
