package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import service.Service;

public class HotelFrame extends JFrame{
	private JButton btnOpret;
	private JTextField txfNavn, txfPrisE, txfPrisD, txfTillæg;
	private JLabel lblNavn, lblPrisE, lblPrisD, lblTillæg;
	
	private Controller controller = new Controller();

	public HotelFrame() {
		this.setTitle("Hotel");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocation(600, 100);
		this.setSize(450, 300);
		this.setLayout(null);
		
		btnOpret = new JButton("Opret");
		this.add(btnOpret);
		btnOpret.setLocation(20, 228);
		btnOpret.setSize(70, 25);
		btnOpret.addActionListener(controller);

		lblNavn = new JLabel("Navn:");
		this.add(lblNavn);
		lblNavn.setLocation(20, 45);
		lblNavn.setSize(62, 20);
		
		lblPrisE = new JLabel("Pris Enkelt:");
		this.add(lblPrisE);
		lblPrisE.setLocation(20, 90);
		lblPrisE.setSize(62, 20);
		
		lblPrisD = new JLabel("Pris Dobbelt:");
		this.add(lblPrisD);
		lblPrisD.setLocation(20, 135);
		lblPrisD.setSize(62, 20);
		
		lblTillæg = new JLabel("Tillæg:");
		this.add(lblTillæg);
		lblTillæg.setLocation(20, 180);
		lblTillæg.setSize(62, 20);
		
		txfNavn = new JTextField();
		this.add(txfNavn);
		txfNavn.setLocation(120, 45);
		txfNavn.setSize(270, 20);
		
		txfPrisE = new JTextField();
		this.add(txfPrisE);
		txfPrisE.setLocation(120, 90);
		txfPrisE.setSize(270, 20);
		
		txfPrisD = new JTextField();
		this.add(txfPrisD);
		txfPrisD.setLocation(120, 135);
		txfPrisD.setSize(270, 20);
		
		txfTillæg = new JTextField();
		this.add(txfTillæg);
		txfTillæg.setLocation(120, 180);
		txfTillæg.setSize(270, 20);
		
		this.setVisible(false);
}
	private class Controller implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == btnOpret){
				Service.opretHotel(txfNavn.getText(), Double.parseDouble(txfPrisE.getText()), Double.parseDouble(txfPrisD.getText()), Double.parseDouble(txfTillæg.getText()));
				
				HotelFrame.this.setVisible(false);
			}
}
}
}