package com.ttrzcinski.archie.bin;

import java.text.MessageFormat;
import java.util.Random;

/**
 * Represents a single D10 used in randomization - nothing fancy.
 *
 * Created by theadmin on 13.10.17.
 */
public class Dice {
    //Constants

    //Inner variables
    private Random random;

    //Properties
    private int sides;

    //Constructors
    /**
     * Creates new D20 dice.
     */
    public Dice() {
        //Can it be simpler, than that..
        this.sides = 20;
    }

    /**
     * Creates new dice with given number of sides.. make it at least 2, please.
     *
     * @param sides number of sides
     */
    public Dice(int sides) {
        //Check, if developer can read the bloody comment
        if (sides > 1) {
            this.sides = sides;
            //Can this dice be formed even
            if (this.sides % 2 == 0) {
                Console.o(String.format("Ok, it's a D%d", sides));
            } else {
                Console.o(MessageFormat.format("Just in which universe, have you saw a dice with {0} sides.", this.sides));
            }
        } else {
            Console.o("Come on.. how hard it was?! Let's call it a coin then.");
            //Set side to 2 - meaning mae dice a coin
            this.sides = 2;
            Console.o("Maybe it will be simple enough for you, eh?");
            Console.o(new StringBuilder().append("Now.. it is a coin.. it has ").append(this.sides).append(" sides, front and reverse.. simple?").toString());
        }
    }

    //Inner methods
    /**
     * Rolls the dice once and returns the score.
     *
     * @return result of a roll.
     */
    public int roll() {
        this.assuerNN_random();
        //Roll once
        int result = random.nextInt(this.sides)+1;
        //TODO Save the roll somewhere

        //Return the roll
        return result;
    }

    /**
     * Assures, thant variable random is not null.
     */
    private void assuerNN_random() {
        //Check, if the variable is null..
        if (this.random == null) {
            //..and now create it.
            this.random = new Random(10);
        }
    }

    //Interface methods

    //Accessors

    public int getSides() {
        return this.sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }
}
