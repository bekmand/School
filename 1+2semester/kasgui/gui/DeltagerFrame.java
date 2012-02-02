package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DeltagerFrame extends JFrame{
	private JButton btnOpret;
	private JTextField txfNavn, txfAdresse, txfBy, txfLand, txfTlf, txfFnavn, txfFtlf, txfLedsager;
	private JLabel lblNavn, lblAdresse, lblBy, lblLand, lblTlf, lblFnavn, lblFtlf, lblLedsager;
	private JCheckBox Ledsager;
	
	private Controller controller = new Controller();

	public DeltagerFrame() {
		this.setTitle("Konference");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocation(500, 200);
		this.setSize(600, 300);
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
		
		lblLedsager = new JLabel("Ledsager:");
		this.add(lblLedsager);
		lblLedsager.setLocation(20, 395);
		lblLedsager.setSize(72, 20);
		
		
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
		Ledsager.setLocation(20, 395);
		Ledsager.setSize(20, 20);
}
	private class Controller implements ActionListener{
}
}