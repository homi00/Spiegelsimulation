import static java.awt.Color.white;
import java.awt.Graphics2D;

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

    public void paint (Graphics2D g){
	g.setColor(white);
        g.fillRect(x+w/2, y, 20, h );
        
    }
}