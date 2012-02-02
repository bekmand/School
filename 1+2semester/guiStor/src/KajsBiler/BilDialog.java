
package KajsBiler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;




public class BilDialog extends JDialog{
	
	public boolean modalResult; //bem�rk at den er public, udtrykker om der er trykket
	                            //p� den ene eller den anden knap for at lukke dialogen
	
	private JButton tilbage;
	private JButton opretBil;
	//private JButton opretBilUdenLuk; //Eks. p� at man ogs� kan have andre knapper i
	                                 //sk�rmbilledet end de to luk-knapper
	
	private JScrollPane scrollPane; 
	private JList list;
	private JLabel lblM�rke;
    private JTextField txfM�rke;
    private JLabel lblRegnr;
    private JTextField txfRegnr;
    //der er flere felter p� en bil!!
    
    private Controller controller = new Controller();
	
	public BilDialog() {
		
        // Specielt for en JDialog
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setModal(true); //g�res modal, kan kun arbejde her indtil dialogen lukkes
        
        
        this.setLayout(null);
        this.setTitle("Bil");
        this.setLocation(150,150);
        this.setSize(360,360);

        // controls...
        opretBil=new JButton();
        opretBil.setLocation(40,250);
        opretBil.setSize(150,25);
        opretBil.setText("Opret bil");
        this.add(opretBil);
        
        tilbage=new JButton();
        tilbage.setLocation(200,250);
        tilbage.setSize(150,25);
        tilbage.setText("Tilbage");
        this.add(tilbage);
        
//      controls...
//        opretBilUdenLuk=new JButton();
//        opretBilUdenLuk.setLocation(150,150);
//        opretBilUdenLuk.setSize(200,25);
//        opretBilUdenLuk.setText("Opret bil uden luk");
//        this.add(opretBilUdenLuk);
        
        list=new JList();
        list.setListData(Service.getAlleBiler().toArray());

        scrollPane=new JScrollPane(list); //s� der kan scrolles i listen
        scrollPane.setLocation(20,100);
        scrollPane.setSize(200,150);
        this.add(scrollPane);
       
        
        
        lblM�rke = new JLabel("M�rke:");
        this.add(lblM�rke);
        lblM�rke.setLocation(10, 40);
        lblM�rke.setSize(100, 25);

        txfM�rke = new JTextField();
        this.add(txfM�rke);
        txfM�rke.setLocation(100, 40);
        txfM�rke.setSize(200, 25);
        
        lblRegnr = new JLabel("Regnr:");
        this.add(lblRegnr);
        lblRegnr.setLocation(10, 70);
        lblRegnr.setSize(100, 25);

        txfRegnr = new JTextField();
        this.add(txfRegnr);
        txfRegnr.setLocation(100, 70);
        txfRegnr.setSize(200, 25);
        
        opretBil.addActionListener(controller);
        tilbage.addActionListener(controller);
        //opretBilUdenLuk.addActionListener(controller);
        
    }
    // ActionPerformed
	private class Controller implements ActionListener{
	    
		 
    	public void actionPerformed(ActionEvent e) {
  		
    		if (e.getSource()==opretBil) {
    			// bil oprettes via Service-klassen og tilf�jes til listen
    			
    				Service.opretBil(Integer.parseInt(txfRegnr.getText()),txfM�rke.getText());
	    			list.setListData(Service.getAlleBiler().toArray());
	    			modalResult = true;
	    			BilDialog.this.setVisible(false); //pga. vi er i en indre klasse
	    			
    		}
    		if (e.getSource()==tilbage) {
    			modalResult = false;
    			BilDialog.this.setVisible(false);
    			
    		}
    		
    		
    		
//  		if (e.getSource()==opretBilUdenLuk) {
//    			// bil oprettes via Service-klassen og tilf�jes til listen, men vi bliver i dialogvinduet
//	    			service.opretBil(Integer.parseInt(txfRegnr.getText()),txfM�rke.getText());
//	    			list.setListData(service.getBiler().toArray());	
//    		}
    	}
    }
    
	
	 
}
