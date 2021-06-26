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
 * @author theresastein
 */
public class Planerspiegel {

    public int x;
    public int y;
    public int w; // width: Breite
    public int h; //Höhe 

    public Planerspiegel(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    
    public boolean IsOnMirror(Point point1, Point point2){
        Point point3 = calcPoint(point1, point2);
        return (point3.y >= y) && (point3.y <= y + h);
    }
            
    public Point calcPoint(Point point1, Point point2) {
        double m = (double) (point2.y - point1.y) / (double) (point2.x - point1.x);
        double y = m * (x - point1.x) + point1.y;
        return new Point(x, (int) y);          
    }
    
    public Point calcReflectedPoint (Point point1, Point point2) {
        Point point3 = calcPoint(point1, point2);
        int y = 2 * point3.y - point1.y;
        return new Point (point1.x , y);
    }

    public void paint(Graphics2D g) {
        g.setColor(white);
        g.fillRect(x , y, 20, h);

    }
}