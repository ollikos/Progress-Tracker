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
import javax.swing.*;

/**
 * 
 *  Class for showing the UI
 */
public class UI extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel testiPaneeli;
    
    public UI(){
        super("Training Tracker");
        initializeComponents();
        setLocationRelativeTo(null);
    }

    //A place where we initialize all our components and do all the compulsory JFrame stuff
    private void initializeComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        tabbedPane = new JTabbedPane();
        testiPaneeli = new JPanel();
        
        
        setContentPane(tabbedPane);
        pack();
        setVisible(true);
    }

}
