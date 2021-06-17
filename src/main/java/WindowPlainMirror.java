
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Customer
 */
public class WindowPlainMirror {
    JFrame frame = new JFrame();
    JLabel label = new JLabel ("Hello!");
    WindowPlainMirror(){
        
        
        label.setBounds(0, 0, 100, 150);
        label.setFont(new Font(null,Font.PLAIN,25));
        
        frame.add(label);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
