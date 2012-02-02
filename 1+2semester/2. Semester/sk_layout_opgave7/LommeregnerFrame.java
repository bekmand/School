package sk_layout_opgave7;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LommeregnerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LommeregnerFrame frame = new LommeregnerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LommeregnerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOperations = new JMenu("Operations");
		menuBar.add(mnOperations);
		
		JMenuItem mntmAdd = new JMenuItem("Add");
		mnOperations.add(mntmAdd);
		
		JMenuItem mntmSubtract = new JMenuItem("Subtract");
		mnOperations.add(mntmSubtract);
		
		JMenuItem mntmMultiply = new JMenuItem("multiply");
		mnOperations.add(mntmMultiply);
		
		JMenuItem mntmDivide = new JMenuItem("divide");
		mnOperations.add(mntmDivide);
		
		JMenu mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNummer = new JLabel("Nummer 1:");
		panel.add(lblNummer);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNummer_1 = new JLabel("Nummer 2:");
		panel.add(lblNummer_1);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblResult = new JLabel("Result:");
		panel.add(lblResult);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(8);
		
		JButton btnNewButton = new JButton("Add");
		panel.add(btnNewButton);
		
		JButton btnSubstract = new JButton("Substract");
		panel.add(btnSubstract);
		
		JButton btnMultiply = new JButton("Multiply");
		panel.add(btnMultiply);
		
		JButton btnDivide = new JButton("Divide");
		panel.add(btnDivide);
	}

}
