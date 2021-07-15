
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import static java.awt.Color.yellow;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Erik Homes, Felicitas Kuhn, Theresa Stein
 */
public class CenterPanel extends JPanel {

    private SpiegelObjekt spiegel = new Planerspiegel();

    private Point point1 = null;
    private Point point2 = null;
    private boolean ersterKlick = true;

    CenterPanel() {

        setBackground(Color.black);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
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

    public void setPlanerspiegel() {
        spiegel = new Planerspiegel();
        point1 = null;
        point2 = null;
        ersterKlick = true;
        this.repaint();
    }

    public void setKonkaverSpiegel() {
        spiegel = new KonkaverSpiegel();
        point1 = null;
        point2 = null;
        ersterKlick = true;
        this.repaint();
    }

    public void setKonvexerSpiegel() {
        spiegel = new KonvexerSpiegel();
        point1 = null;
        point2 = null;
        ersterKlick = true;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = this.getWidth();
        int h = this.getHeight();

        spiegel.update(w, h);

        spiegel.paint(g2d);

        if (point1 != null) {     // ungleich Null = es gibt einen Ball 
            Ball ball = new Ball(point1.x, point1.y);
            ball.paint(g2d);
        }

        if (point1 != null && point2 != null) {
            Point point3 = spiegel.calcPoint(point1, point2);
            g2d.setColor(yellow);
            g2d.drawLine(point1.x, point1.y, point3.x, point3.y);
            if (spiegel.isOnMirror(point1, point2)) {
                Point point4 = spiegel.calcReflectedPoint(point1, point2);
                g2d.drawLine(point3.x, point3.y, point4.x, point4.y);

            } else {
                Point infinitePoint = spiegel.infiniteLine(point1, point2);
                g2d.setColor(yellow);
                g2d.drawLine(point3.x, point3.y, infinitePoint.x, infinitePoint.y);
            }

        }
        g2d.dispose();
    }
}
