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
 * @author Customer
 */
public class Ball {

    public int x;
    public int y;
    public int r;
    public Color c;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.r = 20;
        this.c = pink;

    }

    public void paint (Graphics2D g){
	g.setColor(c);
        g.fillOval(x-r/2, y-r/2, r, r);
        
    }
}
//Kommentar der Krise