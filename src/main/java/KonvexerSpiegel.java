
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
 * @author Erik Homes, Felicitas Kuhn, Theresa Stein
 */
public class KonvexerSpiegel implements SpiegelObjekt {

    private int x;  //x-Koord. obere linke Ecke
    private int y; //y-Koord. obere linke Ecke
    private int w; // setzt Breite in Horizontale
    private int h; // Höhe setzt Streckung in Vertikale
    private int sw = -225; // Startpunktwinkel gegen Uhrzeigersinn startet horizontal links sw= startwinkel
    private int lw = 90; // Anteil des Kreisbogens mit Uhrzeigersinn lw=Längenwinkel

    public KonvexerSpiegel() {
    }

    public Point calcPoint(Point point1, Point point2) {
        return new Point(0, 0);
    }

    public boolean isOnMirror(Point point1, Point point2) {
        return false;
    }

    public Point calcReflectedPoint(Point point1, Point point2) {
        return new Point(0, 0);
    }

    public Point infiniteLine(Point point1, Point point2) {
        return new Point(0, 0);
    }

    public void update(int width, int height) {
        x = width - (int) (width * 0.2);
        y = (int) (height * 0.1);
        w = width - (int) (width * 0.5);
        h = height - 100;
    }

    public void paint(Graphics2D g) {
        g.setColor(red);

        g.setStroke(new BasicStroke(15));   // Erzeugt breite bei Arc 
        g.drawArc(x, y, w, h, sw, lw);
        g.setStroke(new BasicStroke(1));
    }
}
