
import java.awt.BasicStroke;
import static java.awt.Color.green;
import java.awt.Graphics2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Customer
 */
public class KonkaverSpiegel {
    
    public int arg0;  //x-Koord. obere linke Ecke
    public int arg1; //y-Koord. obere linke Ecke
    public int arg2; // setzt Breite in Horizontale
    public int arg3; // Höhe setzt Streckung in Vertikale
    public int arg4; // Startpunktwinkel gegen Uhrzeigersinn startet horizontal links
    public int arg5; // Anteil des Kreisbogens mit Uhrzeigersinn
    

    public KonkaverSpiegel(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        this.arg0 = arg0;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3= arg3;
        this.arg4= arg4;
        this.arg5= arg5;
        
    }
    
    
    
    
    
    
  
    
     public void paint(Graphics2D g) {
        g.setColor(green);

         g.drawArc(arg0, arg1, 100, 200, 270, 180);
        
    }

    
}
