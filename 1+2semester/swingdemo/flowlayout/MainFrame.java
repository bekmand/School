package flowlayout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    
    public MainFrame() {
        // the frame's own attributtes...
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("MyGUIApp");
        this.setLocation(50,50);
        this.setSize(640,480);
 
        // components
        JLabel lbl=new JLabel("Navn:");
        this.add(lbl);
        
        JTextField txt1=new JTextField();
        int h=txt1.getPreferredSize().height;
        txt1.setPreferredSize(new Dimension(200,h));
        this.add(txt1);
        
        JButton btn1=new JButton("Tilføj");
        this.add(btn1);
        
    }
}
