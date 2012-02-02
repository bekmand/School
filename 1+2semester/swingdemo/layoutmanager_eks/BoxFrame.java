package layoutmanager_eks;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoxFrame extends JFrame {
    
    public BoxFrame() {
        // the frame's own attributtes...
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
        this.setTitle("BoxLayout");
        this.setLocation(450,50);
        this.setSize(400,300);
 
        // controls...
        JLabel lbl1=new JLabel("Dette er en label");
        this.add(lbl1);
        
        JButton btn1=new JButton("Knap 1");
        this.add(btn1);
        
        JButton btn2=new JButton("Knap ned langt navn");
        this.add(btn2);

        JTextField txt1=new JTextField();
        this.add(txt1);
        txt1.setText("TextField nr. 1");
 
        JTextField txt2=new JTextField();
        txt2.setText("txt2");
        this.add(txt2);

     //   this.pack();
    }
}
