package com.ttrzcinski.archie.bin.pets;

/**
 * Created by theadmin on 13.10.17.
 */
public class Jroot {
    //Constants

    //Variables

    //Constructors

    //Inner methods

    //Interface methods
    /**
     * Only way to send a question and get the answer.. usually not so interesting.
     *
     * @param question given question
     * @return whatever will be the outcome
     */
    public String ask(String question) {
        //Prepare the result
        String result = null;
        //Check the question
        if (question != null) {
            question = question.trim().toLowerCase();
            if (question.contains("fuck")) {
                result = "Jroot.. I am jroot.. jroot..";
            } else if (question.endsWith("?")) {
                result = "Jroot? I am Jroot?!";
            } else if (question.startsWith("what is your name")) {
                result = "I.. Am.. Jroot!";
            } else {
                result = "..jroot?";
            }
        } else {
            result = "JROOT?!";
        }
        //Return the outcome
        return result;
    }

    //Accessors
}
