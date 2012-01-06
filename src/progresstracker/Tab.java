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

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Olli Koskinen <olli.koskinen@metropolia.fi>
 */
public class Tab extends JPanel {
    
    private InputPanel ip;
    private Graph graph;

    public Tab(String exName, Controller controller) {
        setSize(new Dimension(1280, 1050));
       ip = new InputPanel(exName, controller);
       graph = new Graph(controller);
       add(ip);
       add(graph);
    }
}
