package gui;

import javax.swing.UIManager;

import service.Service;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.out.println("Error setting look and feel: " + e.getMessage());
		}
		Service.startUp();
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

	}

