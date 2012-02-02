package GUIEksempelStorSmåBogstaver;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.ArrayList;

public class MainFrame extends JFrame{
	private JButton storKnap;
	private JButton smaaKnap;
	private JButton tilfojKnap;
	private JLabel label;
	private JTextField tekst;
	
	private JCheckBox check;
	
	private JList liste;
	private JScrollPane scroll;
	
	private ArrayList<String> tekster = new ArrayList<String>(); 
	
	private Controller controller = new Controller();
	
	// Vinduets egne komponenter
	
	public MainFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("En applikation med frame");
		this.setLocation(300, 200);
		this.setSize(500, 500);
		
		// Komponenter
		
		label = new JLabel("Input:");
		this.add(label);
		label.setLocation(50,20);
		label.setSize(100, 25);
		
		tekst = new JTextField();
		this.add(tekst);
		tekst.setLocation(100,20);
		tekst.setSize(200, 25);
		
		check = new JCheckBox("Rød");
		this.add(check);
		check.setLocation(320,20);
		check.setSize(100, 25);
		
		tekster.add("en god dag");
		tekster.add ("er det snart jul");
		
		liste = new JList(tekster.toArray());
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scroll = new JScrollPane(liste);
		this.add(scroll);
		scroll.setLocation(100, 50);
		scroll.setSize(200, 100);
		
		storKnap = new JButton("Store bogstaver");
		this.add(storKnap);
		storKnap.setLocation(50,400);
		storKnap.setSize(125, 25);
		

		smaaKnap = new JButton("Små bogstaver");
		this.add(smaaKnap);
		smaaKnap.setLocation(200,400);
		smaaKnap.setSize(125, 25);

		tilfojKnap = new JButton("Tilføj");
		this.add(tilfojKnap);
		tilfojKnap.setLocation(350,400);
		tilfojKnap.setSize(125, 25);

		
		storKnap.addActionListener(controller);
		smaaKnap.addActionListener(controller);
		liste.addListSelectionListener(controller);
		tilfojKnap.addActionListener(controller);
		check.addItemListener(controller);
		
	}
	
	private class Controller implements ActionListener,ListSelectionListener,ItemListener{

		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==storKnap){
				String input = tekst.getText();
				String resultat = input.toUpperCase();
				tekst.setText(resultat);
			}
			else if (e.getSource()==smaaKnap){
				String input = tekst.getText();
				String resultat = input.toLowerCase();
				tekst.setText(resultat);		
			}
			else if (e.getSource()==tilfojKnap){
				if (tekst.getText()!= null){
					String input = tekst.getText();
					tekster.add(input);
					liste.setListData(tekster.toArray());
					tekst.setText(null);
				}
				
			}
		}

	 
		public void valueChanged(ListSelectionEvent e) {
			if (!liste.isSelectionEmpty()){
				String obj = (String)liste.getSelectedValue();
				tekst.setText(obj);
			}
			
		}

	 
		public void itemStateChanged(ItemEvent e) {
			if (check.isSelected())
				liste.setForeground(Color.red);
			else 
				liste.setForeground(Color.black);
		
		}
		
	}

	
}
