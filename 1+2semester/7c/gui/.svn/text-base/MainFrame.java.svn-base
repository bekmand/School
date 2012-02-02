package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import model.EMenu.InputMode;
import model.EMenu.menuStates;
import model.EMenu.phoneState;
import model.Kontakt;
import model.Menu;
import service.Service;

public class MainFrame extends JFrame {
	private static JLabel lblDisplay, lblMenu;
	private static JList lstDisplay;

	private InputKeysPanel ikp;
	private JButton btnLeft, btnRight, btnUp, btnDown, btnOK, btnBackspace;
	private int lineLength = 15;
	private Controller controller = new Controller();

	private static phoneState ps = phoneState.FORSIDE;
	private static menuStates ms = menuStates.FORSIDE;
	private int nummer = 0;
	private String forNavn;
	private String efterNavn;
	private String textIndhold;

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
		if (menu.getNext() != null)
			lstDisplay.setListData(menu.getNext().toArray());
		if (menu.getPhoneState() != null)
			ps = menu.getPhoneState();
		if (menu.getMenuState() != null) {
			ms = menu.getMenuState();
			if (ps == phoneState.KONTAKT)
				kontakt();
			else if (ps == phoneState.SMS)
				besked();
			else if (ps == phoneState.MENU){
				if (ms == menuStates.LAES)
					lstDisplay.setListData(Service.getOpkald().toArray());
			}
		}
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

	private void laegPaa() {
		Service.laegPaa();
		ikp.setText(Service.getLastCall().getFormattedCallTime());
		lblDisplay.setText(ikp.getFormattedText(lineLength));
		ps = phoneState.FORSIDE;
	}

	private void besked() {
		if (ms == menuStates.OPRET) {
			lblMenu.setText("Indtast dit fornavn.");
			//lstDisplay.setVisible(false);
			//setDisplay();
			ikp.setInputMode(InputMode.CHARACTER);
			Kontakt k1 = new Kontakt(null, null, 0);

			if (nummer == 0) {
				lblMenu.setText("Modtager?");
				lstDisplay.setListData(service.Service.getKontakter().toArray());
			}
			if (nummer == 1) {
				setDisplay();
				lblMenu.setText("Besked?");
				k1 = (Kontakt)lstDisplay.getSelectedValue();
				forNavn = k1.getFornavn();
				ikp.setText("");
			}
			if (nummer == 2) {
				lblMenu.setText("Send");
				service.Service.addSmser(k1.getNummer(), textIndhold, false);
			}
			if (nummer == 3) {
				nummer = Integer.parseInt(ikp.getText());
				
				lblMenu.setText("Send");
				nummer=0;
				ps = phoneState.FORSIDE;
				ms = menuStates.FORSIDE;
				setDisplay();
			}
			ikp.setText("");
			lblDisplay.setText(ikp.getFormattedText(lineLength));
			nummer++;
		}
		if (ms == menuStates.LAES) {
			lblMenu.setText("Beskeder -> Oversigt.");
			lstDisplay.setListData(service.Service.getSmser().toArray());
		}
		if (ms == menuStates.REDIGER) {
			lblMenu.setText("Beskeder -> Slet.");
			lstDisplay.setListData(service.Service.getSmser().toArray());
		}
	}

	private void kontakt() {
		if (ms == menuStates.OPRET) {
			lstDisplay.setVisible(false);
			setDisplay();
			ikp.setInputMode(InputMode.CHARACTER);

			if (nummer == 0) {
				lblMenu.setText("Fornavn?");
			}
			if (nummer == 1) {
				lblMenu.setText("Efternavn?");
				forNavn = ikp.getText();
				ikp.setText("");
			}
			if (nummer == 2) {
				lblMenu.setText("Telefon nr?");
				efterNavn = ikp.getText();
			}
			if (nummer == 3) {
				ikp.setInputMode(InputMode.NUMERIC);
				setDisplay();
				nummer = Integer.parseInt(ikp.getText());
				service.Service.addKontakter(efterNavn, forNavn, nummer);
				lblMenu.setText("Kontakt oprettet.");
				nummer = 0;
				ps = phoneState.FORSIDE;
				ms = menuStates.FORSIDE;
				setDisplay();
			}
			ikp.setText("");
			lblDisplay.setText(ikp.getFormattedText(lineLength));
			nummer++;
		}
		if (ms == menuStates.LAES) {
			lblMenu.setText("Kontakt -> Oversigt.");
			lstDisplay.setListData(service.Service.getKontakter().toArray());
		}
		if (ms == menuStates.REDIGER) {
			lblMenu.setText("Kontakt -> Rediger.");
		}
	}

	private void ringOp(Kontakt kontakt) {
		int nr = 0;
		if (kontakt != null)
			nr = kontakt.getNummer();
		else
			nr = Integer.parseInt(ikp.getText());
		if (Service.ringOp(nr)) {
			String s = "";
			Kontakt k = Service.findKontakt(nr);
			if (k != null)
				s = k.getFornavn();
			else
				s = ikp.getText();
			ikp.setText(s + "<br />Opkald Godkendt.");
			ps = phoneState.OPKALD;
		} else {
			ikp.setText("Opkald afvist.");
			ps = phoneState.ERROR;
		}
		ms = menuStates.FORSIDE;
		lblDisplay.setText(ikp.getFormattedText(lineLength));
		setDisplay();
	}

	private class Controller implements ActionListener, InputTextListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOK) {
				if (ps == phoneState.FORSIDE) {
					if (ikp.getOffset() == 0) {
						ps = phoneState.MENU;
						setDisplay();
					} else {
						ringOp(null);
					}
				} else if (ps == phoneState.SMS) {
					if(ms == menuStates.FORSIDE)
					aabenNaeste((Menu) lstDisplay.getSelectedValue());
					else besked();
				} else if (ps == phoneState.MENU) {
					aabenNaeste((Menu) lstDisplay.getSelectedValue());
					lstDisplay.setSelectedIndex(0);
				} else if (ps == phoneState.OPKALD) {
					laegPaa();
					ps = phoneState.ERROR;
				} else if (ps == phoneState.KONTAKT) {
					if (ms == menuStates.LAES) {
						ringOp((Kontakt) lstDisplay.getSelectedValue());
					} else {
						aabenNaeste((Menu) lstDisplay.getSelectedValue());
					}
				} else if (ps == phoneState.ERROR) {
					ikp.setText("");
					lblDisplay.setText(ikp.getFormattedText(lineLength));
					ps = phoneState.FORSIDE;
				}
			}

			else if (e.getSource() == btnLeft) {
				ikp.moveCursor(-1);
				lblDisplay.setText(ikp.getFormattedText(lineLength));
			}

			else if (e.getSource() == btnRight) {
				ikp.moveCursor(1);
				lblDisplay.setText(ikp.getFormattedText(lineLength));
			}

			else if (e.getSource() == btnDown) {
				if (lstDisplay.getSelectedIndex() == lstDisplay.getModel()
						.getSize() - 1) {
					lstDisplay.setSelectedIndex(0);
				} else
					lstDisplay
							.setSelectedIndex(lstDisplay.getSelectedIndex() + 1);
			}

			else if (e.getSource() == btnUp) {
				if (lstDisplay.getSelectedIndex() == 0) {
					lstDisplay
							.setSelectedIndex(lstDisplay.getModel().getSize() - 1);
				} else
					lstDisplay
							.setSelectedIndex(lstDisplay.getSelectedIndex() - 1);
			}

			else if (e.getSource() == btnBackspace) {
				if(lstDisplay.isVisible()){
				if (ps == phoneState.OPKALD) {
					laegPaa();
					ps = phoneState.ERROR;
				} else if (ps == phoneState.MENU) {
					if (ms == menuStates.FORSIDE)
						ps = phoneState.FORSIDE;
					else {
						ms = menuStates.FORSIDE;
						lblMenu.setVisible(false);
					}

					setDisplay();
				} else if (ps == phoneState.SMS) {
					if (ms == menuStates.LAES) {
						lstDisplay.setListData(service.Service.getMenus()
								.get(1).getList().toArray());
						lstDisplay.setSelectedIndex(1);
						ms = menuStates.FORSIDE;
						lblMenu.setText("SMS");
					} else if (ms == menuStates.REDIGER) {
						lstDisplay.setListData(service.Service.getMenus()
								.get(1).getList().toArray());
						lstDisplay.setSelectedIndex(1);
						ms = menuStates.FORSIDE;
						lblMenu.setText("SMS");
					} else if (ms == menuStates.OPRET && ikp.getText() == null) {
						lstDisplay.setListData(service.Service.getMenus()
								.get(1).getList().toArray());
						lstDisplay.setSelectedIndex(0);
						ms = menuStates.FORSIDE;
						lblMenu.setText("SMS");
					} else if (ms == menuStates.FORSIDE) {
						lstDisplay.setListData(service.Service.getMenus()
								.toArray());
						ps = phoneState.MENU;
						lblMenu.setText("Menu");
					}
				} else if (ps == phoneState.KONTAKT) {
					if (ms == menuStates.LAES) {
						lstDisplay.setListData(service.Service.getMenus()
								.get(0).getList().toArray());
						lstDisplay.setSelectedIndex(1);
						ms = menuStates.FORSIDE;
						lblMenu.setText("Kontakt");
					} else if (ms == menuStates.REDIGER) {
						lstDisplay.setListData(service.Service.getMenus()
								.get(0).getList().toArray());
						lstDisplay.setSelectedIndex(1);
						ms = menuStates.FORSIDE;
						lblMenu.setText("Kontakt");
					} else if (ms == menuStates.OPRET && ikp.getText() == null) {
						lstDisplay.setListData(service.Service.getMenus()
								.get(0).getList().toArray());
						lstDisplay.setSelectedIndex(0);
						ms = menuStates.FORSIDE;
						lblMenu.setText("Opret");
					} else if (ms == menuStates.FORSIDE) {
						lstDisplay.setListData(service.Service.getMenus()
								.toArray());
						ps = phoneState.MENU;
						lblMenu.setText("Menu");
					} else if (ps == phoneState.ERROR) {
						ikp.setText("");
						lblDisplay.setText(ikp.getFormattedText(lineLength));
						ps = phoneState.FORSIDE;
					}
				}
				}
		else{
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