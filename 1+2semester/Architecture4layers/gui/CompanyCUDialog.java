package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.Company;
import service.Service;

/**
 * The CompanyCUDialog class implements a view that shows a single company.
 * The view is used by the user to create or update a company.<br />
 * Note: This view is created by the CompanyFrame view, when the user clicks the
 * Create button or the Update button. A new view object is created each time
 * the user clicks one of these buttons in the CompanyFrame view. 
 * @author mlch
 */

public class CompanyCUDialog extends JDialog {
	private JLabel lblName, lblHours;
	private JTextField txfName, txfHours;
	private JButton btnOk, btnCancel;

	private Controller controller = new Controller();

	public CompanyCUDialog(JFrame owner, String title) {
		super(owner);
		this.setTitle(title);
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setLocation(200, 200);
		this.setSize(200, 220);
		this.setLayout(null);
		this.setModal(true);

		lblName = new JLabel("Name:");
		this.add(lblName);
		lblName.setLocation(10, 10);
		lblName.setSize(100, 25);

		txfName = new JTextField();
		this.add(txfName);
		txfName.setLocation(10, 35);
		txfName.setSize(150, 25);

		lblHours = new JLabel("Hours:");
		this.add(lblHours);
		lblHours.setLocation(10, 70);
		lblHours.setSize(150, 25);

		txfHours = new JTextField();
		this.add(txfHours);
		txfHours.setLocation(10, 95);
		txfHours.setSize(150, 25);

		btnOk = new JButton("Ok");
		this.add(btnOk);
		btnOk.setLocation(15, 145);
		btnOk.setSize(70, 25);
		btnOk.addActionListener(controller);

		btnCancel = new JButton("Cancel");
		this.add(btnCancel);
		btnCancel.setLocation(95, 145);
		btnCancel.setSize(70, 25);
		btnCancel.addActionListener(controller);

		//initialise this view
		controller.updateView();
	}

	public boolean isOKed() {
		return controller.closedByOk;
	}

	public Company getCompany() {
		return controller.company;
	}

	public void setCompany(Company company) {
		controller.company = company;
		controller.updateView();
	}

	private class Controller implements ActionListener {
		private boolean closedByOk = false;
		private Company company = null;

		private void updateView() {
			if (company != null) {
				txfName.setText(company.getName());
				txfHours.setText("" + company.getHours());
			}
			else {
				txfName.setText("");
				txfHours.setText("");
			}
		}

		//This method is called when a button is pressed.
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOk) {
				String name = txfName.getText().trim();
				if (name.length() == 0) {
					//TODO: notify user
					return;
				}
				String hoursStr = txfHours.getText().trim();
				if (hoursStr.length() == 0) {
					//TODO: notify user
					return;
				}
				int hours = -1;
				try {
					hours = Integer.parseInt(hoursStr);
				}
				catch (NumberFormatException ex) {
					//TODO: notify user				
					return;
				}
				if (hours < 0) {
					//TODO: notify user
					return;
				}

				/**** update storage ****/
				if (company == null) {
					Service.getInstance().createCompany(name, hours);
				}
				else {
					if (!company.getName().equals(name) || company.getHours() != hours)
						Service.getInstance().updateCompany(company, name, hours);
				}

				closedByOk = true;
				CompanyCUDialog.this.setVisible(false);
			}

			if (e.getSource() == btnCancel) {
				closedByOk = false;
				CompanyCUDialog.this.setVisible(false);
			}
		}
	}
}
