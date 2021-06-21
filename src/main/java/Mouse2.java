/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Customer
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.Color;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Customer
 */
public class Mouse2 extends CenterPanel {
    //...
    public Mouse2 (){
    this.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e){
             Mouse2.addObject(new Ball(e.getX(), e.getY(), Color.PINK));
             
                CenterPanel.repaint();
            
            
        }
    });
    //...
}}


//Mouse kein Leserecht mehr?
