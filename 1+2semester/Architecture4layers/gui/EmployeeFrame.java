package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Company;
import model.Employee;
import service.Service;

/**
 * The EmployeeFrame class implements a view that shows all employees.
 * The view also enables the user to open other views, where he can 
 * create, update or delete an employee.<br />
 * @author mlch
 */
public class EmployeeFrame extends JFrame {
	private JLabel lblEmployees, lblName, lblWage, lblCompany, lblSalary;
	private JScrollPane scpEmployees;
	private JList lstEmployees;
	private JTextField txfName, txfWage, txfCompany, txfSalary;
	private JButton btnCreate, btnUpdate, btnDelete;

	private Controller controller = new Controller();

	public EmployeeFrame() {
		this.setTitle("Employees");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocation(500, 200);
		this.setSize(400, 300);
		this.setLayout(null);

		lblEmployees = new JLabel("Employees");
		this.add(lblEmployees);
		lblEmployees.setLocation(10, 10);
		lblEmployees.setSize(100, 25);

		lstEmployees = new JList();
		lstEmployees.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEmployees.addListSelectionListener(controller);

		scpEmployees = new JScrollPane(lstEmployees);
		this.add(scpEmployees);
		scpEmployees.setLocation(10, 35);
		scpEmployees.setSize(180, 175);

		lblName = new JLabel("Name:");
		this.add(lblName);
		lblName.setLocation(210, 50);
		lblName.setSize(60, 25);

		txfName = new JTextField();
		this.add(txfName);
		txfName.setEditable(false);
		txfName.setFocusable(false);
		txfName.setLocation(280, 50);
		txfName.setSize(100, 25);

		lblWage = new JLabel("Wage:");
		this.add(lblWage);
		lblWage.setLocation(210, 85);
		lblWage.setSize(60, 25);

		txfWage = new JTextField();
		this.add(txfWage);
		txfWage.setEditable(false);
		txfWage.setFocusable(false);
		txfWage.setLocation(280, 85);
		txfWage.setSize(100, 25);

		lblCompany = new JLabel("Company:");
		this.add(lblCompany);
		lblCompany.setLocation(210, 120);
		lblCompany.setSize(60, 25);

		txfCompany = new JTextField();
		this.add(txfCompany);
		txfCompany.setEditable(false);
		txfCompany.setFocusable(false);
		txfCompany.setLocation(280, 120);
		txfCompany.setSize(100, 25);

		lblSalary = new JLabel("Salary:");
		this.add(lblSalary);
		lblSalary.setLocation(210, 155);
		lblSalary.setSize(60, 25);

		txfSalary = new JTextField();
		this.add(txfSalary);
		txfSalary.setEditable(false);
		txfSalary.setFocusable(false);
		txfSalary.setLocation(280, 155);
		txfSalary.setSize(100, 25);

		btnCreate = new JButton("Create");
		this.add(btnCreate);
		btnCreate.setLocation(50, 230);
		btnCreate.setSize(80, 25);
		btnCreate.addActionListener(controller);

		btnUpdate = new JButton("Update");
		this.add(btnUpdate);
		btnUpdate.setLocation(150, 230);
		btnUpdate.setSize(80, 25);
		btnUpdate.addActionListener(controller);

		btnDelete = new JButton("Delete");
		this.add(btnDelete);
		btnDelete.setLocation(250, 230);
		btnDelete.setSize(80, 25);
		btnDelete.addActionListener(controller);

		//initialise this view
		controller.fillLstEmployees();
	}

	private class Controller implements ActionListener, ListSelectionListener {
		public void fillLstEmployees() {
			lstEmployees.setListData(Service.getInstance().getAllEmployees().toArray());
		}

		private void updateView() {
			if (lstEmployees.getSelectedIndex() > -1) {
				Employee employee = (Employee) lstEmployees.getSelectedValue();
				String name = employee.getName();
				double wage = employee.getWage();
				txfName.setText(name);
				txfWage.setText("" + wage);
				Company company = employee.getCompany();
				if (company != null) {
					double salary = employee.calcWeeklySalary();
					txfCompany.setText(company.getName());
					txfSalary.setText("" + salary);
				}
				else {
					txfCompany.setText("");
					txfSalary.setText("");
				}
			}
			else {
				txfName.setText("");
				txfWage.setText("");
				txfCompany.setText("");
				txfSalary.setText("");
			}
		}

		//This method is called when a button is pressed.
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCreate) {
				EmployeeCUDialog createEmployeeDialog = new EmployeeCUDialog(EmployeeFrame.this,
						"Create New Employee");
				createEmployeeDialog.setVisible(true);

				//waiting for modal createEmployeeDialog to close

				if (createEmployeeDialog.isOKed()) {
					/**** update view ****/
					this.fillLstEmployees();
					int lastIndex = lstEmployees.getModel().getSize() - 1;
					lstEmployees.setSelectedIndex(lastIndex); //calls updateView()
					lstEmployees.ensureIndexIsVisible(lastIndex);
				}
				createEmployeeDialog.dispose(); //release OS resources
			}

			if (e.getSource() == btnUpdate) {
				if (lstEmployees.getSelectedIndex() == -1) {
					//TODO: notify user
					return;
				}

				EmployeeCUDialog updateEmployeeDialog = new EmployeeCUDialog(EmployeeFrame.this,
						"Update Employee");
				Employee employee = (Employee) lstEmployees.getSelectedValue();
				updateEmployeeDialog.setEmployee(employee);
				updateEmployeeDialog.setVisible(true);

				//waiting for modal updateEmployeeDialog to close

				if (updateEmployeeDialog.isOKed()) {
					/**** update view ****/
					int selectedIndex = lstEmployees.getSelectedIndex();
					this.fillLstEmployees();
					lstEmployees.setSelectedIndex(selectedIndex); //calls updateView()
					lstEmployees.ensureIndexIsVisible(selectedIndex);
				}
				updateEmployeeDialog.dispose(); //release MS Windows resources
			}

			if (e.getSource() == btnDelete) {
				int index = lstEmployees.getSelectedIndex();
				if (index == -1) {
					//TODO: notify user
					return;
				}

				int answer = JOptionPane.showConfirmDialog(EmployeeFrame.this, "Are you sure?",
						"Delete Employee", JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					Employee employee = (Employee) lstEmployees.getSelectedValue();
					/**** update storage ****/
					Service.getInstance().deleteEmployee(employee);

					/**** update view ****/
					this.fillLstEmployees();
					this.updateView();
				}
			}
		}

		//This method is called when the selection in a list is changed.
		public void valueChanged(ListSelectionEvent e) {
			if (e.getSource() == lstEmployees) {
				if (!e.getValueIsAdjusting()) {
					this.updateView();
				}
			}
		}
	}
}
