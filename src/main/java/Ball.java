
import java.awt.Color;
import static java.awt.Color.pink;
import java.awt.Graphics2D;


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
 * Diese Klasse stellt einen Ball dar
 * @author Erik Homes, Felicitas Kuhn, Theresa Stein
 */
public class Ball {
    public int x; // X-Koordinate
    public int y; // Y-Koordinate
    public int r = 20; // Radius
    public Color c = pink; // Farbe

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Zeichnet den Ball
    public void paint(Graphics2D g) {
        g.setColor(c);
        g.fillOval(x - r / 2, y - r / 2, r, r);
    }
}
