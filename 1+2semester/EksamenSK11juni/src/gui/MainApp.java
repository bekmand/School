package gui;

import service.Service;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Service.CreateSomeObjects();
		
		MainFrame frame = new MainFrame();
		frame.setVisible(true);

	}

}
