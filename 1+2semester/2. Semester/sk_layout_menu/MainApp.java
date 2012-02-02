package sk_layout_menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class MainApp extends JFrame {

	private JPanel contentPane;
	private JMenuItem mItemRoed;
	private JMenuItem mItemHvid;
	private JMenuItem mItemSort;
	private JMenuItem mItemBlaa;
	private JMenuItem mItemRoed2;
	private JMenuItem mItemHvid2;
	private JMenuItem mItemSort2;
	private JMenuItem mItemLightGrey;
	private JMenuItem mItemDarkGrey;
	private JMenuItem mItemLightGrey2;
	private JMenuItem mItemDarkGrey2;
	private JPanel panel;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
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
	public MainApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		
		this.setJMenuBar(menuBar);
		
		JMenu menuA = new JMenu("Tekst farve");
        menuA.setMnemonic(KeyEvent.VK_Q);
        menuBar.add(menuA);

        JMenu menuB = new JMenu("Baggrunds farve");
        menuB.setMnemonic(KeyEvent.VK_W);
        menuBar.add(menuB);
        
        menuA.addSeparator();
        menuB.addSeparator();
        
        JMenu submenuA = new JMenu("Mere");
        submenuA.setMnemonic(KeyEvent.VK_Z);
        menuA.add(submenuA);
        
        JMenu submenuB = new JMenu("Mere");
        submenuA.setMnemonic(KeyEvent.VK_X);
        menuB.add(submenuB);
		
        ActionListener menuObservere = new MenuObserver();
        
        mItemBlaa = new JMenuItem("Blå", KeyEvent.VK_B);
        mItemBlaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
        mItemBlaa.addActionListener(menuObservere);
        menuA.add(mItemBlaa);
        
        mItemRoed = new JMenuItem("Rød", KeyEvent.VK_R);
        mItemRoed.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
        mItemRoed.addActionListener(menuObservere);
        menuA.add(mItemRoed);
        
        
        mItemHvid = new JMenuItem("Hvid", KeyEvent.VK_H);
        mItemHvid.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
        mItemHvid.addActionListener(menuObservere);
        menuA.add(mItemHvid);
        
        
        mItemSort = new JMenuItem("Sort", KeyEvent.VK_S);
        mItemSort.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        mItemSort.addActionListener(menuObservere);
        menuA.add(mItemSort);
        
        mItemRoed2 = new JMenuItem("Rød", KeyEvent.VK_R);
        mItemRoed2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK));
        mItemRoed2.addActionListener(menuObservere);
        menuB.add(mItemRoed2);
        
        
        mItemHvid2 = new JMenuItem("Hvid", KeyEvent.VK_H);
        mItemHvid2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.ALT_DOWN_MASK));
        mItemHvid2.addActionListener(menuObservere);
        menuB.add(mItemHvid2);
        
        
        mItemSort2 = new JMenuItem("Sort", KeyEvent.VK_S);
        mItemSort2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
        mItemSort2.addActionListener(menuObservere);
        menuB.add(mItemSort2);
        
        mItemLightGrey = new JMenuItem("Lys grå", KeyEvent.VK_L);
        mItemLightGrey.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
        mItemLightGrey.addActionListener(menuObservere);
        submenuA.add(mItemLightGrey);
        
        mItemDarkGrey = new JMenuItem("Mørk Grå", KeyEvent.VK_M);
        mItemDarkGrey.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
        mItemDarkGrey.addActionListener(menuObservere);
        submenuA.add(mItemDarkGrey);
        
        mItemLightGrey2 = new JMenuItem("Lys grå", KeyEvent.VK_L);
        mItemLightGrey2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_DOWN_MASK));
        mItemLightGrey2.addActionListener(menuObservere);
        submenuB.add(mItemLightGrey2);
        
        mItemDarkGrey2 = new JMenuItem("Mørk Grå", KeyEvent.VK_M);
        mItemDarkGrey2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_DOWN_MASK));
        mItemDarkGrey2.addActionListener(menuObservere);
        submenuB.add(mItemDarkGrey);
        
        
	}
	
	private class MenuObserver implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == mItemRoed){
				textField.setForeground(Color.red);
			}
			else if(e.getSource() == mItemRoed){
				textField.setForeground(Color.red);
			}
			else if(e.getSource() == mItemRoed2){
				textField.setBackground(Color.red);
			}
			else if(e.getSource() == mItemHvid){
				textField.setForeground(Color.white);
			}
			else if(e.getSource() == mItemHvid2){
				textField.setBackground(Color.white);
			}
			else if(e.getSource() == mItemSort){
				textField.setForeground(Color.black);
			}
			else if(e.getSource() == mItemSort2){
				textField.setForeground(Color.black);
			}
			else if(e.getSource() == mItemBlaa){
				textField.setForeground(Color.blue);
			}
			else if(e.getSource() == mItemLightGrey){
				textField.setForeground(Color.LIGHT_GRAY);
			}
			else if(e.getSource() == mItemDarkGrey){
				textField.setBackground(Color.DARK_GRAY);
			}
			else if(e.getSource() == mItemLightGrey2){
				textField.setForeground(Color.LIGHT_GRAY);
			}
			else if(e.getSource() == mItemDarkGrey2){
				textField.setBackground(Color.DARK_GRAY);
			}
			
			
		}
		
	}

}
