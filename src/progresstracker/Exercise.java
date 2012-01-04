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

import java.util.Date;

/**
 * 
 * Base class for all the exercises
 */
public class Exercise {

    private int sets;
    private int repetitions;
    private float weight;
    private String name; //name of the exercise, ex. Squats
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null){
        this.name = name;
        }
        else{
            this.name = "Generic";
        }
    }

    public Exercise(int sets, int repetitions, int weight) {
        this.sets = sets;
        this.repetitions = repetitions;
        this.weight = weight;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        if (repetitions >= 0) 
            this.repetitions = repetitions;
        else 
            this.repetitions = 1;
        
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        if (sets >= 0)
            this.sets = sets;
        else 
            this.sets = 1;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if (weight >= 0.0f)
            this.weight = weight;
        else
            this.weight = 1.0f;
    }
    
    public float getExercisePoints(){
        if(repetitions > 0 )
            return (sets/repetitions)* weight;
        else
            return 1.0f;
    }
}
