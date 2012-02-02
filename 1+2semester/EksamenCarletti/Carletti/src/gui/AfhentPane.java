package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import model.Baand;
import model.Mellemvare;
import service.Service;
import service.TimeManager;

public class AfhentPane extends JFrame implements Observer {

	private JLabel lblVareP�B�nd, lblMellemvare;
	private JList lstVareP�B�nd, lstMellemvare;
	private JScrollPane scrollpane;
	private JButton btnAfhent, btnAflever;
	private List<Mellemvare> behandlingerMellemvare;
	private List<Mellemvare> behandlingerP�B�nd;
	private DefaultListModel behandlingPB, behandlingMV;
	private Controller controller = new Controller();

	public AfhentPane() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Carletti LK - Afhent");
		setBounds(313, 100, 450, 500);
		getContentPane().setLayout(null);

		lblMellemvare = new JLabel("Vare Til lager");
		getContentPane().add(lblMellemvare);
		lblMellemvare.setBounds(25, 25, 125, 20);

		lblVareP�B�nd = new JLabel("Vare p� b�nd");
		getContentPane().add(lblVareP�B�nd);
		lblVareP�B�nd.setBounds(160, 25, 125, 20);

		lstMellemvare = new JList();
		getContentPane().add(lstMellemvare);
		lstMellemvare.setBounds(25, 50, 125, 250);

		lstVareP�B�nd = new JList();
		getContentPane().add(lstVareP�B�nd);
		lstVareP�B�nd.setBounds(160, 50, 125, 250);

		behandlingPB = new DefaultListModel();
		behandlingMV = new DefaultListModel();

		behandlingerMellemvare = Service.getInstance().getAlleMellemvarer();
		for (int i = 0; i < behandlingerMellemvare.size(); i++) {
			behandlingMV.addElement(behandlingerMellemvare.get(i));
		}

		behandlingerP�B�nd = Service.getInstance().getAlleMellemvarerP�B�nd();
		for (int i = 0; i < behandlingerP�B�nd.size(); i++) {
			behandlingPB.addElement(behandlingerP�B�nd.get(i));
		}

		btnAflever = new JButton("Aflever");
		getContentPane().add(btnAflever);
		btnAflever.setBounds(25, 375, 125, 50);
		btnAflever.addActionListener(controller);

		btnAfhent = new JButton("Afhent");
		getContentPane().add(btnAfhent);
		btnAfhent.setBounds(162, 375, 125, 50);
		btnAfhent.addActionListener(controller);

		updateBehandlingerMellemvare();
		
		TimeManager.getInstance().registerObserver(this);
	}

	public void updateBehandlingerMellemvare() {
		behandlingerMellemvare = Service.getInstance().getAlleMellemvarer();

		behandlingMV.removeAllElements();
		for (int i = 0; i < behandlingerMellemvare.size(); i++) {
			if (behandlingerMellemvare.get(i).getBehandling() != null
					&& behandlingerMellemvare.get(i).getBaand() == null
					&& behandlingerMellemvare.get(i).getBehandling()
							.getDelbehandlinger().size() != behandlingerMellemvare
							.get(i).getToerretider().size()) {
				behandlingMV.addElement(behandlingerMellemvare.get(i));
			}
		}
		lstMellemvare.setModel(behandlingMV);
	}

	private class Controller implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnAfhent) {
				Mellemvare mellemvare = (Mellemvare) lstVareP�B�nd
						.getSelectedValue();
				if (Service.getInstance().f�rdigbehandletEllerEj(mellemvare) == 1) {
					mellemvare.setBaand(null);
					Service.getInstance().deleteMellemvare(mellemvare);
					updateBehandlingerMellemvare();
				} else {
					Service.getInstance().afhentMellemvare(
							mellemvare.getBatchID());
					updateBehandlingerMellemvare();
				}
				update();
			}
			if (e.getSource() == btnAflever) {
				Mellemvare m1 = (Mellemvare) lstMellemvare.getSelectedValue();
				Baand b1 = Service.getInstance().anbefaletBaandTilMellemvare(
						m1.getBatchID());
				Service.getInstance().afleverMellemvare(m1.getBatchID(),
						b1.getBatchID());
				updateBehandlingerMellemvare();
			}

		}

	}

	@Override
	public void update() {
		behandlingerP�B�nd = Service.getInstance().getAlleMellemvarerP�B�nd();

		behandlingPB.removeAllElements();
		for (int i = 0; i < behandlingerP�B�nd.size(); i++) {
			Mellemvare m1 = behandlingerP�B�nd.get(i);

			long tidPaaBaand = m1.getToerretider()
					.get(m1.getToerretider().size() - 1).getSekunderToerret();
			if (tidPaaBaand > m1.getToerretider()
					.get(m1.getToerretider().size() - 1).getDelbehandling()
					.getMinimumsT�rretid())
				behandlingPB.addElement(behandlingerP�B�nd.get(i));
		}
		lstVareP�B�nd.setModel(behandlingPB);

	}

}
