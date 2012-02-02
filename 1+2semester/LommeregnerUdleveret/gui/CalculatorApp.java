package gui;

import javax.swing.UIManager;


public class CalculatorApp {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Error setting look and feel: " + e.getMessage());
		}
		CalculatorFrame frame = new CalculatorFrame();
		frame.setVisible(true);
	}

}
