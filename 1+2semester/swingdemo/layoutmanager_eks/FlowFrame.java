package layoutmanager_eks;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlowFrame extends JFrame {
    
    public FlowFrame() {
        // the frame's own attributtes...
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,25,10));
        this.setTitle("FlowLayout");
        this.setLocation(20,350);
        this.setSize(400,300);
 
        // controls...
        JLabel lbl1=new JLabel("Dette er label 1");
        this.add(lbl1);
        
        JButton btn1=new JButton("Knap 1");
        this.add(btn1);
        
        JButton btn2=new JButton("Knap ned langt navn");
        this.add(btn2);

        JTextField txt1=new JTextField();
        int h=txt1.getPreferredSize().height;
        txt1.setPreferredSize(new Dimension(100,h));
        this.add(txt1);

        
        JTextField txt2=new JTextField();
        txt2.setPreferredSize(new Dimension(60,h));
        this.add(txt2);
        
        // this.pack();
    }
}
