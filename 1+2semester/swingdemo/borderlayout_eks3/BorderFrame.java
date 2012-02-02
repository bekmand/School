package borderlayout_eks3;

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
        JPanel panelNorth=new JPanel();
        panelNorth.setPreferredSize(new Dimension(40,40));
        panelNorth.setBorder(BorderFactory.createLoweredBevelBorder());
        
        JPanel panelCenter=new JPanel();
        panelCenter.setBorder(BorderFactory.createLoweredBevelBorder());

        JPanel panelSouth=new JPanel();
        panelSouth.setPreferredSize(new Dimension(40,40));
        panelSouth.setBorder(BorderFactory.createLoweredBevelBorder());
        
        this.add(panelNorth,BorderLayout.NORTH);
        this.add(panelCenter,BorderLayout.CENTER);
        this.add(panelSouth,BorderLayout.SOUTH);
    }
}
