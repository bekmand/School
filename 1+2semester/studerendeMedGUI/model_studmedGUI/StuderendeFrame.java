package model_studmedGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class StuderendeFrame extends JFrame {
    
    private JTextField txfNavn;
        
    private JLabel lblNavn;
    private JLabel lblAktiv;
        
    private JCheckBox chbAktiv;
    
    private JButton btnOpret, btnGem, btnHent, btnSlet;
    
    private Controller controller; 

    public StuderendeFrame() {

        this.setTitle("Administrer Studerende");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(380, 320);
        this.setLocation(500, 200);
        this.setResizable(false);
    
        lblNavn = new JLabel("Navn:");
        lblNavn.setSize(100,25);
        lblNavn.setLocation(20, 20);
        this.add(lblNavn);

                
        lblAktiv = new JLabel("Aktiv:");
        lblAktiv.setSize(100,25);
        lblAktiv.setLocation(20, 120);
        this.add(lblAktiv);
        

        txfNavn = new JTextField();
        txfNavn.setSize(200,25);
        txfNavn.setLocation(140, 20);
        this.add(txfNavn);
            
        chbAktiv = new JCheckBox("Aktiv");
        chbAktiv.setSize(20, 20);
        chbAktiv.setLocation(140, 120);
        this.add(chbAktiv);

        controller = new Controller();
        
        btnOpret = new JButton("Opret");
        btnOpret.setSize(70, 25);
        btnOpret.setLocation(20,250);
        this.add(btnOpret);
        btnOpret.addActionListener(controller);
        
        btnGem = new JButton("Gem");
        btnGem.setSize(70, 25);
        btnGem.setLocation(100,250);
        this.add(btnGem);
        btnGem.addActionListener(controller);
        
        btnHent = new JButton("Hent");
        btnHent.setSize(70, 25);
        btnHent.setLocation(180,250);
        this.add(btnHent);
        btnHent.addActionListener(controller);
        
        btnSlet = new JButton("Slet");
        btnSlet.setSize(70, 25);
        btnSlet.setLocation(260,250);
        this.add(btnSlet);
        btnSlet.addActionListener(controller);
        
        this.setVisible(true);
    }

    private class Controller implements ActionListener {
        private Studerende aktuelStuderende = null;
        private void clearAllFields(){
            txfNavn.setText("");
            chbAktiv.setSelected(false);
        }
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (source.equals(btnGem)){
                if (aktuelStuderende != null){
                    aktuelStuderende.setNavn(txfNavn.getText());
                    aktuelStuderende.setAktiv(chbAktiv.isSelected());
                    clearAllFields();
                }
            }
            else if(source.equals(btnHent)){
                if (aktuelStuderende != null){
                    txfNavn.setText(aktuelStuderende.getNavn());
                    chbAktiv.setSelected(aktuelStuderende.isAktiv());
                }
            }
            else if(source.equals(btnSlet)){
                aktuelStuderende = null;
                clearAllFields();
            }
            else if(source.equals(btnOpret)){
                String navn = txfNavn.getText();
                boolean aktiv = chbAktiv.isSelected();
                aktuelStuderende = new Studerende(navn);
                aktuelStuderende.setAktiv(aktiv);
                clearAllFields();
            }
        }
    }
}
	