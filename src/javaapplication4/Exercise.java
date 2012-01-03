/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author Olli Koskinen
 */
/**
 * 
 * Base class for all the exercises
 */
public class Exercise {

    private int sets;
    private int repetitions;
    private float weight;
    private String name; //name of the exercise, ex. Squats

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
