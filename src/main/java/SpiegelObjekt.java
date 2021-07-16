
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
 * Gemeinsames Interface für alle Spiegelarten 
 * @author Erik Homes, Felicitas Kuhn, Theresa Stein
 */
public interface SpiegelObjekt {

    // Informiert den Spiegl über eine Änderung der Panelgröße
    void update(int width, int height);

    // Zeichnet den Spiegel
    void paint(Graphics2D g);

    // Überprüft ob die Gerade einen Schnittpunkt mit dem Spiegel hat
    public boolean isOnMirror(Point point1, Point point2);

    // Berechnet den Schnittpunkt einer Gerade mit dem Spiegel
    public Point calcPoint(Point point1, Point point2);

    // Berechnet einen Punkt der Geraden außerhalb des Panels
    public Point infiniteLine(Point point1, Point point2);

    // Berechnet den reflektierten Punkt von Punkt 1
    public Point calcReflectedPoint(Point point1, Point point2);
}
