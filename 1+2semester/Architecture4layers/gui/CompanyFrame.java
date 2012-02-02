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
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Company;
import service.Service;

/**
 * The CompanyFrame class implements a view that shows all companies.
 * The view also enables the user to open other views, where he can 
 * create, update or delete a company.<br />
 * @author mlch
 */

public class CompanyFrame extends JFrame {
	private JLabel lblCompanies, lblName, lblHours;
	private JScrollPane scpCompanies;
	private JList lstCompanies;
	private JTextField txfName, txfHours;
	private JButton btnCreate, btnUpdate, btnDelete;

	private Controller controller = new Controller();

	public CompanyFrame() {
		this.setTitle("Companies");
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setLocation(150, 150);
		this.setSize(400, 300);
		this.setLayout(null);

		lblCompanies = new JLabel("Companies");
		this.add(lblCompanies);
		lblCompanies.setLocation(10, 10);
		lblCompanies.setSize(100, 25);

		lstCompanies = new JList();
		lstCompanies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstCompanies.addListSelectionListener(controller);

		scpCompanies = new JScrollPane(lstCompanies);
		this.add(scpCompanies);
		scpCompanies.setLocation(10, 35);
		scpCompanies.setSize(180, 175);

		lblName = new JLabel("Name:");
		this.add(lblName);
		lblName.setLocation(210, 50);
		lblName.setSize(60, 25);

		txfName = new JTextField();
		this.add(txfName);
		txfName.setLocation(280, 50);
		txfName.setSize(100, 25);
		txfName.setEditable(false);
		txfName.setFocusable(false);

		lblHours = new JLabel("Hours:");
		this.add(lblHours);
		lblHours.setLocation(210, 85);
		lblHours.setSize(60, 25);

		txfHours = new JTextField();
		this.add(txfHours);
		txfHours.setLocation(280, 85);
		txfHours.setSize(100, 25);
		txfHours.setEditable(false);
		txfHours.setFocusable(false);

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
		controller.fillLstCompanies();
	}

	private class Controller implements ActionListener, ListSelectionListener {

		public void fillLstCompanies() {
			lstCompanies.setListData(Service.getInstance().getAllCompanies().toArray());
		}

		private void updateView() {
			if (lstCompanies.getSelectedIndex() > -1) {
				Company company = (Company) lstCompanies.getSelectedValue();
				String name = company.getName();
				int hours = company.getHours();
				txfName.setText(name);
				txfHours.setText("" + hours);
			}
			else {
				txfName.setText("");
				txfHours.setText("");
			}
		}

		//This method is called when a button is pressed.
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCreate) {
				CompanyCUDialog createDialog = new CompanyCUDialog(CompanyFrame.this,
						"Create New Company");
				createDialog.setVisible(true);

				//waiting for modal createDialog to close

				if (createDialog.isOKed()) {
					/**** update view ****/
					this.fillLstCompanies();
					int lastIndex = lstCompanies.getModel().getSize() - 1;
					lstCompanies.setSelectedIndex(lastIndex); //calls updateView()
					lstCompanies.ensureIndexIsVisible(lastIndex);
				}
				createDialog.dispose(); //release OS resources
			}

			if (e.getSource() == btnUpdate) {
				if (lstCompanies.getSelectedIndex() == -1) {
					//TODO: notify user
					return;
				}

				CompanyCUDialog updateDialog = new CompanyCUDialog(CompanyFrame.this,
						"Update Company");
				Company company = (Company) lstCompanies.getSelectedValue();
				updateDialog.setCompany(company);
				updateDialog.setVisible(true);

				//waiting for modal updateDialog to close

				if (updateDialog.isOKed()) {
					/**** update view ****/
					int selectedIndex = lstCompanies.getSelectedIndex();
					this.fillLstCompanies();
					lstCompanies.setSelectedIndex(selectedIndex); //calls updateView()
					lstCompanies.ensureIndexIsVisible(selectedIndex);

					//The EmployeeFrame view ought to be updated here too. But it it not done.
					//To update the EmployeeFrame view the user must close and reopen the view. 
				}
				updateDialog.dispose(); //release MS-Windows resources
			}

			if (e.getSource() == btnDelete) {
				int index = lstCompanies.getSelectedIndex();
				if (index == -1) {
					//TODO: notify user
					return;
				}

				int answer = JOptionPane.showConfirmDialog(CompanyFrame.this, "Are you sure?",
						"Delete Company", JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					Company company = (Company) lstCompanies.getSelectedValue();
					if (company.getEmployeesCount() == 0) {
						/**** update storage ****/
						Service.getInstance().deleteCompany(company);

						/**** update view ****/
						this.fillLstCompanies();
						this.updateView();
					}
					else {
						JOptionPane.showMessageDialog(CompanyFrame.this,
								"Can't delete a company with employees.", "Delete Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}

		//This method is called when the selection in a list is changed.
		public void valueChanged(ListSelectionEvent e) {
			if (e.getSource() == lstCompanies) {
				if (!e.getValueIsAdjusting()) {
					this.updateView();
				}
			}
		}
	}
}
