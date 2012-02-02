package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import ordination.Lægemiddel;
import ordination.Patient;

import service.Service;

public class OrdinationMainFrame extends JFrame {

	private JLabel patientLabel;
	private JLabel medicinLabel;
	private JLabel ordinationLabel;
	private JLabel errorLabel;
	private JButton opretButton;
	private JButton visButton;
	private JScrollPane scrollPanePersoner;
	private JList listPesoner;
	private JScrollPane scrollPaneMedicin;
	private JList listMedicin;
	private JRadioButton pnRadio;
	private JRadioButton skævRadio;
	private JRadioButton fastRadio;
	private ButtonGroup group;

	private Controller controller = new Controller();

	public OrdinationMainFrame() {
		Service.createSomeObjects();

		// the frame's own attributtes...
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Medicin ordination");
		this.setLocation(50, 50);
		this.setSize(500, 360);

		// controls...
		pnRadio = new JRadioButton("PN");
		skævRadio = new JRadioButton("Daglig skæv");
		fastRadio = new JRadioButton("Daglig fast");
		group = new ButtonGroup();
		group.add(pnRadio);
		group.add(skævRadio);
		group.add(fastRadio);

		pnRadio.setSize(100, 15);
		pnRadio.setLocation(350, 80);
		skævRadio.setSize(100, 15);
		skævRadio.setLocation(350, 120);
		fastRadio.setSize(100, 15);
		fastRadio.setLocation(350, 160);
		this.add(pnRadio);
		this.add(skævRadio);
		this.add(fastRadio);
		ordinationLabel = new JLabel("Vælg ordination");
		ordinationLabel.setSize(160, 22);
		ordinationLabel.setLocation(350, 15);
		this.add(ordinationLabel);

		patientLabel = new JLabel("Vælg patient");
		patientLabel.setSize(160, 22);
		patientLabel.setLocation(20, 15);
		this.add(patientLabel);
		listPesoner = new JList();
		listPesoner.setListData(Service.getAllPatienter().toArray());
		this.add(listPesoner);
		listPesoner.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPanePersoner = new JScrollPane(listPesoner);
		scrollPanePersoner.setLocation(20, 50);
		scrollPanePersoner.setSize(160, 190);
		this.add(scrollPanePersoner);

		medicinLabel = new JLabel("Vælg lægemiddel");
		medicinLabel.setSize(160, 22);
		medicinLabel.setLocation(200, 15);
		this.add(medicinLabel);
		listMedicin = new JList();
		listMedicin.setListData(Service.getAllLægemidler().toArray());
		this.add(listMedicin);
		listMedicin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPaneMedicin = new JScrollPane(listMedicin);
		scrollPaneMedicin.setLocation(200, 50);
		scrollPaneMedicin.setSize(120, 190);
		this.add(scrollPaneMedicin);

		opretButton = new JButton("Opret ordination");
		opretButton.setSize(140, 25);
		opretButton.setLocation(350, 250);
		this.add(opretButton);

		visButton = new JButton("Vis ordinationer");
		visButton.setSize(140, 25);
		visButton.setLocation(200, 250);
		this.add(visButton);

		errorLabel = new JLabel("");
		errorLabel.setSize(250, 22);
		errorLabel.setLocation(20, 250);
		this.add(errorLabel);
		errorLabel.setForeground(Color.RED);

		opretButton.addActionListener(controller);
		visButton.addActionListener(controller);

	}

	// ActionPerformed

	private class Controller implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			errorLabel.setText("");

			if (e.getSource() == opretButton) {
				if (listPesoner.isSelectionEmpty()) {
					errorLabel.setText("Der skel vælges en patient");
				} else if (listMedicin.isSelectionEmpty()) {
					errorLabel.setText("Der skel vælges et lægemiddel");
				} else if (!pnRadio.isSelected() && !fastRadio.isSelected()
						&& !skævRadio.isSelected()) {
					errorLabel.setText("Der skel vælges en ordinations type");
				} else if (pnRadio.isSelected() || skævRadio.isSelected()
						|| fastRadio.isSelected()) {
					TypeOrdination type;
					if (pnRadio.isSelected())
						type = TypeOrdination.PN;
					else if (skævRadio.isSelected())
						type = TypeOrdination.SKÆV;
					else
						type = TypeOrdination.FAST;
					Patient p = (Patient) listPesoner.getSelectedValue();
					Lægemiddel l = (Lægemiddel) listMedicin.getSelectedValue();
					OpretOrdinationDialog pnDialog = new OpretOrdinationDialog(p,l,type);
					pnDialog.setVisible(true);

					if (pnDialog.modalResult) {
					}

				}

			} else if (e.getSource() == visButton) {
				if (listPesoner.isSelectionEmpty()) {
					errorLabel.setText("Der skel vælges en patient");
				} else {
					VisOrdinationDialog ordDialog = new VisOrdinationDialog(
							(Patient) listPesoner.getSelectedValue());
					ordDialog.setVisible(true);
				}
			}

		}
	}

}
