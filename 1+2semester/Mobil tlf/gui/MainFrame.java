package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import service.Service;

import model.EMenu;
import model.EMenu.InputMode;
import model.EMenu.menuStates;
import model.EMenu.phoneState;
import model.Kontakt;
import model.Menu;

public class MainFrame extends JFrame {
	Timer t;
	private static JLabel lblDisplay, lblMenu;
	private static JList lstDisplay;
	
	private InputKeysPanel ikp;
	private JButton btnLeft, btnRight, btnUp, btnDown, btnOK, btnBackspace;
	private int lineLength = 15;

	private Controller controller = new Controller();

	private static phoneState ps = phoneState.FORSIDE;
	private static menuStates ms = menuStates.FORSIDE;
	
	public MainFrame() {
		// components
		this.setTitle("InputKeysPanel Demo");
		this.setSize(400, 430);
		this.setLocation(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblMenu = new JLabel();
		getContentPane().add(lblMenu);
		lblMenu.setSize(250, 25);
		lblMenu.setLocation(50, 3);

		lstDisplay = new JList();
		getContentPane().add(lstDisplay);
		lstDisplay.setSize(250, 60);
		lstDisplay.setLocation(50, 25);
		lstDisplay.setListData(Service.getMenus().toArray());
		lstDisplay.setVisible(false);

		lblDisplay = new JLabel("<html><u>&nbsp;</u></html>");
		getContentPane().add(lblDisplay);
		lblDisplay.setSize(250, 60);
		lblDisplay.setLocation(50, 25);
		lblDisplay.setBackground(Color.ORANGE);
		lblDisplay.setOpaque(true);
		lblDisplay.setFont(new Font("Courier New", Font.BOLD, 16));

		btnUp = new JButton("\u25B2");
		getContentPane().add(btnUp);
		btnUp.setSize(60, 25);
		btnUp.setLocation(105, 100);
		btnUp.addActionListener(controller);

		btnDown = new JButton("\u25BC");
		getContentPane().add(btnDown);
		btnDown.setSize(60, 25);
		btnDown.setLocation(105, 160);
		btnDown.addActionListener(controller);

		btnLeft = new JButton("\u25C4");
		getContentPane().add(btnLeft);
		btnLeft.setSize(50, 25);
		btnLeft.setLocation(50, 130);
		btnLeft.addActionListener(controller);

		btnOK = new JButton("OK");
		getContentPane().add(btnOK);
		btnOK.setSize(60, 25);
		btnOK.setLocation(105, 130);
		btnOK.addActionListener(controller);

		btnRight = new JButton("\u25BA");
		getContentPane().add(btnRight);
		btnRight.setSize(50, 25);
		btnRight.setLocation(170, 130);
		btnRight.addActionListener(controller);

		btnBackspace = new JButton("<x");
		getContentPane().add(btnBackspace);
		btnBackspace.setSize(60, 25);
		btnBackspace.setLocation(250, 130);
		btnBackspace.addActionListener(controller);

		ikp = new InputKeysPanel();
		getContentPane().add(ikp);
		ikp.setSize(350, 180);
		ikp.setLocation(20, 200);
		ikp.setBackground(Color.green);
		ikp.setLayout(null);
		ikp.setInputMode(InputMode.NUMERIC);
		ikp.setNextCharTimespan(700); // 500 ms
		ikp.addInputTextListener(controller);
	}

	private void aabenNaeste(Menu menu) {
		lstDisplay.setListData(menu.getNext().toArray());
		lblMenu.setText(menu.getNavn());
		setMenuState(menu.getMenuState());
		//If statement
		lblMenu.setVisible(true);
		//Else
		//False
	}
	
	public void setMenuState(menuStates ms){
		this.ms = ms;
	}

	private static void setDisplay() {
		if (ps == phoneState.MENU) {
			if (ms == menuStates.FORSIDE)
				lstDisplay.setListData(Service.getMenus().toArray());
			lstDisplay.setSelectedIndex(0);
			lstDisplay.setVisible(true);
			lblDisplay.setVisible(false);
		} else {
			lstDisplay.setVisible(false);
			lblDisplay.setVisible(true);
		}
	}
	
	private void laegPaa(){
		Service.laegPaa();
		ikp.setText(Service.getLastCall().getFormattedCallTime());
		lblDisplay.setText(ikp.getFormattedText(lineLength));
		t.cancel(); //Terminate the thread
	}
	
	private void kontakt(){
		if (ms == menuStates.OPRET){
			lblMenu.setText("Indtast dit fornavn.");
		}
		if (ms == menuStates.LAES){
			lblMenu.setText("Kontakt -> Oversigt.");
		}
		if (ms == menuStates.REDIGER){
			lblMenu.setText("Kontakt -> Rediger.");
		}
	}

	class updateCalltime extends TimerTask  {
	    public void run ()   {
	    	Service.getLastCall().setCallLenght();
	    	ikp.setText(Service.getLastCall().getFormattedCallTime());
	    	//setDisplay();
	    }
	}
	
	private class Controller implements ActionListener, InputTextListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOK) {
				if (ps == phoneState.FORSIDE)
					if (ikp.getOffset() == 0) {
						ps = phoneState.MENU;
						setDisplay();
					} else {
						if (Service.ringOp(Integer.parseInt(ikp.getText()))){
							t = new Timer();
							t.schedule ( new updateCalltime(), 1*1000 ) ;
							String s = "";
							Kontakt k = Service.findKontakt(Integer.parseInt(ikp.getText()));
							if (k != null)
								s = k.getFornavn();
							else
								s = ikp.getText();
							ikp.setText("<br />Opkald Godkendt.");
							ps = phoneState.OPKALD;
						}
						else{
							ikp.setText("Opkald afvist.");
							ps = phoneState.ERROR;
						}
						lblDisplay.setText(ikp.getFormattedText(lineLength));
					}
				else if (ps == phoneState.SMS) {
					// Send SMS.
				} else if (ps == phoneState.MENU){
					aabenNaeste((Menu) lstDisplay.getSelectedValue());
					lstDisplay.setSelectedIndex(0);
				}
				else if (ps == phoneState.OPKALD) {
					laegPaa();
				}
				else if (ps == phoneState.KONTAKT){
					kontakt();
				}
				else if (ps == phoneState.ERROR){
					ikp.setText("");
					lblDisplay.setText(ikp.getFormattedText(lineLength));
					ps = phoneState.FORSIDE;
				}
			}

			if (e.getSource() == btnLeft) {
				ikp.moveCursor(-1);
				lblDisplay.setText(ikp.getFormattedText(lineLength));
			}

			if (e.getSource() == btnRight) {
				ikp.moveCursor(1);
				lblDisplay.setText(ikp.getFormattedText(lineLength));
			}
			
			if (e.getSource() == btnDown) {
				if(lstDisplay.getSelectedIndex()==lstDisplay.getModel().getSize()-1){
					lstDisplay.setSelectedIndex(0);
				}
				else
				lstDisplay.setSelectedIndex(lstDisplay.getSelectedIndex()+1);
			}
			
			if (e.getSource() == btnUp) {
				if(lstDisplay.getSelectedIndex()==0){
					lstDisplay.setSelectedIndex(lstDisplay.getModel().getSize()-1);
				}
				else
				lstDisplay.setSelectedIndex(lstDisplay.getSelectedIndex()-1);
			}

			if (e.getSource() == btnBackspace) {
				if (ps == phoneState.OPKALD) {
					laegPaa();
				} else if (ps == phoneState.MENU) {
					if (ms == menuStates.FORSIDE)
						ps = phoneState.FORSIDE;
					else{
						ms = menuStates.FORSIDE;
						lblMenu.setVisible(false);
					}
					
					setDisplay();
				}else {
					ikp.deleteChar();
					lblDisplay.setText(ikp.getFormattedText(lineLength));
				}
			}
		}

		public void textChanged(InputTextEvent e) {
			lblDisplay.setText(ikp.getFormattedText(lineLength));
		}
	}
}