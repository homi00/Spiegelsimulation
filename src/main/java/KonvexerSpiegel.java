
import java.awt.BasicStroke;
import static java.awt.Color.red;
import java.awt.Graphics2D;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Customer
 */
public class KonvexerSpiegel implements SpiegelObjekt {
    
    private int arg0;  //x-Koord. obere linke Ecke
    private int arg1; //y-Koord. obere linke Ecke
    private int arg2; // setzt Breite in Horizontale
    private int arg3; // Höhe setzt Streckung in Vertikale
    private int arg4 = -225; // Startpunktwinkel gegen Uhrzeigersinn startet horizontal links
    private int arg5 = 90; // Anteil des Kreisbogens mit Uhrzeigersinn
    

    public KonvexerSpiegel() {
    }
    
    public boolean IsOnMirror(Point point1, Point point2){
     return false;
     }
     
    public Point calcPoint(Point point1, Point point2){
     return new Point (0,0);   
    }

    public Point infiniteLine(Point point1, Point point2){
      return new Point (0,0);   
    }

    public Point calcReflectedPoint(Point point1, Point point2){
        return new Point (0,0); 
    }
    
    
    
    public void update(int width, int height) {

        arg0 = width - (int) (width * 0.2);
        arg1 = (int) (height * 0.1);
        arg2 = width - (int) (width * 0.5);
        arg3 = height - 100;
    }
    
    
    
  
    
     public void paint(Graphics2D g) {
        g.setColor(red);

         g.setStroke(new BasicStroke(15));   // Erzeugt breite bei Arc 
        g.drawArc(arg0, arg1, arg2, arg3, -225, 90);
        g.setStroke(new BasicStroke(1));
        
    }

    
}
