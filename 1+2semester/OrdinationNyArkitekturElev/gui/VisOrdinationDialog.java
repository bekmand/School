package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ordination.DagligFast;
import ordination.DagligSkæv;
import ordination.Ordination;
import ordination.PN;
import ordination.Patient;
import service.Service;

public class VisOrdinationDialog extends JDialog {

	private Patient aktuelPatient;

	private Ordination aktuelOrdination = null;

	private JList listOrdinationer;

	private JScrollPane scollOrdinationer;

	private JLabel labelOrdination;

	private JPanel panelOrdination;

	private JPanel panelPN;

	private JPanel panelSkæv;

	private JPanel panelFast;

	private JButton anvendPN;

	private JLabel labelPatient;

	private JLabel labelStart;

	private JLabel labelSlut;

	private JLabel labelLægemiddel;

	private JLabel labeldøgndosis;

	private JLabel labeltotalDosis;

	private JLabel labelPNDosis;

	private JLabel labelAnvendt;
	
	private JLabel errorLabel;

	private JTextField txtStart;

	private JTextField txtSlut;

	private JTextField txtLægemiddel;

	private JTextField txtDøgnDosis;

	private JTextField txtTotalDosis;

	private JTextField txtPNDosis;

	private JTextField txtAnvendt;
	
	private JTextField txtAnvendDato;

	private JTextField txtMorgen;

	private JTextField txtMiddag;

	private JTextField txtAften;

	private JTextField txtNat;

	private JList listDoser;
	private JScrollPane scrollDoser;

	private Controller controller = new Controller();

	public VisOrdinationDialog(Patient patient) {

		aktuelPatient = patient;

		// the frame's own attributtes...
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setLayout(null);
		this.setTitle("Vis ordinationer");
		this.setLocation(150, 150);
		this.setSize(600, 360);

		labelOrdination = new JLabel("Vælg ordination");
		labelOrdination.setSize(160, 22);
		labelOrdination.setLocation(20, 40);
		this.add(labelOrdination);
		listOrdinationer = new JList();
		listOrdinationer.setListData(aktuelPatient.getOrdinationer().toArray());
		this.add(listOrdinationer);
		listOrdinationer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scollOrdinationer = new JScrollPane(listOrdinationer);
		scollOrdinationer.setLocation(20, 80);
		scollOrdinationer.setSize(160, 190);
		this.add(scollOrdinationer);

		String p = "Patient: " + aktuelPatient.getCprnr() + " "
				+ aktuelPatient.getNavn() + " " + aktuelPatient.getVægt()
				+ " kg.";
		labelPatient = new JLabel(p);
		this.add(labelPatient);
		labelPatient.setLocation(20, 15);
		labelPatient.setSize(300, 25);

		panelOrdination = new JPanel();
		panelOrdination.setLayout(null);
		this.add(panelOrdination);
		panelOrdination.setSize(400, 180);
		panelOrdination.setLocation(300, 15);
		panelOrdination.setVisible(false);

		labelStart = new JLabel("Starttid");
		panelOrdination.add(labelStart);
		labelStart.setSize(120, 25);
		labelStart.setLocation(10, 10);

		txtStart = new JTextField();
		panelOrdination.add(txtStart);
		txtStart.setSize(150, 25);
		txtStart.setLocation(100, 10);
		txtStart.setEditable(false);

		labelSlut = new JLabel("Sluttid");
		panelOrdination.add(labelSlut);
		labelSlut.setSize(120, 25);
		labelSlut.setLocation(10, 40);

		txtSlut = new JTextField();
		panelOrdination.add(txtSlut);
		txtSlut.setSize(150, 25);
		txtSlut.setLocation(100, 40);
		txtSlut.setEditable(false);

		labelLægemiddel = new JLabel("Lægemiddel");
		panelOrdination.add(labelLægemiddel);
		labelLægemiddel.setSize(120, 25);
		labelLægemiddel.setLocation(10, 70);

		txtLægemiddel = new JTextField();
		panelOrdination.add(txtLægemiddel);
		txtLægemiddel.setSize(150, 25);
		txtLægemiddel.setLocation(100, 70);
		txtLægemiddel.setEditable(false);

		labeldøgndosis = new JLabel("Døgndosis");
		panelOrdination.add(labeldøgndosis);
		labeldøgndosis.setSize(120, 25);
		labeldøgndosis.setLocation(10, 100);

		txtDøgnDosis = new JTextField();
		panelOrdination.add(txtDøgnDosis);
		txtDøgnDosis.setSize(150, 25);
		txtDøgnDosis.setLocation(100, 100);
		txtDøgnDosis.setEditable(false);

		labeltotalDosis = new JLabel("Total dosis");
		panelOrdination.add(labeltotalDosis);
		labeltotalDosis.setSize(120, 25);
		labeltotalDosis.setLocation(10, 130);

		txtTotalDosis = new JTextField();
		panelOrdination.add(txtTotalDosis);
		txtTotalDosis.setSize(150, 25);
		txtTotalDosis.setLocation(100, 130);
		txtTotalDosis.setEditable(false);

		panelPN = new JPanel();
		panelPN.setLayout(null);
		this.add(panelPN);
		panelPN.setSize(400, 300);
		panelPN.setLocation(300, 200);
		panelPN.setVisible(false);

		labelPNDosis = new JLabel("Dosis");
		panelPN.add(labelPNDosis);
		labelPNDosis.setSize(120, 25);
		labelPNDosis.setLocation(10, 10);

		txtPNDosis = new JTextField();
		panelPN.add(txtPNDosis);
		txtPNDosis.setSize(150, 25);
		txtPNDosis.setLocation(100, 10);
		txtPNDosis.setEditable(false);

		labelAnvendt = new JLabel("Givet");
		panelPN.add(labelAnvendt);
		labelAnvendt.setSize(120, 25);
		labelAnvendt.setLocation(10, 40);

		txtAnvendt = new JTextField();
		panelPN.add(txtAnvendt);
		txtAnvendt.setSize(150, 25);
		txtAnvendt.setLocation(100, 40);
		txtAnvendt.setEditable(false);

		txtAnvendDato = new JTextField();
		panelPN.add(txtAnvendDato);
		txtAnvendDato.setSize(80, 25);
		txtAnvendDato.setLocation(10, 80);
		txtAnvendDato.setText("dd-mm-yyyy");
		txtAnvendDato.setEditable(true);
		// controls...
		anvendPN = new JButton();
		anvendPN.setLocation(100, 80);
		anvendPN.setSize(140, 25);
		anvendPN.setText("Anvend ordination");
		anvendPN.addActionListener(controller);
		panelPN.add(anvendPN);

		panelFast = new JPanel();
		panelFast.setLayout(new GridLayout(2, 4, 1, 1));
		this.add(panelFast);
		panelFast.setSize(330, 90);
		panelFast.setLocation(260, 200);
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
		panelFast.setVisible(false);

		panelSkæv = new JPanel();
		panelSkæv.setLayout(null);
		this.add(panelSkæv);
		panelSkæv.setSize(330, 90);
		panelSkæv.setLocation(300, 200);

		listDoser = new JList();
		scrollDoser = new JScrollPane(listDoser);
		panelSkæv.add(scrollDoser);
		scrollDoser.setLocation(0, 0);
		scrollDoser.setSize(140, 90);

		panelSkæv.setVisible(false);
		
		errorLabel = new JLabel("");
		errorLabel.setSize(250, 22);
		errorLabel.setLocation(20, 280);
		this.add(errorLabel);
		errorLabel.setForeground(Color.RED);

		listOrdinationer.addListSelectionListener(controller);

	}

	

	private class Controller implements ActionListener, ListSelectionListener {
	

		public void actionPerformed(ActionEvent e) {
			errorLabel.setText("");
			if (e.getSource() == anvendPN) {
				try{
					GregorianCalendar anvendtDato = Validering.makeDate(txtAnvendDato.getText());
					Service.ordinationPNAnvendt((PN)aktuelOrdination, anvendtDato);
				txtAnvendt.setText(((PN) aktuelOrdination).getAntalGangeGivet()
						+ "  gange");
				txtPNDosis.setText(((PN) aktuelOrdination).getAntalEnheder()
						+ "");

				txtDøgnDosis.setText(aktuelOrdination.døgnDosis() + " "
						+ aktuelOrdination.getLægemiddel().getEnhed());
				txtTotalDosis.setText(aktuelOrdination.samletDosis() + " "
						+ aktuelOrdination.getLægemiddel().getEnhed());
				}
				catch(RuntimeException ex){
					errorLabel.setText(ex.getMessage());
				}

			}

		}

		public void valueChanged(ListSelectionEvent e) {
			panelPN.setVisible(false);
			panelFast.setVisible(false);
			panelSkæv.setVisible(false);
			if (listOrdinationer.isSelectionEmpty()) {
			} else {
				panelOrdination.setVisible(true);
				aktuelOrdination = (Ordination) listOrdinationer
						.getSelectedValue();
				txtStart.setText(aktuelOrdination.getStartDen().get(
						GregorianCalendar.DATE)
						+ "."
						+ (aktuelOrdination.getStartDen().get(
								GregorianCalendar.MONTH) + 1)
						+ "."
						+ aktuelOrdination.getStartDen().get(
								GregorianCalendar.YEAR));
				txtSlut.setText(aktuelOrdination.getSlutDen().get(
						GregorianCalendar.DATE)
						+ "."
						+ (aktuelOrdination.getSlutDen().get(
								GregorianCalendar.MONTH) + 1)
						+ "."
						+ aktuelOrdination.getSlutDen().get(
								GregorianCalendar.YEAR));
				txtLægemiddel.setText(aktuelOrdination.getLægemiddel()
						.getNavn()
						+ " ("
						+ aktuelOrdination.getLægemiddel().getEnhed()
						+ ")");
				txtDøgnDosis.setText(aktuelOrdination.døgnDosis() + " "
						+ aktuelOrdination.getLægemiddel().getEnhed());
				txtTotalDosis.setText(aktuelOrdination.samletDosis() + " "
						+ aktuelOrdination.getLægemiddel().getEnhed());
				if (aktuelOrdination instanceof PN) {
					panelPN.setVisible(true);
					txtAnvendt.setText(((PN) aktuelOrdination)
							.getAntalGangeGivet()
							+ " gange");
					txtPNDosis.setText(((PN) aktuelOrdination).getAntalEnheder()
							+ "");
				} else if (aktuelOrdination instanceof DagligFast) {
					panelFast.setVisible(true);
					if (((DagligFast) aktuelOrdination).getDoser()[0] != null)
						txtMorgen.setText(((DagligFast) aktuelOrdination)
								.getDoser()[0].getAntal()
								+ "");
					if (((DagligFast) aktuelOrdination).getDoser()[1] != null)
						txtMiddag.setText(((DagligFast) aktuelOrdination)
								.getDoser()[1].getAntal()
								+ "");
					if (((DagligFast) aktuelOrdination).getDoser()[2] != null)
						txtAften.setText(((DagligFast) aktuelOrdination)
								.getDoser()[2].getAntal()
								+ "");
					if (((DagligFast) aktuelOrdination).getDoser()[3] != null)
						txtNat.setText(((DagligFast) aktuelOrdination)
								.getDoser()[3].getAntal()
								+ "");

				} else {
					panelSkæv.setVisible(true);
					listDoser.setListData(((DagligSkæv) aktuelOrdination)
							.getDoser().toArray());

				}
			}
		}

	}

}
