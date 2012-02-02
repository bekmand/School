package gui;

import javax.swing.*;

import service.Service;
import model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

	private static JLabel lblAntalPass, lblIndReg, lblTurText, lblStart,
			lblSlut;
	private static JButton btnOpret, btnHent, btnGem, btnVis, btnVisAlle;
	private static JTextField txfAntalPass, txfIndReg, txfStart, txfSlut;

	private Controller controller = new Controller();

	public MainFrame() {
		this.setTitle("SK Eksamen Juni 2011");
		this.setSize(400, 430);
		this.setLocation(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		

		lblAntalPass = new JLabel("Antal Passagerer    :");
		lblAntalPass.setSize(100, 25);
		lblAntalPass.setLocation(20, 20);
		this.add(lblAntalPass);
		
		txfAntalPass = new JTextField();
		txfAntalPass.setSize(100, 25);
		txfAntalPass.setLocation(125, 20);
		this.add(txfAntalPass);

		lblIndReg = new JLabel("Indregistrerings År :");
		lblIndReg.setSize(100, 25);
		lblIndReg.setLocation(20, 55);
		this.add(lblIndReg);
		
		txfIndReg = new JTextField();
		txfIndReg.setSize(100, 25);
		txfIndReg.setLocation(125, 20);
		this.add(txfIndReg);
		
		lblTurText = new JLabel("Ture en bus har kørt mellem ");
		lblTurText.setSize(150, 25);
		lblTurText.setLocation(20, 150);
		this.add(lblTurText);
		
		lblStart = new JLabel("Start :");
		lblStart.setSize(100, 25);
		lblStart.setLocation(20, 180);
		this.add(lblStart);
		
		txfStart = new JTextField();
		txfStart.setSize(100, 25);
		txfStart.setLocation(125, 180);
		this.add(txfStart);
		
		lblSlut = new JLabel("Slut  :");
		lblSlut.setSize(100, 25);
		lblSlut.setLocation(20, 228);
		this.add(lblSlut);
		
		txfSlut = new JTextField();
		txfSlut.setSize(100, 25);
		txfSlut.setLocation(125, 228);
		this.add(txfSlut);
		
		btnOpret = new JButton("Opret");
		btnOpret.setSize(70, 25);
		btnOpret.setLocation(20, 90);
		this.add(btnOpret);
		
		btnHent = new JButton("Hent");
		btnHent.setSize(70,	25);
		btnHent.setLocation(95,	90);
		this.add(btnHent);
		
		btnGem = new JButton("Gem");
		btnGem.setSize(70, 25);
		btnGem.setLocation(170, 90);
		this.add(btnGem);
		
		btnVis = new JButton("Vis");
		btnVis.setSize(70,25);
		btnVis.setLocation(20, 265);
		this.add(btnVis);
		
	}

	private class Controller implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnOpret){
				Service.addBus(txfAntalPass, txfIndReg);
			}
			if(e.getSource() == btnHent){
				txfAntalPass.setText(Service.getBusser().get(1).getAntalPassagerer());
				txfIndReg.setText(Service.getBusser().get(1).getIndregistreringsår());
			}
			if(e.getSource() == btnGem){
				
			}
			if(e.getSource() == btnVis){
				txfStart.setText(Service.getBusser().get(1).getAntalTurer(txfStart.getText(), txfSlut.getText()));
			}

		}
	}
}
