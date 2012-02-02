package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Enum.appState;
import model.Lager;
import service.Service;
import service.TimeManager;

public class StatusPane extends JFrame implements Observer {
	private Lager aktivLager;

	public StatusPane() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Carletti LK - Status");
		setBounds(313, 100, 450, 500);
		getContentPane().setLayout(null);

		update();
		
		TimeManager.getInstance().registerObserver(this);

	}

	public Color colorChange(appState status) {
		Color c = null;

		switch (status) {

		case FORKORT:
			c = Color.BLUE;
			break;

		case MINTID:
			c = Color.YELLOW;
			break;

		case IDEALTID:
			c = Color.GREEN;
			break;

		case FORGAMMEL:
			c = Color.RED;
			break;

		}
		return c;
	}

	@Override
	public void update() {
		getContentPane().removeAll();
		aktivLager = Service.getInstance().getLager();

		int x = 50;
		int y = 25;
		int u = 1;
		JLabel tempLabel;
		for (int p = 0; p < aktivLager.getInstance().getLagerBaand().size(); p++) {
			
			int k = 1;
			for (int i = 0; i < aktivLager.getLagerBaand().get(p)
					.getMellemvarer().size(); i++) {
				

				tempLabel = new JLabel(Character.toString((char) (p + 65))
						+ "-" + aktivLager.getLagerBaand().get(p)
						.getMellemvarer().get(i).getBatchID(), JLabel.CENTER);
				getContentPane().add(tempLabel);

//				tempLabel.setName(p + "-" + i);
				tempLabel.setBounds((x * k), (y * u), 50, 15);
				tempLabel.setOpaque(true);
				tempLabel.setBackground(colorChange(aktivLager
						.getLagerBaand()
						.get(p)
						.getMellemvarer()
						.get(i)
						.getToerretider()
						.get(aktivLager.getLagerBaand().get(p).getMellemvarer()
								.get(i).getToerretider().size() - 1)
						.getStatus()));
				tempLabel.setVisible(true);

				k++;
			}

			u++;
		}

		getContentPane().validate();
		getContentPane().repaint();

	}

}
