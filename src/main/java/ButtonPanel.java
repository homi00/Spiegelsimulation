
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Customer
 */
public class ButtonPanel extends JPanel {
    
    
    
    ButtonPanel (){
        
    JButton planeButton = new JButton("Planer Spiegel");
    JButton concaveButton = new JButton("Konkaver Spiegel");
    JButton convexButton = new JButton("Konvexer Spiegel");
    
    add(planeButton);

    add(concaveButton);

    add(convexButton);
    
}

}
