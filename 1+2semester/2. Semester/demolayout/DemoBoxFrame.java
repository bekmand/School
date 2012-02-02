package demolayout;



import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoBoxFrame extends JFrame {
	private JButton but1;
	private JButton but2;	
	private JButton but3; 
	private JButton but4;
	private JButton but5;
	private JPanel panel;
	public DemoBoxFrame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		this.setTitle("Frame med boxlayuot");
		this.setLocation(50,50);
		
		
		but1 = new JButton("Knap1");
		but2 = new JButton("Knap2");
		but3 = new JButton("Knap3 med lang tekst");
		but4 = new JButton("Knap4");
		but5 = new JButton("Knap5");
		panel.add(but1);
		panel.add(but2);
		panel.add(but3);
		panel.add(but4);
		panel.add(but5);
		this.add(panel);
		
		this.pack();
		
		

		
	}
}
