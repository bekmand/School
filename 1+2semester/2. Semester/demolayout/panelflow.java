package demolayout;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class panelflow extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton jButton1 = null;
	private JLabel jLabel = null;
	private JButton jButton2 = null;
	private JLabel jLabel2 = null;
	private JTextField jTextField = null;

	/**
	 * This is the default constructor
	 */
	public panelflow() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel2 = new JLabel();
		jLabel2.setText("JLabel");
		jLabel = new JLabel();
		jLabel.setText("JLabel");
		this.setSize(300, 200);
		this.setLayout(new FlowLayout());
		this.add(getJButton1(), null);
		this.add(jLabel, null);
		this.add(getJButton2(), null);
		this.add(jLabel2, null);
		this.add(getJTextField(), null);
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("ok");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getJTextField().setText("her er en tekst");
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
		}
		return jButton2;
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
