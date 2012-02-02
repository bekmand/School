package eksempel3;

import java.awt.Graphics;

import javax.swing.JPanel;

public class TegnePanel extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x1 = 100;
		int y1 = 200;
		int x2 = 20;
		int y2 = 10;

		while (x2 <= 180) {
			g.drawLine(x1, y1, x2, y2);
			x2 = x2 + 40;
		}

	}

}
