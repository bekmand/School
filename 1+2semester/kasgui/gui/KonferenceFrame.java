package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class KonferenceFrame extends JFrame{
	private JButton btnOpret;
	private JTextField txfNavn, txfAdresse, txfDato1, txfDato2, txfPris;
	private JLabel lblNavn, lblAdresse, lblDato1, lblDato2, lblPris;
	
	private Controller controller = new Controller();

	public KonferenceFrame() {
		this.setTitle("Konference");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocation(500, 200);
		this.setSize(485, 300);
		this.setLayout(null);
		
		btnOpret = new JButton("Opret");
		this.add(btnOpret);
		btnOpret.setLocation(20, 273);
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
		
		lblDato1 = new JLabel("Ankomst Dato:");
		this.add(lblDato1);
		lblDato1.setLocation(20, 135);
		lblDato1.setSize(72, 20);
		
		lblDato2 = new JLabel("Afrejse Dato:");
		this.add(lblDato2);
		lblDato2.setLocation(20, 180);
		lblDato2.setSize(72, 20);
		
		lblPris = new JLabel("Konference Pris:");
		this.add(lblPris);
		lblPris.setLocation(20, 215);
		lblPris.setSize(72, 20);
		
		txfNavn = new JTextField();
		this.add(txfNavn);
		txfNavn.setLocation(120, 45);
		txfNavn.setSize(270, 20);
		
		txfAdresse = new JTextField();
		this.add(txfAdresse);
		txfAdresse.setLocation(120, 90);
		txfAdresse.setSize(270, 20);
		
		txfDato1 = new JTextField();
		this.add(txfDato1);
		txfDato1.setLocation(120, 135);
		txfDato1.setSize(270, 20);
		
		txfDato2 = new JTextField();
		this.add(txfDato2);
		txfDato2.setLocation(120, 180);
		txfDato2.setSize(270, 20);
		
		txfPris = new JTextField();
		this.add(txfPris);
		txfPris.setLocation(120, 225);
		txfPris.setSize(270, 20);

}
}
