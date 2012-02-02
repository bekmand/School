package borderlayout_eks2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BorderFrame extends JFrame {
    
    public BorderFrame() {
        // the frame's own attributtes...
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("BorderLayout");
        this.setLocation(20,20);
        this.setSize(400,300);
 
        // controls...
        JTextField txtNorth=new JTextField();
        txtNorth.setText("North");
        this.add(txtNorth,BorderLayout.NORTH);

        JButton btnWest=new JButton("Westknap");
        this.add(btnWest,BorderLayout.WEST);

        JButton btnSouth=new JButton("Sydknap");
        this.add(btnSouth,BorderLayout.SOUTH);
        
        String[] items={"Anne","Bettina","Camilla","Dorte","Erica",
                        "Fellicia","Gitte","Hanne","Irene","Jane",
                        "Kirsten","Lotte","Mette","Nete","Ophelia"};
        JList list=new JList(items);
        JScrollPane scrollPane=new JScrollPane(list);
        this.add(scrollPane,BorderLayout.CENTER);
    }
}
