package gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Behandling;
import model.Mellemvare;

import service.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class VarePane extends JFrame {
	
	private JLabel lblNavn, lblAntal, lblID, lblListVare, lblCbBehandlinger;
	private JTextField txfNavn, txfAntal, txfID;
	private JList lstVare;
	private JComboBox cbBehandlinger;
	private JButton btnOpret, btnRediger, btnSlet;
	private Controller controller = new Controller();
	private DefaultListModel varer;
	private DefaultComboBoxModel model;
	private List<Mellemvare> mellemvarer;
	private List<Behandling> behandlinger;
	private Mellemvare selectedValue = null;

	public VarePane() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Carletti LK - Vare");
		setBounds(313, 100, 462, 500);
		getContentPane().setLayout(null);
		
		lblNavn = new JLabel("Navn: ");
		getContentPane().add(lblNavn);
		lblNavn.setBounds(25, 25, 50, 20);
		
		lblAntal = new JLabel("Antal: ");
		getContentPane().add(lblAntal);
		lblAntal.setBounds(25, 50, 50, 20);
		
		lblID = new JLabel("ID: ");
		getContentPane().add(lblID);
		lblID.setBounds(25, 75, 50, 20);
		
		txfNavn = new JTextField();
		getContentPane().add(txfNavn);
		txfNavn.setBounds(75, 25, 75, 20);
		
		txfAntal = new JTextField();
		getContentPane().add(txfAntal);
		txfAntal.setBounds(75, 50, 75, 20);
		
		txfID = new JTextField();
		getContentPane().add(txfID);
		txfID.setBounds(75, 75, 75, 20);
		
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
		
		lblCbBehandlinger = new JLabel("Vælg Behandling: ");
		getContentPane().add(lblCbBehandlinger);
		lblCbBehandlinger.setBounds(25, 100, 125, 20);
		
		model = new DefaultComboBoxModel();
		
		cbBehandlinger = new JComboBox();
		getContentPane().add(cbBehandlinger);
		cbBehandlinger.setBounds(25, 125, 125, 20);
		cbBehandlinger.setModel(model);
		
		
		lblListVare = new JLabel("Liste med Vare");
		getContentPane().add(lblListVare);
		lblListVare.setBounds(200, 5, 100, 20);
		
		varer = new DefaultListModel();
		
		lstVare = new JList();
		getContentPane().add(lstVare);
		lstVare.setBounds(200, 25, 200, 200);
		lstVare.setModel(varer);
		lstVare.addListSelectionListener(controller);
		
		
		updateMellemvarer();
		updateBehandlinger();
		
	}
	
	public void updateBehandlinger(){
		behandlinger = Service.getInstance().getAlleBehandlinger();

		model.removeAllElements();
		model.addElement("Ingen Behandling");
		for(int i = 0; i < behandlinger.size(); i++){
			model.addElement(behandlinger.get(i));
		}
	}
	
	public void updateMellemvarer(){
		mellemvarer = Service.getInstance().getAlleMellemvarer();
		
		varer.removeAllElements();
		for(int i = 0; i < mellemvarer.size(); i++){
			varer.addElement(mellemvarer.get(i));
		}
		lstVare.setModel(varer);
	}
	
	private class Controller implements ActionListener, ListSelectionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnOpret){
				Service.getInstance().createMellemvare(txfNavn.getText(), Integer.parseInt(txfAntal.getText()), Integer.parseInt(txfID.getText()));
				if(cbBehandlinger.getSelectedItem().equals("Ingen Behandling")){
				} else {
					Service.getInstance().setBehandlingTilMellemvare(Service.getInstance().getMellemvare(Integer.parseInt(txfID.getText())), (Behandling) cbBehandlinger.getSelectedItem());
				}
				
			}
			if(e.getSource() == btnRediger){
				Service.getInstance().updateMellemvare((Mellemvare) lstVare.getSelectedValue(), txfNavn.getText(), Integer.parseInt(txfAntal.getText()), Integer.parseInt(txfID.getText()));
			}
			if(e.getSource() == btnSlet){
				Service.getInstance().deleteMellemvare((Mellemvare) lstVare.getSelectedValue());
			}
			txfNavn.setText("");
			txfAntal.setText("");
			txfID.setText("");
			cbBehandlinger.setSelectedIndex(0);
			lstVare.setSelectedIndex(-1);
			updateMellemvarer();
			
		}

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			if(lstVare.isSelectionEmpty()){
			} else {
				selectedValue = (Mellemvare) lstVare.getSelectedValue();
				txfNavn.setText(selectedValue.getNavn());
				txfAntal.setText("" + selectedValue.getAntal());
				txfID.setText("" + selectedValue.getBatchID());
				if(selectedValue.getBehandling() != null){
					cbBehandlinger.setSelectedItem(selectedValue.getBehandling());
				}else{
					cbBehandlinger.setSelectedItem("Ingen Behandling");
				}
			}
			
		}
	}

}
