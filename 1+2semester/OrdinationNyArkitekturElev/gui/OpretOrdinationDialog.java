package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import ordination.Lægemiddel;
import ordination.Patient;

import service.Service;

public class OpretOrdinationDialog extends JDialog {

	public boolean modalResult;

	private JButton fortryd;

	private JButton opret;

	private JLabel lblPatient;

	private JLabel lblLægemiddel;

	private JLabel lblStartDato;

	private JLabel lblSlutDato;

	private JLabel lblAntalEnheder;

	private JTextField txtAntalEnheder;

	private JLabel lblAnbefaletDosis;

	private JTextField txtStartDato;

	private JTextField txtSlutDato;

	private JTextField txtMorgen;

	private JTextField txtMiddag;

	private JTextField txtAften;

	private JTextField txtNat;

	private JLabel errorLabel;

	private Patient aktuelPatient = null;

	private Lægemiddel aktuelLægemiddel = null;

	private TypeOrdination aktuelType;

	private JPanel panelPN;

	private JPanel panelFast;

	private JPanel panelSkæv;

	private JList listDoser;

	private DefaultListModel listModel;

	private JScrollPane scrollDoser;

	private JButton butOptretDose;

	private JLabel lblKlk;

	private JLabel lblAntal;

	private JTextField txtKlk;

	private JTextField txtAntal;
	private Controller controller = new Controller();

	public OpretOrdinationDialog(Patient patient, Lægemiddel lægemiddel,
			TypeOrdination type) {

		aktuelPatient = patient;
		aktuelLægemiddel = lægemiddel;
		aktuelType = type;

		// the frame's own attributtes...
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setLayout(null);
		if (aktuelType.equals(TypeOrdination.PN))
			this.setTitle("PN ordination");
		else if (aktuelType.equals(TypeOrdination.FAST))
			this.setTitle("Daglig fast ordination");
		else
			this.setTitle("Daglig skæv ordination");
		this.setLocation(150, 150);
		this.setSize(360, 360);

		// controls...
		opret = new JButton();
		opret.setLocation(190, 290);
		opret.setSize(140, 25);
		opret.setText("Opret ordination");
		opret.addActionListener(controller);
		this.add(opret);

		fortryd = new JButton("Fortryd");
		fortryd.setLocation(40, 290);
		fortryd.setSize(120, 25);
		fortryd.addActionListener(controller);
		this.add(fortryd);

		String p = "Patient: " + aktuelPatient.getCprnr() + " "
				+ aktuelPatient.getNavn() + " " + aktuelPatient.getVægt()
				+ " kg.";
		lblPatient = new JLabel(p);
		this.add(lblPatient);
		lblPatient.setLocation(10, 40);
		lblPatient.setSize(300, 25);

		lblLægemiddel = new JLabel("Lægemiddel: " + aktuelLægemiddel.toString()
				+ "  (" + aktuelLægemiddel.getEnhed() + ")");
		this.add(lblLægemiddel);
		lblLægemiddel.setLocation(10, 70);
		lblLægemiddel.setSize(300, 25);

		lblStartDato = new JLabel("Startdato for ordinationen dd-mm-yyyy");
		this.add(lblStartDato);
		lblStartDato.setLocation(10, 100);
		lblStartDato.setSize(220, 25);

		txtStartDato = new JTextField();
		this.add(txtStartDato);
		txtStartDato.setLocation(240, 100);
		txtStartDato.setSize(90, 25);

		lblSlutDato = new JLabel("Slutdato for ordinationen dd-mm-yyyy");
		this.add(lblSlutDato);
		lblSlutDato.setLocation(10, 130);
		lblSlutDato.setSize(220, 25);

		txtSlutDato = new JTextField();
		this.add(txtSlutDato);
		txtSlutDato.setLocation(240, 130);
		txtSlutDato.setSize(90, 25);

		lblAnbefaletDosis = new JLabel("Anbefalet antal enheder pr døgn "
				+ Service.anbefaletDosisPrDøgn(patient, lægemiddel) + " "
				+ aktuelLægemiddel.getEnhed());
		this.add(lblAnbefaletDosis);
		lblAnbefaletDosis.setLocation(10, 160);
		lblAnbefaletDosis.setSize(240, 25);

		panelPN = new JPanel();
		panelPN.setLayout(null);
		this.add(panelPN);
		panelPN.setLocation(10, 190);
		panelPN.setSize(330, 90);
		if (!aktuelType.equals(TypeOrdination.PN))
			panelPN.setVisible(false);

		lblAntalEnheder = new JLabel("Angiv antal enheder ("
				+ aktuelLægemiddel.getEnhed() + ")");
		panelPN.add(lblAntalEnheder);
		lblAntalEnheder.setLocation(0, 0);
		lblAntalEnheder.setSize(220, 25);

		txtAntalEnheder = new JTextField();
		panelPN.add(txtAntalEnheder);
		txtAntalEnheder.setLocation(230, 0);
		txtAntalEnheder.setSize(90, 25);

		panelFast = new JPanel();
		panelFast.setLayout(new GridLayout(2, 4, 1, 1));
		panelFast.add(new JLabel("    Morgen"));
		panelFast.add(new JLabel("    Middag"));
		panelFast.add(new JLabel("      Aften"));
		panelFast.add(new JLabel("        Nat"));
		txtMorgen = new JTextField();
		txtMiddag = new JTextField();
		txtAften = new JTextField();
		txtNat = new JTextField();
		panelFast.add(txtMorgen);
		panelFast.add(txtMiddag);
		panelFast.add(txtAften);
		panelFast.add(txtNat);

		this.add(panelFast);
		panelFast.setLocation(10, 190);
		panelFast.setSize(330, 90);
		if (!aktuelType.equals(TypeOrdination.FAST))
			panelFast.setVisible(false);

		panelSkæv = new JPanel();
		// panelSkæv.setBackground(Color.blue);
		panelSkæv.setLayout(null);
		this.add(panelSkæv);
		panelSkæv.setLocation(10, 190);
		panelSkæv.setSize(330, 90);
		if (!aktuelType.equals(TypeOrdination.SKÆV))
			panelSkæv.setVisible(false);

		butOptretDose = new JButton("Opret dosis");
		butOptretDose.setLocation(0, 65);
		butOptretDose.setSize(120, 25);
		panelSkæv.add(butOptretDose);
		butOptretDose.addActionListener(controller);

		listModel = new DefaultListModel();
		listDoser = new JList(listModel);
		scrollDoser = new JScrollPane(listDoser);
		scrollDoser.setLocation(180, 0);
		scrollDoser.setSize(140, 90);
		panelSkæv.add(scrollDoser);

		lblKlk = new JLabel("TT:MM");
		lblKlk.setSize(60, 25);
		lblKlk.setLocation(10, 10);
		panelSkæv.add(lblKlk);

		lblAntal = new JLabel("Mængde");
		lblAntal.setSize(60, 25);
		lblAntal.setLocation(70, 10);
		panelSkæv.add(lblAntal);

		txtKlk = new JTextField();
		txtKlk.setSize(60, 25);
		txtKlk.setLocation(0, 30);
		panelSkæv.add(txtKlk);

		txtAntal = new JTextField();
		txtAntal.setSize(60, 25);
		txtAntal.setLocation(65, 30);
		panelSkæv.add(txtAntal);

		errorLabel = new JLabel("");
		errorLabel.setSize(250, 22);
		errorLabel.setLocation(10, 10);
		this.add(errorLabel);
		errorLabel.setForeground(Color.RED);
	}

	// ActionPerformed
	private class Controller implements ActionListener {
		

		public void actionPerformed(ActionEvent e) {
			errorLabel.setText("");
			try {
				if (e.getSource() == opret) {
					GregorianCalendar stDato = Validering.makeDate(txtStartDato
							.getText());
					GregorianCalendar slDato = Validering.makeDate(txtSlutDato
							.getText());
					if (aktuelType.equals(TypeOrdination.PN)) {
						if (txtAntalEnheder.getText().length() == 0)
							errorLabel.setText("Angiv antal enheder");
						else {
							Service.opretPNOrdination(stDato, slDato,
									aktuelPatient, aktuelLægemiddel, Double
											.parseDouble(txtAntalEnheder
													.getText()));
							modalResult = true;
							OpretOrdinationDialog.this.setVisible(false);
						}
					} else if (aktuelType.equals(TypeOrdination.FAST)) {
						double[] doser = { -1, -1, -1, -1 };
						if (!(txtMorgen.getText().length() == 0))
							doser[0] = Double.parseDouble(txtMorgen.getText());
						if (!(txtMiddag.getText().length() == 0))
							doser[1] = Double.parseDouble(txtMiddag.getText());
						if (!(txtAften.getText().length() == 0))
							doser[2] = Double.parseDouble(txtAften.getText());
						if (!(txtNat.getText().length() == 0))
							doser[3] = Double.parseDouble(txtNat.getText());

						Service.opretDagligFastOrdination(stDato, slDato,
								aktuelPatient, aktuelLægemiddel, doser[0],
								doser[1], doser[2], doser[3]);
						modalResult = true;
						OpretOrdinationDialog.this.setVisible(false);
					} else {
						Service.opretDagligSkævOrdination(stDato, slDato,
								aktuelPatient, aktuelLægemiddel, Validering
										.makeKlokkeSlæt(listModel.toArray()),
								Validering.makeAntal(listModel.toArray()));
						modalResult = true;
						OpretOrdinationDialog.this.setVisible(false);
					}

				} else if (e.getSource() == fortryd) {
					OpretOrdinationDialog.this.setVisible(false);
					modalResult = false;
				} else if (e.getSource() == butOptretDose) {
					if (txtKlk.getText().length() != 5)
						errorLabel.setText("Angiv korrekt klokkeslæt");
					else if (txtAntal.getText().length() == 0)
						errorLabel.setText("Angiv antal enheder");
					else {
						listModel.addElement(txtKlk.getText() + " "
								+ txtAntal.getText());
						txtKlk.setText("");
						txtAntal.setText("");
					}
				}

			} catch (RuntimeException ex) {
				errorLabel.setText(ex.getMessage());
			}
		}
	}

}
