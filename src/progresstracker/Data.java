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
package progresstracker;

import java.util.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author Olli Koskinen <olli.koskinen@metropolia.fi>
 */
public class Data {

    private List exercises;
    private Controller controller;
    

    public Data(Controller controller) {
        this.controller  = controller;
        exercises = new ArrayList<Exercise>();
    }

    public List getList() {
        return exercises;
    }

    void saveExercises(Exercise exercise) {
        this.exercises.add(exercise);

        backUpData();
        controller.updateScreen();
    }

    //TODO: Read and write data from a file.
    private void backUpData() {

        try {
            OutputStream file = new FileOutputStream("progres.data");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput out = new ObjectOutputStream(buffer);
            try {
                out.writeObject(exercises);
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error while writing data to file!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void readDataFromFile() {
        try {
            InputStream file = new FileInputStream("progres.data");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput in = new ObjectInputStream(buffer);
            try {
                //deserialize the List
                exercises = (List<Exercise>) in.readObject();
                //display its data
            } finally {
                in.close();
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found while reading from file", "Class not found", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Could not read file", "File I/O failed", JOptionPane.ERROR_MESSAGE);
        }
    }
}
