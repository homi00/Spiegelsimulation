
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
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
public class Layout implements ActionListener {

    JFrame frame = new JFrame("Auswahlmenü Spiegel");
    JPanel borders = new JPanel();

    Layout() {
        frame.add(borders);

        borders.setLayout(new BorderLayout());

       

        CenterPanel gutesCenter = new CenterPanel();
        borders.add(gutesCenter, BorderLayout.CENTER);

         ButtonPanel guteButtons = new ButtonPanel();
        borders.add(guteButtons, BorderLayout.SOUTH);

      
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(420, 420);
        frame.setVisible(true);

   }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
