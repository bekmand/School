package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import service.Service;



public class MainFrame extends JFrame {
	private JButton btnHotel, btnKonference, btnDeltager, btnInformation;
	
	private HotelFrame hotelFrame;
	private KonferenceFrame konferenceFrame;
	private DeltagerFrame deltagerFrame;
	private InformationFrame informationFrame;
	
	private Controller controller = new Controller();

	public MainFrame() {
		this.setTitle("Konference-Administrations-Systemet");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		this.setSize(450, 300);
		this.setLayout(null);
		
		btnHotel = new JButton("Hotel");
		this.add(btnHotel);
		btnHotel.setLocation(258, 20);
		btnHotel.setSize(125, 100);
		btnHotel.addActionListener(controller);
		
		btnKonference = new JButton("Konference");
		this.add(btnKonference);
		btnKonference.setLocation(50, 140);
		btnKonference.setSize(125, 100);
		btnKonference.addActionListener(controller);
		
		btnDeltager = new JButton("Deltager");
		this.add(btnDeltager);
		btnDeltager.setLocation(50, 20);
		btnDeltager.setSize(125, 100);
		btnDeltager.addActionListener(controller);
		
		btnInformation = new JButton("Information");
		this.add(btnInformation);
		btnInformation.setLocation(258, 140);
		btnInformation.setSize(125, 100);
		btnInformation.addActionListener(controller);
		
		hotelFrame = new HotelFrame();
		konferenceFrame = new KonferenceFrame();
		deltagerFrame = new DeltagerFrame();
		informationFrame = new InformationFrame();
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Service.closeDown();
			}
		});

	}
		private class Controller implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnHotel) {
					hotelFrame.setVisible(true);
				}

				if (e.getSource() == btnDeltager) {
					deltagerFrame.setVisible(true);
				}	
			

				if (e.getSource() == btnInformation) {
					informationFrame.setVisible(true);
				}	
			

				if (e.getSource() == btnKonference) {
					konferenceFrame.setVisible(true);
				}	
			}
		}
}



