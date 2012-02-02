package eksempel3;

import javax.swing.JFrame;


public class MainFrame extends JFrame {
	private TegnePanel pnlTegning;
	public MainFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Eksempel3");
		this.setLocation(200, 100);
		this.setSize(320, 280);
		
		pnlTegning = new TegnePanel();
		this.add(pnlTegning);
		pnlTegning.setLocation(5, 5);
		pnlTegning.setSize(300,260);
	}
}
