package com.ttrzcinski.archie.bin;

import static java.lang.Boolean.TRUE;

/**
 * Represents entry arguments processing unit.
 *
 * Created by theadmin on 13.10.17.
 */
public class EntryArguments {
    //Constants
    private static boolean CLASS_READY = TRUE;

    //Inner variables
    private String[] args;

    //Constructors
    public EntryArguments(String[] args) {
        //
        if (args != null) {
            Console.o("You know, that those args were not a null.. Nice.");
            this.args = args;
        } else {
            Console.o("You know, that those args were a null, right?");
        }
    }

    //Inner methods

    //Interface methods

    /**
     * Returns debug information, if instance will be able to process.
     *
     * @return true, if is, false if isn't
     */
    public static boolean doesThisWork() {
        return CLASS_READY;
    }

    /**
     * Returns information, how many arguments were given.
     *
     * @return 0, if none, count, if some were given
     */
    public int howMany() {
        return this.args != null ? this.args.length : 0;
    }

    /**
     * Clears the list of kept arguments.
     */
    public void forgetThem() {
        this.args = null;
    }

    //Accessors
}
