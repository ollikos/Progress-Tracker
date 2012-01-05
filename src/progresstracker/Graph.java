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
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Graph extends JPanel {

    private Controller controller;
    private List tempList;
    private int factor;
    private int offset;
    private int width;
    private int height;

    public Graph(Controller controller) {
                
        width = 350;
        height = 150;
        
        setPreferredSize(new Dimension(width, height));
        tempList = new ArrayList<Exercise>();
        this.controller = controller;
        this.offset = 10;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.factor = 1;
        this.width = getWidth();
        this.height = getHeight();
        tempList = controller.getData();

        //Drawing the X-axel
        g.drawLine(0, height - offset, width, height - offset);

        //Drawing the Y-axel 
        g.drawLine(0 + offset, height, 0+ offset, 0);

        if (tempList != null) {
            for (Object o : tempList) {
                Exercise ex = (Exercise) o;


            }

        }
    }
}
