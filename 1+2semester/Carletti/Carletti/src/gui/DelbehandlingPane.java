package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import service.Service;

import model.Delbehandling;

public class DelbehandlingPane extends JFrame{
	
	private JLabel lblMin, lblIdeal, lblMax, lblNavn, lblID, lblListeDelBehandlinger;
	private JTextField txfNavn, txfID, txfMin, txfIdeal, txfMax;
	private JButton btnOpret, btnRediger, btnSlet;
	private JList lstDelBehandlinger;
	private List<Delbehandling> delbehandlingList;
	private DefaultListModel delbehandlinger;
	private Controller controller = new Controller();
	private Delbehandling selectedValue;
	
	public DelbehandlingPane() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Carletti LK - Delbehandling");
		setBounds(313, 100, 450, 500);
		getContentPane().setLayout(null);
		
		lblNavn = new JLabel("Navn: ");
		getContentPane().add(lblNavn);
		lblNavn.setBounds(25, 25, 50, 20);
		
		lblID = new JLabel("ID: ");
		getContentPane().add(lblID);
		lblID.setBounds(25, 50, 50, 20);
		
		lblMin = new JLabel("Min tid: ");
		getContentPane().add(lblMin);
		lblMin.setBounds(25, 75, 50, 20);
		
		lblIdeal = new JLabel("Ideal tid: ");
		getContentPane().add(lblIdeal);
		lblIdeal.setBounds(25, 100, 50, 20);
		
		lblMax = new JLabel("Max tid: ");
		getContentPane().add(lblMax);
		lblMax.setBounds(25, 125, 50, 20);
		
		txfNavn = new JTextField();
		getContentPane().add(txfNavn);
		txfNavn.setBounds(75, 25, 75, 20);
		
		txfID = new JTextField();
		getContentPane().add(txfID);
		txfID.setBounds(75, 50, 75, 20);
		
		txfMin = new JTextField();
		getContentPane().add(txfMin);
		txfMin.setBounds(75, 75, 75, 20);
		
		txfIdeal = new JTextField();
		getContentPane().add(txfIdeal);
		txfIdeal.setBounds(75, 100, 75, 20);
		
		txfMax = new JTextField();
		getContentPane().add(txfMax);
		txfMax.setBounds(75, 125, 75, 20);
		
		btnOpret = new JButton("Opret");
		getContentPane().add(btnOpret);
		btnOpret.setBounds(25, 375, 125, 50);
		btnOpret.addActionListener(controller);
		
		btnRediger = new JButton("Rediger");
		getContentPane().add(btnRediger);
		btnRediger.setBounds(162, 375, 125, 50);
		btnRediger.addActionListener(controller);
		
		btnSlet = new JButton("Slet");
		getContentPane().add(btnSlet);
		btnSlet.setBounds(299, 375, 125, 50);
		btnSlet.addActionListener(controller);
		
		lblListeDelBehandlinger = new JLabel("Liste med Delbehandlinger");
		getContentPane().add(lblListeDelBehandlinger);
		lblListeDelBehandlinger.setBounds(200, 5, 150, 20);
		
		delbehandlinger = new DefaultListModel();
		
		lstDelBehandlinger = new JList();
		getContentPane().add(lstDelBehandlinger);
		lstDelBehandlinger.setBounds(200, 25, 200, 200);
		lstDelBehandlinger.setModel(delbehandlinger);
		lstDelBehandlinger.addListSelectionListener(controller);
		
		updateDelbehandlinger();
		
	}
	
	private void updateDelbehandlinger(){
		delbehandlingList = Service.getInstance().getAlleDelbehandlinger();

		delbehandlinger.removeAllElements();
		for(int i = 0; i < delbehandlingList.size(); i++){
			delbehandlinger.addElement(delbehandlingList.get(i));
		}
	}
		
	private class Controller implements ActionListener, ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(lstDelBehandlinger.isSelectionEmpty()){
			} else {
				selectedValue = (Delbehandling) lstDelBehandlinger.getSelectedValue();
				txfNavn.setText(selectedValue.getNavn());
				txfID.setText("" + selectedValue.getBatchID());
				txfMin.setText("" + selectedValue.getMinimumsTørretid());
				txfIdeal.setText("" + selectedValue.getIdealTørretid());
				txfMax.setText("" + selectedValue.getMaximalTørretid());
			}
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnOpret){
				Service.getInstance().createDelbehandling(Integer.parseInt(txfMin.getText()), Integer.parseInt(txfIdeal.getText()), Integer.parseInt(txfMax.getText()), txfNavn.getText(), Integer.parseInt(txfID.getText()));
			}
			if(e.getSource() == btnRediger){
				Service.getInstance().updateDelbehandling((Delbehandling) lstDelBehandlinger.getSelectedValue(), Integer.parseInt(txfMin.getText()), Integer.parseInt(txfIdeal.getText()), Integer.parseInt(txfMax.getText()), txfNavn.getText(), Integer.parseInt(txfID.getText()));
			}
			if(e.getSource() == btnSlet){
				Service.getInstance().deleteDelbehandling((Delbehandling) lstDelBehandlinger.getSelectedValue());
			}
			txfNavn.setText("");
			txfID.setText("");
			txfMin.setText("");
			txfIdeal.setText("");
			txfMax.setText("");
			lstDelBehandlinger.setSelectedIndex(-1);
			updateDelbehandlinger();
			
		}
	}

	
	
}
