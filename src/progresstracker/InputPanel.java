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

import java.awt.Graphics;
import javax.swing.*;

public class InputPanel extends JPanel{
    private JLabel numSets;  //The number of sets
    private JTextField numSetsField;
    private JButton add;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
