
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

    private Planerspiegel Spiegel = new Planerspiegel(0, 0, 0, 0);
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = this.getWidth();
        int h = this.getHeight();
        Spiegel.x = w - 100;
        Spiegel.w = 20;
        Spiegel.h = h - (int) (h * 0.4);
        Spiegel.y = (int) (h * 0.2);

        Spiegel.paint(g2d);

        if (point1 != null) {     // ungleich Null = es gibt einen Ball 
            Ball ball = new Ball(point1.x, point1.y);
            ball.paint(g2d);
        }
        if (point1 != null && point2 != null) {
            Point point3 = Spiegel.calcPoint(point1, point2);
            g2d.setColor(yellow);
            g2d.drawLine(point1.x, point1.y, point3.x, point3.y);
            if (Spiegel.IsOnMirror(point1, point2)) {
                Point point4 = Spiegel.calcReflectedPoint(point1, point2);
                g2d.drawLine(point3.x, point3.y, point4.x, point4.y);

            } else {
                Point infinitePoint = Spiegel.infiniteLine(point1, point2);
                g2d.setColor(yellow);
                g2d.drawLine(point3.x, point3.y, 2000000000, infinitePoint.y);
            };

        }
        g2d.dispose();
    }
}
