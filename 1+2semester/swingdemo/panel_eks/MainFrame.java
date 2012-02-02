package panel_eks;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    
    public MainFrame() {
        // the frame's own attributtes...
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("MyGUIApp");
        this.setLocation(50,50);
        this.setSize(640,480);
 
        // panel
        JPanel panel=new JPanel();
        
        panel.setLocation(20,20);
        panel.setSize(400,50);
        panel.setLayout(new FlowLayout());
        
        // componenter i Panel
        JLabel lbl=new JLabel("Navn:");
        panel.add(lbl);
        
        JTextField txt1=new JTextField();
        int h=txt1.getPreferredSize().height;
        txt1.setPreferredSize(new Dimension(200,h));
        panel.add(txt1);
        
        JButton btn1=new JButton("Tilføj");
        panel.add(btn1);
        
        // indsæt panel i Frame
        this.add(panel);
    }
}
