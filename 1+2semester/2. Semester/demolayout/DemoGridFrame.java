package demolayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoGridFrame extends JFrame {
	private JButton but1;
	private JButton but2;	
	private JButton but3; 
	private JButton but4;
	private JButton but5;
	
	public DemoGridFrame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(4,2));
		this.setTitle("Frame med gridlayuot");
		this.setLocation(50,50);
		
		
		but1 = new JButton("Knap1");
		but2 = new JButton("Knap2");
		but3 = new JButton("Knap3");
		but4 = new JButton("Knap4");
		but5 = new JButton("Knap5");
		this.add(but1);
		this.add(but2);
		this.add(but3);
		this.add(but4);
		this.add(but5);
		
		this.pack();
		
		

		
	}
}
