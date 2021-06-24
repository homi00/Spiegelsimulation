
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

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
    private Ball Anfangspunkt = null; //Null=Variable Ball, aber noch keinen Ball dafür erzeugt -> damit erst ein Ball beim Klicken gezeichnet wird 
    private boolean ersterKlick = true;

    CenterPanel() {

        setBackground(Color.black);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (ersterKlick == true) {
                    Anfangspunkt = new Ball(e.getX(), e.getY());

                    ersterKlick = false;

                    CenterPanel.this.repaint();
                    
                 
                }
                else {
                    
                }
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

        if (Anfangspunkt != null) {     // ungleich Null = es gibt einen Ball 
            Anfangspunkt.paint(g2d);
        }

        g2d.dispose();

    }
}
