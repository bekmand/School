package demolayout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DemoMixedFrame extends JFrame {
	private JPanel gridPanelCenter;
	private JPanel boxPanelEast;
	private JPanel flowPanelNorth;
	private JButton but1;
	private JButton but2;	
	private JButton but3; 
	private JButton but4;
	private JButton but5;
	private JPanel panel;
	public DemoMixedFrame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setTitle("Frame med broderlayuot");
		this.setLocation(50,50);
		
		gridPanelCenter = new JPanel(new GridLayout(3,3));
		boxPanelEast = new JPanel();
		boxPanelEast.setLayout(new BoxLayout(boxPanelEast,BoxLayout.Y_AXIS));
		flowPanelNorth = new JPanel(new FlowLayout());
				
		gridPanelCenter.add(new JButton("1"));
		gridPanelCenter.add(new JButton("2"));
		gridPanelCenter.add(new JButton("3"));
		gridPanelCenter.add(new JButton("4"));
		gridPanelCenter.add(new JButton("5"));
		gridPanelCenter.add(new JButton("6"));
		gridPanelCenter.add(new JButton("7"));
		gridPanelCenter.add(new JButton("8"));
		gridPanelCenter.add(new JButton("9"));
		
		boxPanelEast.add(new JLabel("En tekst"));
		boxPanelEast.add(new JLabel("To tekst"));
		boxPanelEast.add(new JLabel("Tre tekst"));
		boxPanelEast.add(new JLabel("Fire tekst"));
		boxPanelEast.add(new JLabel("Fem tekst"));

		
		but1 = new JButton("Knap1");
		but2 = new JButton("Knap2");
		but3 = new JButton("Knap3");
		but4 = new JButton("Knap4 med stor tekst");
		but5 = new JButton("Knap5");
		flowPanelNorth.add(but1);
		flowPanelNorth.add(but2);
		flowPanelNorth.add(but3);
		flowPanelNorth.add(but4);
		flowPanelNorth.add(but5);
		
		this.add(gridPanelCenter,BorderLayout.CENTER);
		this.add(boxPanelEast, BorderLayout.EAST);
		this.add(flowPanelNorth, BorderLayout.NORTH);

		this.pack();
		
		

		
	}
}
