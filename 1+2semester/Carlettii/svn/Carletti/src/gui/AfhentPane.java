package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import service.Service;

import model.Behandling;
import model.Mellemvare;

public class AfhentPane extends JFrame {
	
	private JLabel lblVarePåBånd, lblMellemvare;
	private JList lstVarePåBånd, lstMellemvare;
	private JButton btnAfhent, btnAflever;
	private List<Mellemvare> behandlingerMellemvare;
	private List<Mellemvare> behandlingerPåBånd;
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
		
		lblVarePåBånd = new JLabel("Vare på bånd");
		getContentPane().add(lblVarePåBånd);
		lblVarePåBånd.setBounds(160, 25, 125, 20);
		
		lstMellemvare = new JList();
		getContentPane().add(lstMellemvare);
		lstMellemvare.setBounds(25, 50, 125, 250);
		
		lstVarePåBånd = new JList();
		getContentPane().add(lstVarePåBånd);
		lstVarePåBånd.setBounds(160, 50, 125, 250);
		
		behandlingPB = new DefaultListModel();
		behandlingMV = new DefaultListModel();
		
		behandlingerMellemvare = Service.getInstance().getAlleMellemvarer();
		for(int i = 0; i < behandlingerMellemvare.size(); i++){
			behandlingMV.addElement(behandlingerMellemvare.get(i));
		}
		
		behandlingerPåBånd = Service.getInstance().getAlleMellemvarerPåBånd();
		for(int i = 0; i < behandlingerPåBånd.size(); i++){
			behandlingPB.addElement(behandlingerPåBånd.get(i));
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
	}
	
	private void updateBehandlingerMellemvare(){
		behandlingerMellemvare = Service.getInstance().getAlleMellemvarer();
		
		behandlingMV.removeAllElements();
		for(int i = 0; i < behandlingerMellemvare.size(); i++){
			behandlingMV.addElement(behandlingerMellemvare.get(i));
		}
		lstMellemvare.setModel(behandlingMV);
	}
	
	private void updateBehandlingerPåBånd(){
		behandlingerPåBånd = Service.getInstance().getAlleMellemvarerPåBånd();
		
		behandlingPB.removeAllElements();
		for(int i = 0; i < behandlingerPåBånd.size(); i++){
			behandlingPB.addElement(behandlingerPåBånd.get(i));
		}
		lstVarePåBånd.setModel(behandlingPB);
	}
	
	private class Controller implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnAfhent){
				if(Service.getInstance().færdigbehandletEllerEj((Mellemvare) lstMellemvare.getSelectedValue()) == 1){
					Service.getInstance().deleteMellemvare((Mellemvare)lstMellemvare.getSelectedValue());
					updateBehandlingerMellemvare();
					updateBehandlingerPåBånd();
				}
				else{
					Mellemvare mellemvare = (Mellemvare) lstMellemvare.getSelectedValue();
					Service.getInstance().afhentMellemvare(mellemvare.getBatchID());
					updateBehandlingerMellemvare();
					updateBehandlingerPåBånd();
				}
			}
			if(e.getSource() == btnAflever){
				Service.getInstance().færdigbehandletEllerEj((Mellemvare) lstMellemvare.getSelectedValue());
				updateBehandlingerPåBånd();
			}
			
		}
		
	}

}
