
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
/**
 * Panelklasse mit der Zeichenfläche
 * @author Erik Homes, Felicitas Kuhn, Theresa Steinn
 */
public class CenterPanel extends JPanel {

    private SpiegelObjekt spiegel = new Planerspiegel(); // Aktuelles Spiegelobjekt
    private Point point1 = null; // Erster Punkt des Strahls
    private Point point2 = null; // Zweiter Punkt des Strahls
    private boolean ersterKlick = true; 

    CenterPanel() {

        setBackground(Color.black);

        // Listener für Mausklicks mit dem die Punkte des Strahls festgelegt werden 
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

    // Setzt als aktives Spiegelobjekt den planen Spiegel 
    public void setPlanerspiegel() {
        spiegel = new Planerspiegel();
        point1 = null;
        point2 = null;
        ersterKlick = true;
        this.repaint();
    }

    // Setzt als aktives Spiegelobjekt den konkaven Spiegel 
    public void setKonkaverSpiegel() {
        spiegel = new KonkaverSpiegel();
        point1 = null;
        point2 = null;
        ersterKlick = true;
        this.repaint();
    }

    // Setzt als aktives Spiegelobjekt den konvexen Spiegel 
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

        // Informiert den Spiegel über neue Fenstergröße und zeichnet den Spiegel neu 
        spiegel.update(w, h);
        spiegel.paint(g2d);

        // Ist der erste Punkt definiert?
        if (point1 != null) {     
            // Zeichne einen Ball an Punkt 1
            Ball ball = new Ball(point1.x, point1.y);
            ball.paint(g2d);
        }

        // Ist der Strahl definiert?
        if (point1 != null && point2 != null) {
            // Setze die Farbe des Strahls 
            g2d.setColor(yellow);
            // Gibt es einen Schnittpunkt mit dem Spiegel?
            if (spiegel.isOnMirror(point1, point2)) {
                // Berechne den Schnittpunkt
                Point point3 = spiegel.calcPoint(point1, point2);
                // Zeichne den Strahl bis zu dem Schnittpunkt
                g2d.drawLine(point1.x, point1.y, point3.x, point3.y);
                // Berechne den reflektierten Punkt
                Point point4 = spiegel.calcReflectedPoint(point1, point2);
                // Zeichne reflektierten Strahl
                g2d.drawLine(point3.x, point3.y, point4.x, point4.y);    
            } 
            else {
                // Es gibt keinen Schnittpunkt mit dem Spiegel
                // Berechne einen Punkt außerhalb des Bereichs und zeichne den Strahl
                Point infinitePoint = spiegel.infiniteLine(point1, point2);
                g2d.drawLine(point1.x, point1.y, infinitePoint.x, infinitePoint.y);
            }

        }
        g2d.dispose();
    }
}
