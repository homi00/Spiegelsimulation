
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Layout {

    JFrame frame = new JFrame("Spiegelsimulation");
    JPanel borders = new JPanel();

    Layout() {
        frame.add(borders);

        borders.setLayout(new BorderLayout());

        CenterPanel gutesCenter = new CenterPanel();
        borders.add(gutesCenter, BorderLayout.CENTER);

        ButtonPanel guteButtons = new ButtonPanel(gutesCenter);
        borders.add(guteButtons, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setMinimumSize(new Dimension(700, 500));
        frame.setVisible(true);
    }
}
