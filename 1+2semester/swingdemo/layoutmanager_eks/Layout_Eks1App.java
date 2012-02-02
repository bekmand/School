package layoutmanager_eks;

import java.awt.FlowLayout;

import javax.swing.*;

public class Layout_Eks1App {

	public static void main(String[] args) {
        BorderFrame borderFrame = new BorderFrame();
        BoxFrame boxFrame = new BoxFrame();
        FlowFrame flowFrame=new FlowFrame();
        GridFrame gridFrame=new GridFrame();
        
        borderFrame.setVisible(true);
        boxFrame.setVisible(true);
        flowFrame.setVisible(true);
        gridFrame.setVisible(true);
	}
}
