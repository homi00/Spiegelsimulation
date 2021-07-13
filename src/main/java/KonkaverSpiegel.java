
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
 * @author Erik Homes, Felicitas Kuhn, Theresa Stein
 */
public class KonkaverSpiegel implements SpiegelObjekt {

    private int x = 0;  //x-Koordinate obere linke Ecke
    private final int Y = 100; //y-Koordinate obere linke Ecke
    private int w = 0;  
    private int h = 0; 
    private final int SW = -45; // Startpunktwinkel 
    private final int LW = 90; // Winkel vom Kreisbogen 
    private int diameter = 0;

    public KonkaverSpiegel() {
    }

/**
 * Was macht die Methode....
 * @param point1
 * @param point2
 * @return 
 */
    
    @Override
    public Point calcPoint(Point point1, Point point2) {
        double m = (double) (point2.y - point1.y) / (double) (point2.x - point1.x); //Steigung des Strahls
        double b = (double) (point1.y) - m * (double) (point1.x); //y-Achsenabschnitt des Strahls 
        double r = (double) diameter / 2; //Radius vom Kreis
        double xk = x + r; //x-Koordinate vom Mittelpunkt des Kreises
        double yk = Y + r; //y-Koordinate vom Mittelpunkt des Kreises
        r = r - 7.5; // Radius abgezogen mit der Hälfte der gesetzten Breite 
        double z = b - yk; //z=Konstante Faktoren zusammengefasst 
        double p = (2.0 * m * z - 2.0 * xk) / (m * m + 1.0); //ausgerechnetes p (für p-q-Formel)
        double q = (z * z + xk * xk - r * r) / (m * m + 1.0); //ausgerechnetes q (für p-q-Formel)
        double x1 = (-p / 2.0) + Math.sqrt((p * p / 4.0) - q); //Koordinatentransformation des Mittelpunktes
        double y1 = m * x1 + b; //Koordinatentransformation des Mittelpunktes
        return new Point((int) x1, (int) y1);
    }

    @Override
    public boolean isOnMirror(Point point1, Point point2) {
        double r = (double) diameter / 2;
        double xk = x + r;
        r = r - 7.5;
        double a = r * Math.cos((Math.abs(SW) + 1.5) * Math.PI / 180.0) + xk;
        Point point3 = calcPoint(point1, point2);
        return point3.x >= a;
    }

    @Override
    public Point calcReflectedPoint(Point point1, Point point2) {
        return new Point(0, 0);
    }

    @Override
    public Point infiniteLine(Point point1, Point point2) {
        double m = (double) (point2.y - point1.y) / (double) (point2.x - point1.x);
        double y = m * (10000 - point1.x) + point1.y;
        return new Point(10000, (int) y);
    }

    @Override
    public void update(int width, int height) {
        diameter = height - 200;
        x = width - diameter - 50;
        w = diameter;
        h = diameter;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(green);
        g.setStroke(new BasicStroke(15));   // Erzeugt breite bei Arc 
        g.drawArc(x, Y, w, h, SW, LW);
        g.setStroke(new BasicStroke(1));
    }
}
