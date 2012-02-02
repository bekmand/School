package layoutmanager_eks;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridFrame extends JFrame {
    
    public GridFrame() {
        // the frame's own attributtes...
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,2,20,10));
        this.setTitle("GridLayout");
        this.setLocation(450,350);
        this.setSize(400,300);
 
        // controls...
        JLabel lbl1=new JLabel("Dette er label 1");
        this.add(lbl1);
        
        JTextField txt1=new JTextField();
        txt1.setText("TextField nr. 1");
        this.add(txt1);
        
        JLabel lbl2=new JLabel("Label 2");
        this.add(lbl2);
        
        JTextField txt2=new JTextField();
        txt2.setText("txt2");
        this.add(txt2);
        
        JButton btn1=new JButton("Knap 1");
        this.add(btn1);
        
        JButton btn2=new JButton("Knap med langt navn");
        this.add(btn2);
        
       this.pack();
    }
}
