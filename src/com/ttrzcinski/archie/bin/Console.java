package com.ttrzcinski.archie.bin;

import java.util.Scanner;

/**
 * Represents a handle to console - currently the only way of communicating.
 *
 * Created by theadmin on 13.10.17.
 */
public class Console {
    //Inner variables
    private static Boolean flagEcho;

    //Interface methods
    /**
     * Shows standard message, as an info.
     *
     * @param val given content
     */
    public static void o(String val) {
        System.out.println(val);
    }

    //TODO Add variation of o method to type letter after letter
    //TODO Add variation of o method with 'Archie is typing..' and then change it to message
    //TODO Add variation of o method to type letter after letter with typos and errors

    /**
     * Shows error message (or angry message).
     *
     * @param val given content
     */
    public static void e(String val) { System.err.println(val); }

    /**
     * Read a line of users input and returns it for further parsing.
     *
     * @return whatever user wrote
     */
    public static String i() {
        //Create a grip on standard system's input
        Scanner scanner = new Scanner(System.in);
        //If grip works, read first line, else null
        String line = scanner != null ? scanner.nextLine() : null;
        //Check, if echo should repeat
        assureNN_flagEcho();
        if (flagEcho.booleanValue()) {
            o(String.format("Echo: %s", line));
        }
        //Return the inputted phrase
        return line;
    }

    /**
     * (DEV) Clears the console, so more invectives can be seen at once.
     */
    public static void clearWholeScreen() {
        //TODO Fix it to some one method call
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    //Inner methods
    /**
     * Assures, that flag of echo won't be NULL.
     */
    private static void assureNN_flagEcho() {
        if (Console.flagEcho == null) {
            Console.flagEcho = Boolean.FALSE;
        }
    }

    //Accessors
    /**
     * Checks, if echo is turned on.
     *
     * @return true, if is set, false otherwise
     */
    public static Boolean wavesFlagEcho() {
        return flagEcho;
    }

    /**
     * Turn on echo mode.
     */
    public static void putUpFlagEcho() {
        Console.flagEcho = Boolean.TRUE;
    }

    /**
     * Turns off echo mode.
     */
    public static void putDownFlagEcho() {
        Console.flagEcho = Boolean.FALSE;
    }
}
