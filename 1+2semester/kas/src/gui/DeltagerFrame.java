package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import service.Service;

public class DeltagerFrame extends JFrame{
	private JButton btnOpret;
	private JTextField txfNavn, txfAdresse, txfBy, txfLand, txfTlf, txfFnavn, txfFtlf, txfLedsager, txfDato1, txfDato2;
	private JLabel lblNavn, lblAdresse, lblBy, lblLand, lblTlf, lblFnavn, lblFtlf, lblLedsager, lblLedc, lbldato1, lbldato2;
	private JCheckBox Ledsager;
	
	private Controller controller = new Controller();

	public DeltagerFrame() {
		this.setTitle("Konference");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocation(600, 100);
		this.setSize(600, 600);
		this.setLayout(null);
		
		btnOpret = new JButton("Opret");
		this.add(btnOpret);
		btnOpret.setLocation(20, 488);
		btnOpret.setSize(70, 25);
		btnOpret.addActionListener(controller);

		lblNavn = new JLabel("Navn");
		this.add(lblNavn);
		lblNavn.setLocation(20, 45);
		lblNavn.setSize(62, 20);
		
		lblAdresse = new JLabel("Adresse");
		this.add(lblAdresse);
		lblAdresse.setLocation(20, 90);
		lblAdresse.setSize(72, 20);
		
		lblBy = new JLabel("By");
		this.add(lblBy);
		lblBy.setLocation(20, 135);
		lblBy.setSize(72, 20);
		
		lblLand = new JLabel("Land:");
		this.add(lblLand);
		lblLand.setLocation(20, 180);
		lblLand.setSize(72, 20);
	
		lbldato1 = new JLabel("Ank. Dato");
		this.add(lbldato1);
		lbldato1.setLocation(20, 220);
		lbldato1.setSize(72, 20);
		
		lblTlf = new JLabel("Telefon:");
		this.add(lblTlf);
		lblTlf.setLocation(20, 260);
		lblTlf.setSize(72, 20);
		
		lblFnavn = new JLabel("Firma Navn:");
		this.add(lblFnavn);
		lblFnavn.setLocation(20, 305);
		lblFnavn.setSize(72, 20);
		
		lblFtlf = new JLabel("Firma Telefon:");
		this.add(lblFtlf);
		lblFtlf.setLocation(20, 350);
		lblFtlf.setSize(72, 20);
		
		lblLedc = new JLabel ("Ledsager:");
		this.add(lblLedc);
		lblLedc.setLocation(20, 395);
		lblLedc.setSize(72, 20);
		
		lblLedsager = new JLabel("Ledsager Navn:");
		this.add(lblLedsager);
		lblLedsager.setLocation(20, 440);
		lblLedsager.setSize(100, 20);
		
		
		txfNavn = new JTextField();
		this.add(txfNavn);
		txfNavn.setLocation(120, 45);
		txfNavn.setSize(270, 20);
		
		txfAdresse = new JTextField();
		this.add(txfAdresse);
		txfAdresse.setLocation(120, 90);
		txfAdresse.setSize(270, 20);
		
		txfBy = new JTextField();
		this.add(txfBy);
		txfBy.setLocation(120, 135);
		txfBy.setSize(270, 20);
		
		txfLand = new JTextField();
		this.add(txfLand);
		txfLand.setLocation(120, 180);
		txfLand.setSize(270, 20);
		
		txfDato1 = new JTextField();
		this.add(txfDato1);
		txfDato1.setLocation(120, 220);
		txfDato1.setSize(135, 20);
		
		txfDato2 = new JTextField();
		this.add(txfDato2);
		txfDato2.setLocation(300, 220);
		txfDato2.setSize(135, 20);
		
		txfTlf = new JTextField();
		this.add(txfTlf);
		txfTlf.setLocation(120, 260);
		txfTlf.setSize(270, 20);
		
		txfFnavn = new JTextField();
		this.add(txfFnavn);
		txfFnavn.setLocation(120, 305);
		txfFnavn.setSize(270, 20);
		
		txfFtlf = new JTextField();
		this.add(txfFtlf);
		txfFtlf.setLocation(120, 350);
		txfFtlf.setSize(270, 20);
		
		txfLedsager = new JTextField();
		this.add(txfLedsager);
		txfLedsager.setLocation(120, 440);
		txfLedsager.setSize(270, 20);
		
		Ledsager = new JCheckBox();
		this.add(Ledsager);
		Ledsager.setLocation(120, 395);
		Ledsager.setSize(20, 20);
}
	private class Controller implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == btnOpret){
				Service.opretDeltager(txfNavn.getText(), Service.getDeltagerNr(), txfAdresse.getText(), 
						txfBy.getText(), txfLand.getText(), Integer.parseInt(txfTlf.getText()), Double.parseDouble(txfDato1.getText()), 
						Double.parseDouble(txfDato2.getText()), rootPaneCheckingEnabled);
				if(Ledsager.isEnabled()){
					Service.opretLedsager(txfLedsager.getText(), txfNavn.getText(), Service.getDeltagerNr());
				}
				DeltagerFrame.this.setVisible(false);
			}
			
		}
}
}