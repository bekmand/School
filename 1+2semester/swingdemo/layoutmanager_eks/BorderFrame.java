package layoutmanager_eks;

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
        GridPanel gpc=new GridPanel();
        gpc.setName("center");
        gpc.setPreferredSize(new Dimension(100,100));
        
        GridPanel gps=new GridPanel();
        gps.setName("south");
        gps.setPreferredSize(new Dimension(80,50));
        
        GridPanel gpn=new GridPanel();
        gpn.setName("north");
        gpn.setPreferredSize(new Dimension(80,50));
        
        GridPanel gpw=new GridPanel();
        gpw.setName("west");
        gpw.setPreferredSize(new Dimension(80,50));
        
        GridPanel gpe=new GridPanel();
        gpe.setName("east");
        gpe.setPreferredSize(new Dimension(80,50));
        
        this.add(gpc,BorderLayout.CENTER);
        this.add(gps,BorderLayout.SOUTH);
        this.add(gpn,BorderLayout.NORTH);
        this.add(gpw,BorderLayout.WEST);
        this.add(gpe,BorderLayout.EAST);
    }
}
