
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
public interface SpiegelObjekt {

    void update(int width, int height);

    void paint(Graphics2D g);

    public boolean isOnMirror(Point point1, Point point2);

    public Point calcPoint(Point point1, Point point2);

    public Point infiniteLine(Point point1, Point point2);

    public Point calcReflectedPoint(Point point1, Point point2);
}
