package gui;

import javax.swing.UIManager;

/**
 * The ArchitectureExample application shows how to program an application
 * with graphical user interface and business classes.
 * The architecture is a 2-layered architecture.
 * @author mlch
 */
public class ArchitectureExampleApp {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.out.println("Error setting look and feel: " + e.getMessage());
		}

		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}
