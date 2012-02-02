package demolayout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoBorderFrame extends JFrame {
	private JButton but1;
	private JButton but2;	
	private JButton but3; 
	private JButton but4;
	private JButton but5;
	private JPanel panel;
	public DemoBorderFrame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setTitle("Frame med broderlayuot");
		this.setLocation(50,50);
		
		
		but1 = new JButton("Knap1");
		but2 = new JButton("Knap2");
		but3 = new JButton("Knap3");
		but4 = new JButton("Knap4 med stor tekst");
		but5 = new JButton("Knap5");
		this.add(but1, BorderLayout.NORTH);
		this.add(but2, BorderLayout.EAST);
		this.add(but3, BorderLayout.SOUTH);
		this.add(but4, BorderLayout.WEST);
		this.add(but5, BorderLayout.EAST);
		
		this.pack();
		
		

		
	}
}
