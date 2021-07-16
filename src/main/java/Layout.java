
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
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
 * Klasse für das Layout und die Anzeige des Hauptfensters 
 * @author Erik Homes, Felicitas Kuhn, Theresa Stein
 */
public class Layout {

    JFrame frame = new JFrame("Spiegelsimulation"); 
    JPanel borders = new JPanel(); // Hauptpanel

    Layout() {
        frame.add(borders);

        // BorderLayout für die Unterteilung in zwei Bereiche 
        borders.setLayout(new BorderLayout()); 

        // Oberer Bereich mit CenterPanel
        CenterPanel gutesCenter = new CenterPanel();
        borders.add(gutesCenter, BorderLayout.CENTER); 

        // Unterer Bereich mit ButtonPanel 
        ButtonPanel guteButtons = new ButtonPanel(gutesCenter);
        borders.add(guteButtons, BorderLayout.SOUTH);

        // Vorbereitung und Anzeige des Hauptfensters
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setMinimumSize(new Dimension(700, 500));
        frame.setVisible(true);
    }
}
