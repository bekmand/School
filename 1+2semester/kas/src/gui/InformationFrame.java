package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import service.Service;

public class InformationFrame extends JFrame{
private JButton btnKonference, btnHotel, btnUdflugter, btnClear;
private JScrollPane scpInf;
private JList lstHotel;


private Controller controller = new Controller();

public InformationFrame() {
	this.setTitle("Information");
	this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	this.setLocation(600, 100);
	this.setSize(550, 300);
	this.setLayout(null);
	
	lstHotel = new JList();
	lstHotel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	lstHotel.addListSelectionListener(controller);
	
	btnKonference = new JButton("Konferencer");
	this.add(btnKonference);
	btnKonference.setLocation(20, 80);
	btnKonference.setSize(100, 25);
	btnKonference.addActionListener(controller);
	
	btnHotel = new JButton("Hoteller");
	this.add(btnHotel);
	btnHotel.setLocation(20, 120);
	btnHotel.setSize(100, 25);
	btnHotel.addActionListener(controller);
	
	btnUdflugter = new JButton("Udflugter");
	this.add(btnUdflugter);
	btnUdflugter.setLocation(20, 160);
	btnUdflugter.setSize(100, 25);
	btnUdflugter.addActionListener(controller);
	
	btnClear = new JButton("Clear");
	this.add(btnClear);
	btnClear.setLocation(360, 240);
	btnClear.setSize(80, 25);
	btnClear.addActionListener(controller);
	
	scpInf = new JScrollPane(lstHotel);
	this.add(scpInf);
	scpInf.setLocation(150, 50);
	scpInf.setSize(347, 160);
}

private class Controller implements ActionListener, ListSelectionListener{
	

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnHotel) {

				lstHotel.setListData(Service.getAllHotel().toArray());
			}
			else if (e.getSource() == btnKonference) {

				lstHotel.setListData(Service.getAllKonferrence().toArray());
				}
			else if (e.getSource() == btnUdflugter){
				lstHotel.setListData(Service.getAllUdflugter().toArray());
			}
			}


	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == lstHotel) {
			if (!e.getValueIsAdjusting()) {
				this.updateView();
	}			
		}
}
	

	private void updateView() {
		// TODO Auto-generated method stub
		
	}
}
}