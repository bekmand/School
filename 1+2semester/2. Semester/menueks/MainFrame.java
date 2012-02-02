package menueks;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainFrame extends JFrame {

	private JMenuItem mItemFed;
	private JMenuItem mItemKursiv;
	private JMenuItem mItem12;
	private JMenuItem mItem18;
	
    public MainFrame() {
        // the frame's own attributtes...
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("MyGUIApp");
        this.setLocation(50,50);
        this.setSize(400,300);
 
        // controls...
        // Create the menu bar.
        JMenuBar menuBar = new JMenuBar();

        // Tilføj Frame
        this.setJMenuBar(menuBar);

        // opret menuer
        JMenu menuA = new JMenu("A Menu");
        menuA.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menuA);

        JMenu menuB = new JMenu("B Menu");
        menuB.setMnemonic(KeyEvent.VK_B);
        menuBar.add(menuB);
        
        // lav ActionListener objekt
        ActionListener menuObserver = new MenuObserver();
        
        // opret menuitems i menuA
        mItemFed = new JMenuItem("Fed", KeyEvent.VK_F);
        mItemFed.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
         mItemFed.addActionListener(menuObserver);
        menuA.add(mItemFed);

        mItemKursiv = new JMenuItem("Kursiv", KeyEvent.VK_K);
        mItemKursiv.addActionListener(menuObserver);
        menuA.add(mItemKursiv);

        // indsæt seperator
        menuA.addSeparator();

        // undermenu
        JMenu subMenu = new JMenu("Størrelse");
        subMenu.setMnemonic(KeyEvent.VK_S);
        menuA.add(subMenu);
        
        // indsæt menuItems i undermenuen
        mItem12 = new JMenuItem("12", KeyEvent.VK_2);
        mItem12.addActionListener(menuObserver);
        subMenu.add(mItem12);

        mItem18 = new JMenuItem("18", KeyEvent.VK_8);
        mItem18.addActionListener(menuObserver);
        subMenu.add(mItem18);
        
    }
    
    private class MenuObserver implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==mItemFed) {
				// menuvalg fed
				System.out.println("fed");
			}
			else if (e.getSource()==mItemKursiv) {
				// menuvalg kursiv
				System.out.println("Kursiv");

			}
			else if (e.getSource()==mItem12) {
				// menuvalg 12
				System.out.println("12");
			}
			else if (e.getSource()==mItem18) {
				// menuvalg 18
				System.out.println("18");
			}
		}

    }   


}
