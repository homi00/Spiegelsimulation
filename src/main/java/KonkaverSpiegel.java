
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

    private int arg0 = 0;  //x-Koord. obere linke Ecke
    private int arg1 = 100; //y-Koord. obere linke Ecke
    private int arg2 = 0; // setzt Breite in Horizontale
    private int arg3 = 0; // Höhe setzt Streckung in Vertikale
    private int arg4 = -45; // Startpunktwinkel gegen Uhrzeigersinn startet horizontal links
    private int arg5 = 90; // Anteil des Kreisbogens mit Uhrzeigersinn
    private int diameter = 0;

    public KonkaverSpiegel() {
    }

    public boolean IsOnMirror(Point point1, Point point2) {
        double r = (double) diameter / 2;
        double xk = arg0 + r;
        r = r - 7.5;
        double a = r * Math.cos((Math.abs(arg4) + 1.5) * Math.PI / 180.0) + xk;
        Point point3 = calcPoint(point1, point2);
        return point3.x >= a;
    }

    public Point calcPoint(Point point1, Point point2) {
        double m = (double) (point2.y - point1.y) / (double) (point2.x - point1.x);
        double b = (double) (point1.y) - m * (double) (point1.x);
        double r = (double) diameter / 2;
        double xk = arg0 + r;
        double yk = arg1 + r;
        r = r - 7.5;
        double z = b - yk;
        double p = (2.0 * m * z - 2.0 * xk) / (m * m + 1.0);
        double q = (z * z + xk * xk - r * r) / (m * m + 1.0);
        double x1 = (-p / 2.0) + Math.sqrt((p * p / 4.0) - q);
        double y1 = m * x1 + b;
        return new Point((int) x1, (int) y1);
    }

    public Point infiniteLine(Point point1, Point point2) {
        double m = (double) (point2.y - point1.y) / (double) (point2.x - point1.x);
        double y = m * (10000 - point1.x) + point1.y;
        return new Point(10000, (int) y);
    }

    public Point calcReflectedPoint(Point point1, Point point2) {
        return new Point(0, 0);
    }

    public void update(int width, int height) {
        diameter = height - 200;
        arg0 = width - diameter - 50;
        arg2 = diameter;
        arg3 = diameter;

    }

    public void paint(Graphics2D g) {
        g.setColor(green);
        g.setStroke(new BasicStroke(15));   // Erzeugt breite bei Arc 
        g.drawArc(arg0, arg1, arg2, arg3, arg4, arg5);
        g.setStroke(new BasicStroke(1));
    }

}
