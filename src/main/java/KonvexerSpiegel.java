
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
    
    public int arg0;  //x-Koord. obere linke Ecke
    public int arg1; //y-Koord. obere linke Ecke
    public int arg2; // setzt Breite in Horizontale
    public int arg3; // Höhe setzt Streckung in Vertikale
    public int arg4; // Startpunktwinkel gegen Uhrzeigersinn startet horizontal links
    public int arg5; // Anteil des Kreisbogens mit Uhrzeigersinn
    

    public KonvexerSpiegel(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        this.arg0 = arg0;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3= arg3;
        this.arg4= arg4;
        this.arg5= arg5;
        
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
        arg4 = -225;
        arg5 = 90;

    }
    
    
    
  
    
     public void paint(Graphics2D g) {
        g.setColor(red);

         g.setStroke(new BasicStroke(15));   // Erzeugt breite bei Arc 
        g.drawArc(arg0, arg1, arg2, arg3, -225, 90);
        g.setStroke(new BasicStroke(1));
        
    }

    
}
