package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import model.Calculator;


public class CalculatorFrame extends JFrame {
	private JTextField txfDisplay;
	private ArrayList<JButton> btnDigit;
	private JButton btnAdd, btnSub, btnMul, btnDiv, btnCalc;

	private Calculator calculator = new Calculator();

	private DigitController digitCtrl = new DigitController();
	private OperatorController oprCtrl = new OperatorController();
	
	//private Border border = BorderFactory.createLineBorder(Color.black, 1);

	public CalculatorFrame() {
		int wh = 50; // width and height of buttons
		int sep = 20; // distance between buttons and between buttons and
						// window-border
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 450);
		this.setLayout(null);
		this.setLocation(200, 200);
		this.setBackground(Color.PINK);
		this.setTitle(" Lommeregner 0.8 ");
		
		txfDisplay = new JTextField();
		txfDisplay.setHorizontalAlignment(txfDisplay.RIGHT);
		txfDisplay.getCaret().setVisible(false);
		txfDisplay.setLocation(20, 20);
		txfDisplay.setSize(330, 50);
		txfDisplay.setEditable(false);
		this.add(txfDisplay);
		
		btnDiv = new JButton();
		btnDiv.setLocation(340,90);
		
		int count = 1;
		int x = 90;
		int y = 370;
		for (int i = 0; i<10;i++)
		{
			
			
			JButton knap = new JButton(i+"");
			knap.setSize(wh, wh);
			knap.setLocation(x,y);
			knap.addActionListener(digitCtrl);
			knap.setFocusable(false);
			this.add(knap);
			
			x += (wh+sep);
			
			if (i%3 == 0){
				y -= (wh+sep);
				x = (wh+(sep*2));
			}
			
			btnCalc = new JButton("=");
			btnCalc.setSize(wh, wh);
			btnCalc.setLocation(300,370);
			btnCalc.addActionListener(oprCtrl);
			this.add(btnCalc);
			
			btnAdd = new JButton("+");
			btnAdd.setSize(wh, wh);
			btnAdd.setLocation(300,300);
			btnAdd.addActionListener(oprCtrl);
			this.add(btnAdd);
			
			btnSub = new JButton("-");
			btnSub.setSize(wh, wh);
			btnSub.setLocation(300, 230);
			btnSub.addActionListener(oprCtrl);
			this.add(btnSub);
			
			btnMul = new JButton("*");
			btnMul.setSize(wh, wh);
			btnMul.setLocation(300, 160);
			btnMul.addActionListener(oprCtrl);
			this.add(btnMul);
			
			btnDiv = new JButton("/");
			btnDiv.setSize(wh, wh);
			btnDiv.setLocation(300, 90);
			btnDiv.addActionListener(oprCtrl);
			this.add(btnDiv);
			
			
		}

		// TODO
	}
	

	
	// Updates the calculator's display.
	// In OPR state the display must show a number and the operator,
	// as in 23 + .
	// In NUM state the display must show the operator and the number,
	// as in + 107 .
	private void updateDisplay() {
		// TODO
	}

	// Controller for digit buttons.
	private class DigitController implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Calculator.addDigit();
			updateDisplay();
		}
	}

	// Controller for operator buttons.
	private class OperatorController implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO
		}
	}

}