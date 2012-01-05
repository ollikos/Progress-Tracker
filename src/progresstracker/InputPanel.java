/*
 * Copyright (C) 2012 Olli Koskinen <olli.koskinen@metropolia.fi>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 *
 * @author Olli Koskinen <olli.koskinen@metropolia.fi>
 */
package progresstracker;

import java.awt.Dimension;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * 
 * A class that shows you the initial input screen for all the data gathering from the user
 */
public class InputPanel extends JPanel {

    private JLabel numSets;  //The number of sets
    private JTextField numSetsField;
    private JButton add;
    private JButton calculate;
    private List setList;
    private List labelList;
    private String name;

    //TODO: The placings of the objects 
    public InputPanel(String name) {
        this.name = name;
        setList = new ArrayList<JTextField>();
        labelList = new ArrayList<JLabel>();
        setPreferredSize(new Dimension(350, 150));
        initializeComponents();
    }

    private void initializeComponents() {
        this.numSets = new JLabel("The number of sets: ");
        this.numSetsField = new JTextField(25);
        this.add = new JButton("Add");

        //Added function to the add button
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = numSetsField.getText();
                if (temp.equals("") || temp == null) {
                    JOptionPane.showMessageDialog(null, "You must input something first.", "No input", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        setAmountOfSets(Integer.parseInt(temp));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "You must input something first.", "No input", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        add(numSets);
        add(numSetsField);
        add(add);  //Yo dawg?
    }

    //A method that draws custom amount of inputfields
    private void setAmountOfSets(int sets) {

        for (int i = 1; i <= sets; i++) {
            this.setList.add(new JTextField(10));
            this.labelList.add(new JLabel(i + ". Set"));
        }

        //Add one more field + label for the MAX result 
        this.labelList.add(new JLabel("Max"));
        this.setList.add(new JTextField(10));

        //Clear the input screen for new Boxes
        removeAll();

        for (int i = 0; i < sets + 1; i++) {
            add((JLabel) labelList.get(i));
            add((JTextField) setList.get(i));
        }

        //A button for sending the results and showing the initial graph
        this.calculate = new JButton("Calculate");
        calculate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!setListEmpty()) {
                    JOptionPane.showMessageDialog(null, "You must give an input.");
                } else {
                    //TODO: Form a Exercice and send it for graphs etc
                }
            }
        });
        
        add(calculate);

        repaint();
        revalidate();
        repaint();
    }

    //A Method for checking if the JTextFields are empty
    private boolean setListEmpty() {
        JTextField temp;
        String tmp;

        for (Object o : setList) {
            temp = (JTextField) o;
            tmp = temp.getText();
            
            if (!tmp.equals(""))
                return false;
        }
        
        return true;
    }
}
