package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.Company;
import model.Employee;
import service.Service;
 

/**
 * The EmployeeCUDialog class implements a view that shows a single employee.
 * The view is used by the user to create or update an employee.<br />
 * Note: This view is created by the EmployeeFrame view, when the user clicks
 * the Create button or the Update button. A new view object is created 
 * each time the user clicks one of these buttons in the EmployeeFrame view.
 * 
 * @author mlch
 */
public class EmployeeCUDialog extends JDialog {
	private JLabel lblName, lblWage, lblCompany;
	private JTextField txfName, txfWage;
	private JComboBox cbxCompanies;
	private JButton btnOk, btnCancel;

	private Controller controller = new Controller();

	public EmployeeCUDialog(JFrame owner, String title) {
		super(owner);
		this.setTitle(title);
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(200, 300);
		this.setLayout(null);
		this.setModal(true);

		lblName = new JLabel("Name:");
		this.add(lblName);
		lblName.setLocation(20, 10);
		lblName.setSize(100, 25);

		txfName = new JTextField();
		this.add(txfName);
		txfName.setLocation(20, 35);
		txfName.setSize(150, 25);

		lblWage = new JLabel("Wage:");
		this.add(lblWage);
		lblWage.setLocation(20, 70);
		lblWage.setSize(100, 25);

		txfWage = new JTextField();
		this.add(txfWage);
		txfWage.setLocation(20, 95);
		txfWage.setSize(150, 25);

		lblCompany = new JLabel("Company:");
		this.add(lblCompany);
		lblCompany.setLocation(20, 130);
		lblCompany.setSize(100, 25);

		cbxCompanies = new JComboBox();
		this.add(cbxCompanies);
		cbxCompanies.setLocation(20, 155);
		cbxCompanies.setSize(150, 25);
		cbxCompanies.setMaximumRowCount(4);

		btnOk = new JButton("Ok");
		this.add(btnOk);
		btnOk.setLocation(15, 225);
		btnOk.setSize(70, 25);
		btnOk.addActionListener(controller);

		btnCancel = new JButton("Cancel");
		this.add(btnCancel);
		btnCancel.setLocation(95, 225);
		btnCancel.setSize(80, 25);
		btnCancel.addActionListener(controller);

		// initialise this view
		controller.fillCbxCompanies();
	}

	public boolean isOKed() {
		return controller.closedByOk;
	}

	public Employee getEmployee() {
		return controller.employee;
	}

	public void setEmployee(Employee employee) {
		controller.employee = employee;
		controller.updateView();
	}

	private class Controller implements ActionListener {
		private boolean closedByOk = false;
		private Employee employee = null;

		public void fillCbxCompanies() {
			DefaultComboBoxModel cbxCompaniesModel = new DefaultComboBoxModel(Service.getInstance().
					getAllCompanies().toArray());
			cbxCompaniesModel.insertElementAt(new Company("-- none --", 0), 0);
			cbxCompanies.setModel(cbxCompaniesModel);
		}

		private void updateView() {
			if (employee != null) {
				txfName.setText(employee.getName());
				txfWage.setText("" + employee.getWage());
				Company companyOfEmployee = employee.getCompany();
				if (companyOfEmployee == null)
					cbxCompanies.setSelectedIndex(0);
				else {
					int index = 0;
					boolean found = false;
					int i = 0;
					while (!found && i < cbxCompanies.getItemCount()) {
						Company company = (Company) cbxCompanies.getItemAt(i);
						if (company == companyOfEmployee) {
							found = true;
							index = i;
						}
						i++;
					}
					cbxCompanies.setSelectedIndex(index);
				}
			}
			else {
				txfName.setText("");
				txfWage.setText("");
				cbxCompanies.setSelectedIndex(0);
			}
		}

		// This method is called when a button is pressed.
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOk) {
				String name = txfName.getText().trim();
				if (name.length() == 0) {
					// TODO: notify user
					return;
				}
				String wageStr = txfWage.getText().trim();
				if (wageStr.length() == 0) {
					// TODO: notify user
					return;
				}
				int wage = -1;
				try {
					wage = Integer.parseInt(wageStr);
				}
				catch (NumberFormatException ex) {
					// TODO: notify user
					return;
				}
				if (wage < 0) {
					// TODO: notify user
					return;
				}

				Company company = null;
				if (cbxCompanies.getSelectedIndex() >= 1) {
					company = (Company) cbxCompanies.getItemAt(cbxCompanies.getSelectedIndex());
				}

				/**** update storage ****/
				if (employee == null) {
					Employee newEmployee = Service.getInstance().createEmployee(name, wage);
					if (company != null)
						Service.getInstance().updateCompanyOfEmployee(newEmployee, company);
				}
				else {
					if (!employee.getName().equals(name) || employee.getWage() != wage)
						Service.getInstance().updateEmployee(employee, name, wage);
					if (employee.getCompany() != company)
						Service.getInstance().updateCompanyOfEmployee(employee, company);
				}

				closedByOk = true;
				EmployeeCUDialog.this.setVisible(false);
			}

			if (e.getSource() == btnCancel) {
				closedByOk = false;
				EmployeeCUDialog.this.setVisible(false);
			}
		}
	}
}
