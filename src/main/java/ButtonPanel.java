
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

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
 * Klasse für die Auswahl der Spiegelart
 * @author Erik Homes, Felicitas Kuhn, Theresa Stein
 */
public class ButtonPanel extends JPanel {

    CenterPanel centerPanel; // Für den Zugriff auf das CenterPanel

    ButtonPanel(CenterPanel centerPanel) {
        this.centerPanel = centerPanel;

        // Wenn entsprechender Button gedrückt wurde, soll im CenterPanel auf 
        // den entsprechendne Spiegel umgeschaltet werden
        JButton planeButton = new JButton("Planer Spiegel");
        planeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                centerPanel.setPlanerspiegel();
            }
        });

        JButton concaveButton = new JButton("Konkaver Spiegel");
        concaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                centerPanel.setKonkaverSpiegel();
            }
        });

        JButton convexButton = new JButton("Konvexer Spiegel");
        convexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                centerPanel.setKonvexerSpiegel();
            }
        });

        // Hinzufügen der Buttons für die Auswahl der Spiegelart
        add(planeButton);

        add(concaveButton);

        add(convexButton);
    }

}
