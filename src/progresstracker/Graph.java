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

import java.awt.BasicStroke;
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
        buffer = (Graphics2D) img.createGraphics();

        tempList = new ArrayList<Exercise>();
        this.controller = controller;
        this.offset = 20;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        if (controller.hasData()) {
            buffer.setStroke(new BasicStroke(1));
            this.factor = 1;
            this.width = img.getWidth();
            this.height = img.getHeight();
            tempList = controller.getData();

            buffer.setColor(Color.gray);
            buffer.fillRect(0, 0, width, height);

            //Drawing the X-axel
            buffer.setColor(Color.black);
            buffer.drawLine(0, height - offset, width, height - offset);
            //Drawing the Y-axel 
            buffer.drawLine(0 + offset, height, 0 + offset, 0);


            
            //TODO: Data toimitetaan Mappian jossa avain & arvo parina toimii ArrayList<Exercise> ja tabin nimi  jolloin jokaiselle tabille saadaan omat tiedostonsa
            
            if (tempList != null) {
                for (Object o : tempList) {
                    Exercise ex = (Exercise) o;
                    Date d = ex.getDate();

                    int setRep = ex.getSetRep();
                    int multiplier = offset * factor;
                    int maxWeight = (int) ex.getMaxWeight();
                    String setReps = ex.getSetReps();


                    //Drawing the dates under X- axel
               /* buffer.setColor(Color.black);
                    buffer.setStroke(new BasicStroke(2));
                    buffer.drawString(sdf.format(d), multiplier, height - offset);
                     */

                    //Drawing the Repetitions per set dots
                    buffer.setStroke(new BasicStroke(1));
                    buffer.setColor(new Color(255, 131, 0));
                    buffer.fillOval(multiplier, height - setRep, 6, 6);
                    buffer.setColor(Color.black);
                    buffer.drawOval(multiplier, height - setRep, 6, 6);
                    //And text for it 
                    buffer.drawString(setReps, width - 25, height - setRep);


                    //Drawing the connected line && a dot for it too
                    //We dont want to draw from the origo to the first datapoint
                    if (oldX > 0 && oldY > 0) {
                        buffer.setStroke(new BasicStroke(2));
                        buffer.setColor(Color.BLUE);
                        buffer.drawLine(oldX, oldY, multiplier, height - maxWeight);

                    }

                    //Drawing dots for the connected line so the results are more clear
                    buffer.setColor(Color.BLUE);
                    buffer.setStroke(new BasicStroke(1));
                    buffer.fillOval((multiplier) - 3, (height - maxWeight) - 3, 6, 6);
                    buffer.setColor(Color.black);
                    buffer.drawOval((multiplier) - 3, (height - maxWeight) - 3, 6, 6);

                    //Storing the the coords for the next data set
                    this.oldX = multiplier;
                    this.oldY = height - maxWeight;
                    factor += 1;
                }
                this.oldX = 0;
                this.oldY = 0;
            }

            g2.drawImage(img, 0, 0, null);
        }
    }
}
