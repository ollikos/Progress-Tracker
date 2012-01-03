/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import javax.swing.*;

/**
 *
 * @author Olli Koskinen
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
