
import static java.awt.Color.white;
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
 * Klasse stellt einen planen Spiegel dar 
 * @author Erik Homes, Felicitas Kuhn, Theresa Stein
 */
public class Planerspiegel implements SpiegelObjekt {
    private int x; // X-Koordinate
    private int y; // Y-Koordinate
    private final int W = 15; // Breite
    private int h; // Höhe

    public Planerspiegel() {
    }

    @Override
    public Point calcPoint(Point point1, Point point2) {
        double m = (double) (point2.y - point1.y) / (double) (point2.x - point1.x); // Steigung der Geraden 
        double y = m * (x - point1.x) + point1.y; // Berechnung des y-Wertes des Schnittpunktes  
        return new Point(x, (int) y); // Rückgabe des Schnittpunktes 
    }

    @Override
    public boolean isOnMirror(Point point1, Point point2) {
        Point point3 = calcPoint(point1, point2); // Berechne den möglichen Schnittpunkt
        return (point3.y >= y) && (point3.y <= y + h); // Überprüfe ob dieser auf dem Spiegel liegt
    }

    @Override
    public Point calcReflectedPoint(Point point1, Point point2) {
        Point point3 = calcPoint(point1, point2); // Berechne den Schnittpunkt
        int y = 2 * point3.y - point1.y; // Spiegel den Punkt 1 an dem Lot 
        return new Point(point1.x, y); // Rücklgabe des reflektierten Punktes 
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
        x = width - 100; // 100 Pixel Abstand vom rechten Rand
        // Oben und unten 20% Abstand zu den Rändern der Fensterhöhe 
        h = height - (int) (height * 0.4); 
        y = (int) (height * 0.2); 
    }

    @Override
    public void paint(Graphics2D g) {
        // Zeichne den Spiegel in weiß mit einer Breite von 15 Pixeln 
        g.setColor(white);
        g.fillRect(x, y, 15, h);
    }
}
