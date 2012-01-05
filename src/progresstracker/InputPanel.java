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

    private JLabel numSetsLabel;  //The number of sets
    private JTextField numSetsField;
    private JButton add;
    private JLabel numRepLabel;  //The number of sets
    private JTextField numRepField;;
    private JButton calculate;
    private List setList;
    private List labelList;
    private String name;
    private Controller controller;
    private int numSets; //The number of sets
    private int repetitions;
    private int width;
    private int height;

    //TODO: The placings of the objects 
    public InputPanel(String name, Controller controller) {
        this.name = name;
        this.controller = controller;
        setList = new ArrayList<JTextField>();
        labelList = new ArrayList<JLabel>();
        
        width = 350;
        height = 150;
        
        setPreferredSize(new Dimension(width, height));
        initializeComponents();
    }

    private void initializeComponents() {
        setName(name);
        this.numSetsLabel = new JLabel("Number of sets:  ");
        this.numSetsField = new JTextField((int)width/16);
        this.numRepLabel = new JLabel("   Number of reps:   ");
        this.numRepField = new JTextField((int)width/16);
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
                }}});

        add(numSetsLabel);
        add(numSetsField);
        add(numRepLabel);
        add(numRepField);
        add(add,BOTTOM_ALIGNMENT);  //Yo dawg?
    }

    //A method that draws custom amount of inputfields
    private void setAmountOfSets(int sets) {
        this.numSets = sets ;
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
                if (setListHasEmpty()) {
                    JOptionPane.showMessageDialog(null, "You must fill all the fields", "Empty field(s)", JOptionPane.ERROR_MESSAGE);
                } else {
                    
                    //read the weight data from the fields and parse it
                    try {
                        List setWeights = new ArrayList<Float>();
                        for (int i = 0; i < numSets + 1; i++) {
                            JTextField temp = (JTextField)setList.get(i);
                            setWeights.add(Float.parseFloat(temp.getText()));
                        }
                        // + 1 for the MAX weight
                        controller.saveGatheredData(new Exercise(numSets + 1 ,repetitions, setWeights,name));
                        
                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Bad input types.", "Bad input", JOptionPane.ERROR_MESSAGE);
                    }
                    //TODO: Form a Exercice and send it for graphs etc
                    //TODO: First form has, on the x-axel the date, and on the y-axel both, Max weight and the sets and repetitions as  a string
                    //TODO: add a date selector from witch you can select two dates  -> Draw a graph from those
                }
            }
        });

        add(calculate);

        repaint();
        revalidate();
    }

    //A Method for checking if the JTextFields are empty
    private boolean setListHasEmpty() {
        JTextField temp;

        for (Object o : setList) {
            temp = (JTextField) o;
            if (temp.getText().equals("")) {
                return true;
            }
        }
        return false;
    }
}
