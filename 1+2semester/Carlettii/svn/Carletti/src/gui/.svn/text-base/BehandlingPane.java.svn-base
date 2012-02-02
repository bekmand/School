package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Behandling;
import model.Delbehandling;
import service.Service;

public class BehandlingPane extends JFrame{
	
	private JLabel lblNavn, lblID, lblListeBehandlinger, lblListeDelbehandlinger;
	private JTextField txfNavn, txfID;
	private JButton btnOpret, btnRediger, btnSlet, btnTilføj, btnFjern;
	private JList lstBehandlinger, lstDelbehandlinger, lstDelbehandlingerListe;
	private DefaultListModel behandlingList, delbehandlingList, modelDelbehandlingAccepteret;
	private List<Behandling> behandlinger;
	private List<Delbehandling> delbehandlinger;
	private List<Delbehandling> delbehandlingerAccepteret;
	private Controller controller = new Controller();
	private Behandling selectedValue = null;
	private Delbehandling selectedValueDelbehandling = null;
	
	public BehandlingPane() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Carletti LK - Behandling");
		setBounds(313, 100, 450, 500);
		getContentPane().setLayout(null);
		
		lblNavn = new JLabel("Navn: ");
		getContentPane().add(lblNavn);
		lblNavn.setBounds(25, 25, 50, 20);
		
		lblID = new JLabel("ID: ");
		getContentPane().add(lblID);
		lblID.setBounds(25, 50, 50, 20);
		
		txfNavn = new JTextField();
		getContentPane().add(txfNavn);
		txfNavn.setBounds(75, 25, 75, 20);
		
		txfID = new JTextField();
		getContentPane().add(txfID);
		txfID.setBounds(75, 50, 75, 20);
		
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
		
		btnTilføj = new JButton("Tilføj");
		getContentPane().add(btnTilføj);
		btnTilføj.setBounds(25, 230, 74, 20);
		btnTilføj.addActionListener(controller);
		
		btnFjern = new JButton("Fjern");
		getContentPane().add(btnFjern);
		btnFjern.setBounds(100, 230, 75, 20);
		btnFjern.addActionListener(controller);
		
		behandlingList = new DefaultListModel();
		delbehandlingList = new DefaultListModel();
		modelDelbehandlingAccepteret = new DefaultListModel();
		
		behandlinger = Service.getInstance().getAlleBehandlinger();
		for(int i = 0; i < behandlinger.size(); i++){
			behandlingList.addElement(behandlinger.get(i));
		}
		
		lblListeBehandlinger = new JLabel("Liste med Behandlinger");
		getContentPane().add(lblListeBehandlinger);
		lblListeBehandlinger.setBounds(200, 5, 150, 20);
		
		lblListeDelbehandlinger = new JLabel("Liste med Delbehandling");
		getContentPane().add(lblListeDelbehandlinger);
		lblListeDelbehandlinger.setBounds(25, 75, 150, 20);
		
		lstBehandlinger = new JList();
		getContentPane().add(lstBehandlinger);
		lstBehandlinger.setBounds(200, 25, 200, 200);
		lstBehandlinger.setModel(behandlingList);
		lstBehandlinger.addListSelectionListener(controller);
		
		lstDelbehandlinger = new JList();
		getContentPane().add(lstDelbehandlinger);
		lstDelbehandlinger.setBounds(25, 100, 74, 125);
		lstDelbehandlinger.setModel(delbehandlingList);
		
		lstDelbehandlingerListe = new JList();
		getContentPane().add(lstDelbehandlingerListe);
		lstDelbehandlingerListe.setBounds(100, 100, 75, 125);
		lstDelbehandlingerListe.setModel(modelDelbehandlingAccepteret);
		
		updateBehandlinger();
		updateDelbehandlinger();
		
	}
	
	private void updateBehandlinger(){
		behandlinger = Service.getInstance().getAlleBehandlinger();
		
		behandlingList.removeAllElements();
		for(int i = 0; i < behandlinger.size(); i++){
			behandlingList.addElement(behandlinger.get(i));
		}
		lstBehandlinger.setModel(behandlingList);
	}
	
	public void updateDelbehandlinger(){
		delbehandlinger = Service.getInstance().getAlleDelbehandlinger();
		
		delbehandlingList.removeAllElements();
		for(int i = 0; i < delbehandlinger.size(); i++){
			delbehandlingList.addElement(delbehandlinger.get(i));
		}
		lstDelbehandlinger.setModel(delbehandlingList);
	}
	
	private void updateDelbehandlingerAccepteret(){
		selectedValue = (Behandling) lstBehandlinger.getSelectedValue();
		delbehandlingerAccepteret = Service.getInstance().getBehandling(selectedValue.getBatchID()).getDelbehandlinger();
		
		modelDelbehandlingAccepteret.removeAllElements();
		for(int i = 0; i < delbehandlingerAccepteret.size(); i++){
			modelDelbehandlingAccepteret.addElement(delbehandlingerAccepteret.get(i));
		}
	}
	
	private class Controller implements ActionListener, ListSelectionListener{
		
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnOpret){
				Service.getInstance().createBehandling(Integer.parseInt(txfID.getText()), txfNavn.getText());
				Behandling nyBehandling = Service.getInstance().getBehandling(Integer.parseInt(txfID.getText()));
				if(modelDelbehandlingAccepteret.size() > 0){
					for(int i = 0; i < modelDelbehandlingAccepteret.size(); i++){
						nyBehandling.addDelbehandling((Delbehandling) modelDelbehandlingAccepteret.get(i));
					}
				}
				updateBehandlinger();
				txfNavn.setText("");
				txfID.setText("");
				lstBehandlinger.setSelectedIndex(-1);
				modelDelbehandlingAccepteret.removeAllElements();
			}
			if(e.getSource() == btnRediger){
				Service.getInstance().updateBehandling((Behandling) lstBehandlinger.getSelectedValue(), txfNavn.getText(), Integer.parseInt(txfID.getText()));
				Service.getInstance().fjernAlleDelbehandlngerFraBehandling((Behandling) lstBehandlinger.getSelectedValue());
				if(modelDelbehandlingAccepteret.size() > 0){
					for(int i = 0; i < modelDelbehandlingAccepteret.size(); i++){
						Service.getInstance().getBehandling(Integer.parseInt(txfID.getText())).addDelbehandling((Delbehandling) modelDelbehandlingAccepteret.get(i));
					}
				}
				updateBehandlinger();
				txfNavn.setText("");
				txfID.setText("");
				lstBehandlinger.setSelectedIndex(-1);
				modelDelbehandlingAccepteret.removeAllElements();
			}
			if(e.getSource() == btnSlet){
				Service.getInstance().deleteBehandling((Behandling) lstBehandlinger.getSelectedValue());
				updateBehandlinger();
				txfNavn.setText("");
				txfID.setText("");
				lstBehandlinger.setSelectedIndex(-1);
				modelDelbehandlingAccepteret.removeAllElements();
			}
			if(e.getSource() == btnTilføj){
				modelDelbehandlingAccepteret.addElement(lstDelbehandlinger.getSelectedValue());
				lstDelbehandlinger.setSelectedIndex(-1);
			}
			if(e.getSource() == btnFjern){
				modelDelbehandlingAccepteret.removeElement(lstDelbehandlingerListe.getSelectedValue());
				lstDelbehandlingerListe.setSelectedIndex(-1);
			}
		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(lstBehandlinger.isSelectionEmpty()){
			} else {
				selectedValue = (Behandling) lstBehandlinger.getSelectedValue();
				txfNavn.setText(selectedValue.getNavn());
				txfID.setText(""+ selectedValue.getBatchID());
				updateDelbehandlingerAccepteret();
			}
			
			
		}
	}

}
