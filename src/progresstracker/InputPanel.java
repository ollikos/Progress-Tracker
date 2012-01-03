/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progresstracker;

import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author Olli Koskinen
 */
public class InputPanel extends JPanel{
    private JLabel numSets;  //The number of sets
    private JTextField numSetsField;
    private JButton add;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
