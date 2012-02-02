package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import service.Service;

/**
 * The Mainframe class implements the main view in the ArchitectureExample application.
 * The view enables the user to open two other views that can show all the companies 
 * and all the employees.<br />
 * @author mlch
 */
public class MainFrame extends JFrame {
	private JButton btnShowCompanyView, btnShowEmployeeView;

	private CompanyFrame companyFrame;
	private EmployeeFrame employeeFrame;

	private Controller controller = new Controller();

	public MainFrame() {
		this.setTitle("Application (2-layered) with GUI and model classes");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		this.setSize(600, 300);
		this.setLayout(null);

		Service.getInstance().startUp();

		btnShowCompanyView = new JButton("Show Companies");
		this.add(btnShowCompanyView);
		btnShowCompanyView.setLocation(100, 90);
		btnShowCompanyView.setSize(150, 75);
		btnShowCompanyView.addActionListener(controller);

		btnShowEmployeeView = new JButton("Show Employees");
		this.add(btnShowEmployeeView);
		btnShowEmployeeView.setLocation(350, 90);
		btnShowEmployeeView.setSize(150, 75);
		btnShowEmployeeView.addActionListener(controller);

		companyFrame = new CompanyFrame();
		employeeFrame = new EmployeeFrame();

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Service.getInstance().closeDown();
			}
		});
	}

	private class Controller implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnShowCompanyView) {
				companyFrame.setVisible(true);
			}

			if (e.getSource() == btnShowEmployeeView) {
				employeeFrame.setVisible(true);
			}
		}
	}
}
