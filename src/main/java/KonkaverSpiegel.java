
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
/**
 * Klasse stellt einen konkaven Spiegel dar 
 * @author Erik Homes, Felicitas Kuhn, Theresa Stein
 */
public class KonkaverSpiegel implements SpiegelObjekt {
    private int x = 0;  //x-Koordinate obere linke Ecke
    private final int Y = 100; //y-Koordinate obere linke Ecke
    private int w = 0; // Breite des Kreises
    private int h = 0; // Höhe des Kreises
    private final int SW = -45; // Startpunktwinkel 
    private final int LW = 90; // Winkel vom Kreisbogen 
    private int diameter = 0; // Durchmesser des Kreises 

    public KonkaverSpiegel() {
    }

    @Override
    public Point calcPoint(Point point1, Point point2) {
        // Berechnung der Schnittpunkte einer Geraden mit dem Kreis mit Hilfe der Kreisfunktion, der Geradengleichung und der p-q-Formel
        double m = (double) (point2.y - point1.y) / (double) (point2.x - point1.x); // Steigung des Strahls
        double b = (double) (point1.y) - m * (double) (point1.x); // y-Achsenabschnitt des Strahls 
        double r = (double) diameter / 2; // Radius vom Kreis
        double xk = x + r; // x-Koordinate vom Mittelpunkt des Kreises
        double yk = Y + r; // y-Koordinate vom Mittelpunkt des Kreises
        r = r - 7.5; // Radius abgezogen mit der Hälfte der gesetzten Breite 
        double z = b - yk; // z=Konstante Faktoren zusammengefasst 
        double p = (2.0 * m * z - 2.0 * xk) / (m * m + 1.0); // ausgerechnetes p (für p-q-Formel)
        double q = (z * z + xk * xk - r * r) / (m * m + 1.0); // ausgerechnetes q (für p-q-Formel)
        // Überprüfe ob der Term unter der Wurzel >= 0 ist  
        if ((p * p / 4.0) - q >= 0) {
            double x1 = (-p / 2.0) + Math.sqrt((p * p / 4.0) - q); // Koordinatentransformation des Mittelpunktes in x-Richtung
            double y1 = m * x1 + b; // Koordinatentransformation des Mittelpunktes in y-Richtung 
            return new Point((int) x1, (int) y1); // Rückgabe des Schnittpunktes mit dem rechten Kreisbogen 
        }
        // Es gibt keinen Schnittpunkt zwischen Gerade und Kreis
        // Nullpunkt wird zurückgegeben 
        return new Point(0, 0);
    }

    @Override
    public boolean isOnMirror(Point point1, Point point2) {
        double r = (double) diameter / 2; 
        double xk = x + r;
        r = r - 7.5;
        // Berechne die kleinste x-Koordinate des Kreisbogens
        double xmin = r * Math.cos((Math.abs(SW) + 1.5) * Math.PI / 180.0) + xk;
        // Berechne den Schnittpunkt
        Point point3 = calcPoint(point1, point2);
        // Überprüfe ob die x-Koordinate des Schnittpunktes größer ist als die kleinste x-Koordinate des Kreisbogens 
        return point3.x >= xmin;
    }

    @Override
    public Point calcReflectedPoint(Point point1, Point point2) {
        // Berechnung des Spiegelpunktes von Punkt 1 mit folgenden Schritten
        // - Berechnung des Mittelpunktwinkels (alpha) des Schnittpunktes 
        // - Drehung Punkt 1 um alpha
        // - Spiegelung von Punkt 1 an dem Lot
        // - Drehung des gespiegelten Punktes um -alpha
        double r = (double) diameter / 2;
        Point center = new Point((int) (x + r), (int) (Y + r)); // Mittelpunkt des Kreises
        r = r - 7.5;
        Point point3 = calcPoint(point1, point2); // Berechne den Schnittpunkt
        double alpha = Math.acos((point3.x - center.x) / r); // Berechne den Mittelpunktwinkel alpha 
        // Ist die y-Koordinate des Schnittpunktes > y-Koordinate des Mittelpunktes?
        if (point3.y > center.y) {
            alpha = -alpha; // Änderung der Drehrichtung 
        }
        Point point4 = rotate(center, point1, alpha); // Drehung Punkt 1 um alpha
        point4.y = 2 * center.y - point1.y; // Spiegelung von Punkt 1 am Lot
        point4 = rotate(center, point4, -alpha); // Drehung des gespiegelten Punktes zurück (um -alpha)
        return point4;
    }

    @Override
    public Point infiniteLine(Point point1, Point point2) {
        // Berechnung des Richtungsvektors
        double vx = point2.x-point1.x;
        double vy = point2.y-point1.y;
        // Normierung des Richtungsvektors
        double n = Math.sqrt(vx*vx+vy*vy); // Berechnung des Betrags 
        vx = vx / n;
        vy = vy / n;
        // Neuer Punkt 10000 mal in Richtung des Richtungsvektors von Punkt 1 aus
        return new Point((int)(point1.x+10000*vx), (int) (point1.y+10000*vy));
    }
    
    @Override
    public void update(int width, int height) {
        diameter = height - 200; // Kreisdurchmesser 
        x = width - diameter - 50; // 50 Pixel Abstand vom rechten Rand 
        // Gleichsetzen von Höhe und Breite für Kreis
        w = diameter; 
        h = diameter;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(green);
        g.setStroke(new BasicStroke(15)); // Erzeugt Breite bei Arc 
        g.drawArc(x, Y, w, h, SW, LW);
        g.setStroke(new BasicStroke(1)); // Setzt Breite für den Strahl wieder auf 1 Pixel 
    }

    // Rotieren des Punkt p um den den Punkt rp mit dem Winkel alpha
    private Point rotate(Point rp, Point p, double alpha) {
        // Drehung eines Punktes mit einer Parallelverschiebung und einer Rotationsmatrix
        double x = (Math.cos(alpha) * (p.x - rp.x) - Math.sin(alpha) * (p.y - rp.y)) + rp.x; 
        double y = (Math.sin(alpha) * (p.x - rp.x) + Math.cos(alpha) * (p.y - rp.y)) + rp.y;
        return new Point((int) x, (int) y);
    }
}
