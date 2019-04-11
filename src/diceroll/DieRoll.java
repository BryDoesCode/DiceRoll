package diceroll;

import java.util.Random;

public class DieRoll {
    private int sides;
    private int value;

    public DieRoll() {
        
    }
    /**
     * Takes sides of die and an initial value.
     * @param sides
     * @param value 
     */
    public DieRoll(int sides, int value) {
        this.sides = sides;
        this.value = value;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public void roll() {
       Random rand = new Random();
       this.value = rand.nextInt(sides)+1;
    }

    public int getValue() {
        return value;
    }  
    
}