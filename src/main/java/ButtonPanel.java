
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
public class ButtonPanel extends JPanel {

    CenterPanel centerPanel;

    ButtonPanel(CenterPanel centerPanel) {
        this.centerPanel = centerPanel;

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

        add(planeButton);

        add(concaveButton);

        add(convexButton);
    }

}
