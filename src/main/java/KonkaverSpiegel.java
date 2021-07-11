
import java.awt.BasicStroke;
import static java.awt.Color.green;
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
public class KonkaverSpiegel implements SpiegelObjekt {

    public int arg0;  //x-Koord. obere linke Ecke
    public int arg1; //y-Koord. obere linke Ecke
    public int arg2; // setzt Breite in Horizontale
    public int arg3; // Höhe setzt Streckung in Vertikale
    public int arg4; // Startpunktwinkel gegen Uhrzeigersinn startet horizontal links
    public int arg5; // Anteil des Kreisbogens mit Uhrzeigersinn
    int diameter = 0;

    public KonkaverSpiegel(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        this.arg0 = arg0;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        this.arg4 = arg4;
        this.arg5 = arg5;
    }

     public boolean IsOnMirror(Point point1, Point point2){
     return true;
     }
     
    public Point calcPoint(Point point1, Point point2){
     double m = (double) (point2.y - point1.y) / (double) (point2.x - point1.x); 
     double b = (double) (point1.y) - m * (double)(point1.x);
     double r = (double) diameter/2;
     double p = (2.0 * m * b)/ (1.0 + m * m);
     double q = (b*b-r*r)/ (1.0 +m*m);
     double x1 = (-p/2.0)+ Math.sqrt((p*p/4.0)-q);
     double y1 = Math.sqrt(r*r-x1*x1);
     return new Point ((int) x1 + arg0, (int) y1 + arg1);
             
    }

    public Point infiniteLine(Point point1, Point point2){
      return new Point (0,0);   
    }

    public Point calcReflectedPoint(Point point1, Point point2){
        return new Point (0,0); 
    }
    
    
    public void update(int width, int height) {      
        diameter = height - 200;
        arg0 = width - diameter - 50;
        arg1 = 100;
        arg2 = diameter;
        arg3 = diameter;
        arg4 = -45;
        arg5 = 90;

    }

    public void paint(Graphics2D g) {
        g.setColor(green);
        g.setStroke(new BasicStroke(15));   // Erzeugt breite bei Arc 
        g.drawArc(arg0, arg1, arg2, arg3, -45, 90);
        g.setStroke(new BasicStroke(1));
    }

}
