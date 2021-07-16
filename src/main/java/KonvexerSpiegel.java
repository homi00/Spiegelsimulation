
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
/**
 * Klasse für konvexen Spiegel muss noch implementiert werden
 * @author Erik Homes, Felicitas Kuhn, Theresa Stein
 */
public class KonvexerSpiegel implements SpiegelObjekt {

    private int x;  //x-Koordinate obere linke Ecke
    private int y; //y-Koordinate obere linke Ecke
    private int w; // Breite des Kreise 
    private int h; // Höhe des Kreises 
    private final int SW = -225; // Startpunktwinkel 
    private final int LW = 90; // Winkel vom Kreisbogen

    public KonvexerSpiegel() {
    }

    @Override
    public Point calcPoint(Point point1, Point point2) {
        return new Point(0, 0);
    }

    @Override
    public boolean isOnMirror(Point point1, Point point2) {
        return false;
    }

    @Override
    public Point calcReflectedPoint(Point point1, Point point2) {
        return new Point(0, 0);
    }

    @Override
    public Point infiniteLine(Point point1, Point point2) {
        return new Point(0, 0);
    }

    @Override
    public void update(int width, int height) {
        x = width - (int) (width * 0.2);
        y = (int) (height * 0.1);
        w = width - (int) (width * 0.5);
        h = height - 100;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(red);

        g.setStroke(new BasicStroke(15));   // Erzeugt breite bei Arc 
        g.drawArc(x, y, w, h, SW, LW);
        g.setStroke(new BasicStroke(1));
    }
}
