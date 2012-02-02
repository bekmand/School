package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InformationFrame extends JFrame{
private JButton btnKonference, btnHotel, btnUdflugter, btnClear;
private JTextArea txaBox;

private Controller controller = new Controller();

public InformationFrame() {
	this.setTitle("Information");
	this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	this.setLocation(500, 200);
	this.setSize(450, 300);
	this.setLayout(null);
	
	btnKonference = new JButton("Konference");
	this.add(btnKonference);
	btnKonference.setLocation(20, 80);
	btnKonference.setSize(80, 25);
	btnKonference.addActionListener(controller);
	
	btnHotel = new JButton("Hotel");
	this.add(btnHotel);
	btnHotel.setLocation(20, 120);
	btnHotel.setSize(80, 25);
	btnHotel.addActionListener(controller);
	
	btnUdflugter = new JButton("Udflugter");
	this.add(btnUdflugter);
	btnUdflugter.setLocation(20, 160);
	btnUdflugter.setSize(80, 25);
	btnUdflugter.addActionListener(controller);
	
	btnClear = new JButton("Clear");
	this.add(btnClear);
	btnClear.setLocation(360, 240);
	btnClear.setSize(80, 25);
	btnClear.addActionListener(controller);
	
	txaBox = new JTextArea();
	this.add(txaBox);
	txaBox.setEditable(false);
	txaBox.setFocusable(false);
	txaBox.setLocation(100, 50);
	txaBox.setSize(347, 160);
	
	this.setVisible(false);

}
}
