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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JPanel;

public class Graph extends JPanel {

    private Controller controller;
    private List tempList;
    private int factor;
    private int offset;
    private int width;
    private int height;
    private SimpleDateFormat sdf;
    private int oldX;
    private int oldY;
    private BufferedImage img;
    private Graphics2D buffer;

    public Graph(Controller controller) {

        width = 640;
        height = 350;
        oldX = 0;
        oldY = 0;
        sdf = new SimpleDateFormat("dd.MM");

        setPreferredSize(new Dimension(width, height));
        setSize(new Dimension(width, height));
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        buffer = (Graphics2D)img.createGraphics();


        
        
        tempList = new ArrayList<Exercise>();
        this.controller = controller;
        this.offset = 10;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        this.factor = 1;
        this.width = img.getWidth();
        this.height = img.getHeight();
        //TODO: FIX MEEEEEeee
        try {
            tempList = controller.getData();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }


        buffer.setColor(Color.gray);
        buffer.fillRect(0, 0, width, height);
        
        buffer.setColor(Color.black);
        //Drawing the X-axel
        buffer.drawLine(0, height - offset * 2, width, height - offset * 2);
        //Drawing the Y-axel 
        buffer.drawLine(0 + offset * 2, height, 0 + offset * 2, 0);

        
        if (tempList != null) {
            buffer.setColor(Color.BLUE);
            for (Object o : tempList) {
                Exercise ex = (Exercise) o;
                Date d = ex.getDate();

                //Drawing the dates under X- axel
                buffer.drawString(sdf.format(d), (offset * 2) * factor, super.getHeight() - 5);

                //Drawing the dots
                /*
                g.fillOval((offset*2) * factor, height - (int)ex.getMaxWeight(), 6,6);
                
                 */

                //Drawing the connected line
                //We dont want to draw from the origo to the first datapoint
                if (oldX > 0 && oldY > 0) {
                    buffer.drawLine(oldX, oldY, (offset * 2) * factor, height - (int) ex.getMaxWeight());
                }

                //Storing the the coords for the next data set
                this.oldX = (offset * 2) * factor;
                this.oldY = height - (int) ex.getMaxWeight();
                factor += 1;
            }
            this.oldX = 0;
            this.oldY = 0;
        }

        g.drawImage(img, 0, 0, null);
    }
}
