package Singleton;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class personAdministratorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtNavn;
	private JTextField textField;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personAdministratorGUI frame = new personAdministratorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public personAdministratorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtNavn = new JTextField();
		txtNavn.setEditable(false);
		txtNavn.setText("Navn:");
		panel.add(txtNavn);
		txtNavn.setColumns(10);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnTilfj = new JButton("tilf\u00F8j");
		btnTilfj.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				person p = new person(textField.getText());
				personAdministrator.getInstance().add(p);
				list.setListData(personAdministrator.getInstance().getPersoner().toArray());
			}
		});
		
		panel.add(btnTilfj);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		list = new JList(new DefaultListModel());
		panel_1.add(list, BorderLayout.CENTER);
		
		JScrollPane scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_1.add(scroll, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnSlet = new JButton("slet");
		btnSlet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				personAdministrator.getInstance().remove((person)list.getSelectedValue());
				list.setListData(personAdministrator.getInstance().getPersoner().toArray());
			}
		});
		panel_2.add(btnSlet);
	}

}
