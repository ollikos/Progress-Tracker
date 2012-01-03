/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progresstracker;

import javax.swing.UIManager;

/**
 *
 * @author Olli Koskinen
 */
public class Controller {

    private UI ui;

    public static void main(String[] args) {
        //Set the look for the window
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        
        Controller controller = new Controller();
        UI ui = new UI();
        controller.initializeComponents(ui);
    }

    public void initializeComponents(UI ui) {
        this.ui = ui;
    }
}
