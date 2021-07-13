
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
public class Planerspiegel implements SpiegelObjekt {

    private int x;
    private int y;
    private final int W = 15;
    private int h;

    public Planerspiegel() {
    }

    @Override
    public Point calcPoint(Point point1, Point point2) {
        double m = (double) (point2.y - point1.y) / (double) (point2.x - point1.x);
        double y = m * (x - point1.x) + point1.y;
        return new Point(x, (int) y);
    }

    @Override
    public boolean isOnMirror(Point point1, Point point2) {
        Point point3 = calcPoint(point1, point2);
        return (point3.y >= y) && (point3.y <= y + h);
    }

    @Override
    public Point calcReflectedPoint(Point point1, Point point2) {
        Point point3 = calcPoint(point1, point2);
        int y = 2 * point3.y - point1.y;
        return new Point(point1.x, y);
    }

    @Override
    public Point infiniteLine(Point point1, Point point2) {
        double m = (double) (point2.y - point1.y) / (double) (point2.x - point1.x);
        double y = m * (10000 - point1.x) + point1.y;
        return new Point(10000, (int) y);
    }

    @Override
    public void update(int width, int height) {
        x = width - 100;
        h = height - (int) (height * 0.4);
        y = (int) (height * 0.2);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(white);
        g.fillRect(x, y, 15, h);
    }
}
