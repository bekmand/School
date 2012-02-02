package listmodellermad;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame extends JFrame {

	private DefaultListModel listModel = new DefaultListModel();
	private DefaultComboBoxModel cBoxModel = new DefaultComboBoxModel();
	private JButton btnAdd = new JButton();
	private JButton btnRem = new JButton();
	private JList list = new JList();
	private JComboBox cBox = new JComboBox();

    public MainFrame() {
        // the frame's own attributtes...
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Listmodeller");
        this.setLocation(50,50);
        this.setSize(400,300);
 
        // controls...
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // unødvendigt er default

		JScrollPane scrollpane1 = new JScrollPane(list);
		scrollpane1.setLocation(10, 10);
		scrollpane1.setSize(150, 240);
		this.add(scrollpane1);
		
        JComboBox cBox = new JComboBox();
        cBox.setLocation(200,10);
        cBox.setSize(150,30);
		this.add(cBox);
		
		btnAdd.setLocation(200, 80);
		btnAdd.setSize(120, 30);
		btnAdd.setText("Tilføj");
		btnAdd.addActionListener(new Click());
		this.add(btnAdd);
		
		btnRem.setLocation(200, 120);
		btnRem.setSize(120, 30);
		btnRem.setText("Slet 2");
		btnRem.addActionListener(new Click());
		this.add(btnRem);
		
		// lav en listModel 
		listModel.addElement("Fairway");
		listModel.addElement("Teested");
		listModel.addElement("Green");
		listModel.addElement("Eagle");
		listModel.addElement("Birdie");
		list.setModel(listModel);
		
		
		// lav en comboBoxModel 
		cBoxModel.addElement("Fairway");
		cBoxModel.addElement("Teested");
		cBoxModel.addElement("Green");
		cBoxModel.addElement("Eagle");
		cBoxModel.addElement("Birdie");
		cBox.setModel(cBoxModel);
		

    }
    
    public class Click implements ActionListener {
    	
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==btnAdd) {
 			  listModel.addElement("Ford");
			  cBoxModel.addElement("Ford");
			}
			if (e.getSource()==btnRem) {
				System.out.println("rem 2");
				listModel.remove(2);
				cBoxModel.removeElementAt(2);
			}
		}
    }
    

}
