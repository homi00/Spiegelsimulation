
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.JPanel;
import static java.awt.Color.yellow;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Customer
 */
public class CenterPanel extends JPanel {

    private Planerspiegel PSpiegel = new Planerspiegel(0, 0, 0, 0);
    private KonkaverSpiegel KKSpiegel = new KonkaverSpiegel(0, 0, 0, 0, 0, 0);
    private KonvexerSpiegel KVSpiegel = new KonvexerSpiegel(0, 0, 0, 0, 0, 0);
    private Point point1 = null;
    private Point point2 = null;
    private boolean ersterKlick = true;

    CenterPanel() {

        setBackground(Color.black);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //Anfangspunkt = new Ball (e.getX(), e.getY());
                if (ersterKlick == true) {
                    point1 = new Point(e.getX(), e.getY());

                    ersterKlick = false;

                } else {
                    point2 = new Point(e.getX(), e.getY());
                }
                CenterPanel.this.repaint();
            }
        });
    }

    public void reset() {
        PSpiegel = new Planerspiegel(0, 0, 0, 0);
        point1 = null;
        point2 = null;
        ersterKlick = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = this.getWidth();
        int h = this.getHeight();
        PSpiegel.x = w - 100;
        PSpiegel.w = 15;
        PSpiegel.h = h - (int) (h * 0.4);
        PSpiegel.y = (int) (h * 0.2);

        PSpiegel.paint(g2d);
        

        KKSpiegel.arg0 = w - (int) (w * 0.6);
        KKSpiegel.arg1 = (int) (h * 0.1);
        KKSpiegel.arg2 = w - (int) (w * 0.5);
        KKSpiegel.arg3 = h - 100 ;
        KKSpiegel.arg4 = -45;
        KKSpiegel.arg5 = 90;
        
        KVSpiegel.arg0 = w - (int) (w * 0.6);
        KVSpiegel.arg1 = (int) (h * 0.1);
        KVSpiegel.arg2 = w - (int) (w * 0.5);
        KVSpiegel.arg3 = h - 100 ;
        KVSpiegel.arg4 = -135;
        KVSpiegel.arg5 = 90;
        
        
        
        
        
        g2d.setStroke(new BasicStroke(15));   // Erzeugt breite bei Arc 
        KKSpiegel.paint(g2d);
        g2d.setStroke(new BasicStroke(1));
        
        
        if (point1 != null) {     // ungleich Null = es gibt einen Ball 
            Ball ball = new Ball(point1.x, point1.y);
            ball.paint(g2d);
        }
        if (point1 != null && point2 != null) {
            Point point3 = PSpiegel.calcPoint(point1, point2);
            g2d.setColor(yellow);
            g2d.drawLine(point1.x, point1.y, point3.x, point3.y);
            if (PSpiegel.IsOnMirror(point1, point2)) {
                Point point4 = PSpiegel.calcReflectedPoint(point1, point2);
                g2d.drawLine(point3.x, point3.y, point4.x, point4.y);

            } else {
                Point infinitePoint = PSpiegel.infiniteLine(point1, point2);
                g2d.setColor(yellow);
                g2d.drawLine(point3.x, point3.y, 10000, infinitePoint.y);
            };

        }
        g2d.dispose();
    }
}
