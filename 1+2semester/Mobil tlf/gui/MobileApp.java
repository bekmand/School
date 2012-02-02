package gui;

import service.Service;

// mlch
// 25.11.2006

public class MobileApp {

	public static void main(String[] args) {
		Service.Start();
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}
