package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	private JButton btnAfhent, btnVare, btnBehandling, btnDelbehandling, btnStatus;
	private Controller controller = new Controller();
	
	public MainFrame() {
		setTitle("Carletti LK");
		setBounds(100, 100, 212, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		btnAfhent = new JButton("Afhent/Aflever");
		getContentPane().add(btnAfhent);
		btnAfhent.setSize(150, 50);
		btnAfhent.setLocation(25, 25);
		btnAfhent.addActionListener(controller);
		
		btnVare = new JButton("Vare");
		getContentPane().add(btnVare);
		btnVare.setSize(150, 50);
		btnVare.setLocation(25, 80);
		btnVare.addActionListener(controller);
		
		btnBehandling = new JButton("Behandling");
		getContentPane().add(btnBehandling);
		btnBehandling.setSize(150, 50);
		btnBehandling.setLocation(25, 135);
		btnBehandling.addActionListener(controller);
		
		btnDelbehandling = new JButton("Delbehandling");
		getContentPane().add(btnDelbehandling);
		btnDelbehandling.setSize(150, 50);
		btnDelbehandling.setLocation(25, 190);
		btnDelbehandling.addActionListener(controller);
		
		btnStatus = new JButton("Status");
		getContentPane().add(btnStatus);
		btnStatus.setSize(150, 50);
		btnStatus.setLocation(25, 245);
		btnStatus.addActionListener(controller);
	}
	
	private class Controller implements ActionListener{

		AfhentPane ap = new AfhentPane();
		VarePane vp = new VarePane();
		BehandlingPane bh = new BehandlingPane();
		StatusPane sp = new StatusPane();
		DelbehandlingPane dp = new DelbehandlingPane();
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnAfhent){
				if(vp.isVisible()){
					vp.setVisible(false);
				}
				if(bh.isVisible()){
					bh.setVisible(false);
				}
				if(dp.isVisible()){
					dp.setVisible(false);
				}
				if(sp.isVisible()){
					sp.setVisible(false);
				}
				ap.setVisible(true);
			}
			
			if(e.getSource() == btnVare){
				if(ap.isVisible()){
					ap.setVisible(false);
				}
				if(bh.isVisible()){
					bh.setVisible(false);
				}
				if(dp.isVisible()){
					dp.setVisible(false);
				}
				if(sp.isVisible()){
					sp.setVisible(false);
				}
				vp.setVisible(true);
				vp.updateBehandlinger();
			}
			
			if(e.getSource() == btnBehandling){
				if(vp.isVisible()){
					vp.setVisible(false);
				}
				if(ap.isVisible()){
					ap.setVisible(false);
				}
				if(dp.isVisible()){
					dp.setVisible(false);
				}
				if(sp.isVisible()){
					sp.setVisible(false);
				}
				bh.setVisible(true);
				bh.updateDelbehandlinger();
			}
			
			if(e.getSource() == btnDelbehandling){
				if(vp.isVisible()){
					vp.setVisible(false);
				}
				if(bh.isVisible()){
					bh.setVisible(false);
				}
				if(ap.isVisible()){
					ap.setVisible(false);
				}
				if(sp.isVisible()){
					sp.setVisible(false);
				}
				dp.setVisible(true);
			}
			
			if(e.getSource() == btnStatus){
				if(vp.isVisible()){
					vp.setVisible(false);
				}
				if(bh.isVisible()){
					bh.setVisible(false);
				}
				if(dp.isVisible()){
					dp.setVisible(false);
				}
				if(ap.isVisible()){
					ap.setVisible(false);
				}
				sp.setVisible(true);
			}
			
		}
		
	}

}
