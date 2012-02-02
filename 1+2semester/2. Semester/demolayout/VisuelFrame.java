package demolayout;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VisuelFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButtonok = null;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	/**
	 * This is the default constructor
	 */
	public VisuelFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setText("Ledetejst");
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJButtonok(), BorderLayout.SOUTH);
			jContentPane.add(jLabel, BorderLayout.WEST);
			jContentPane.add(getJTextField(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonok() {
		if (jButtonok == null) {
			jButtonok = new JButton();
			jButtonok.setText("OK");
			jButtonok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getJTextField().setText("Der er klikket");
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonok;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
		}
		return jTextField;
	}

}
