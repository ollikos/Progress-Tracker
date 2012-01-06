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
import java.util.List;
import javax.swing.UIManager;


//A controller class for UI and models, and a main method
public class Controller {

    private UI ui;
    private Data data;

    public static void main(String[] args) {
        //Set the look for the window
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        
        Controller controller = new Controller();
        UI ui = new UI(controller);
        Data data = new Data(controller);
        
        controller.initializeComponents(ui,data);
    }

    public void initializeComponents(UI ui, Data data) {
        this.ui = ui;
        this.data = data;
    }

    public void saveGatheredData(Exercise exercise) {
       data.saveExercises(exercise);
    }
    public List getData(){
        return data.getList();
    }

    void updateScreen() {
        ui.repaint();
    }
    
}
