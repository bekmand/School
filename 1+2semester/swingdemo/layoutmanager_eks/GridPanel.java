package layoutmanager_eks;

import java.awt.*;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;


public class GridPanel extends JPanel {

    private String name;
    
    public void setName(String name) {
        this.name=name;
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        Font f=new Font("Arial",Font.BOLD,18);
        g.setFont(f);

        FontMetrics fm   = g.getFontMetrics(f);  // metrics for this object
        Rectangle2D rect = fm.getStringBounds(name, g); // size of string
        
        g.drawString(name, this.getWidth()/2-(int)rect.getWidth()/2, this.getHeight()/2+(int)rect.getHeight()/2);
        
        int x=10; int y=10;
        g.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);
        
        while (x<this.getWidth()) {
            g.drawLine(x,0,x,this.getHeight()-1);
            x+=10;
        }
        while (y<this.getHeight()) {
            g.drawLine(0,y,this.getWidth()-1,y);
            y+=10;
        }
    }
}
