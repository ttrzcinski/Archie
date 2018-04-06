package com.ttrzcinski.archie;

import com.ttrzcinski.archie.bin.*;
import com.ttrzcinski.archie.bin.moodyFace.MoodyFace;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.ttrzcinski.archie.bin.moodyFace.MoodyFace.*;

/**
 * Represents a very sarcastic almost-AI interface.
 * <p>
 * Created by theadmin on 13.10.17.
 */
public class Archie {
    //Variables
    /**
     * Created instance to analyze entry arguments.
     */
    private static EntryArguments entryArguments;

    /**
     * Marks flag of using moody faces.
     */
    private static boolean useMoodyFaces;
    /**
     * Draws different face moods of bot.
     */
    private static MoodyFace moodyFace;

    //Inner Methods

    /**
     * Method used to output messages with moody icon representing the emotion connected with that message.
     * @param mood      pointed mood
     * @param message   given message
     */
    private static void botSpeak(Mood mood, String message) {
        if (useMoodyFaces) {
            moodyFace.drawFaceWithMessage(mood, message);
        } else {
            Console.o(message);
        }
    }

    /**
     * Call to run Archie. It welcomes parameters.
     *
     * @param args given arguments
     */
    public static void main(String[] args) {
        //Clear the bloody console
        Console.clearWholeScreen();

        //Show some proof. that it works
        Welcome.showSomeSign();
        //Check the entry arguments

        //Process the entry args
        if (EntryArguments.doesThisWork()) {
            entryArguments = new EntryArguments(args);
        } else if (args != null && args.length > 0) {
            Console.o("Uuuu.. shiny.. I see some arguments.");
        } else {
            Console.o("Hmm.. no 'arguments given'.. What a lazy user are you..");
        }

        //Should I turn off the moody faces?
        useMoodyFaces = true;
        moodyFace = new MoodyFace();
        if (entryArguments.hasArgument("no-moody-faces")) {
            useMoodyFaces = false;
        }

        botSpeak(Mood.DOUBT, "So what's your name, eh?");
        String gottenName = Console.i();
        if (gottenName == null) {
            botSpeak(Mood.ANGRY, "..if you don't wanna talk, why don't you fuck off?!");
            return;
        } else {
            botSpeak(Mood.BORED, "Well.. " + gottenName +
                    ". Parents must've really hate you, if you got name, like that.");
        }

        //Finally, let's go with the questions
        boolean flg_continueDiscussion = true;
        botSpeak(Mood.DOUBT,"Although.. you wanted something?");

//        //----------------------------
//        do {
//            //Parse, what user wrote
//            String wantedPhrase = Console.i().trim();
//            String wantedPhrase_lowerCase = wantedPhrase.toLowerCase();
//            Phrase phrase = new Phrase(wantedPhrase_lowerCase);
//
//            if (phrase.containsAny(new String[]{"stop", "end", "done", "finito",
//                            "go home", "return 0", "exit", "quit", "CTRL + Q", ":qw!", "end"},
//                    wantedPhrase_lowerCase)) {
//                Console.o("It was too intelligent for you, huh?");
//                flg_continueDiscussion = false;
//            }
//        } while (flg_continueDiscussion);
//
//        //----------------------------
//        if (1 != 2) {
//            return;
//        }
//        //----------------------------

        do {
            //TODO ADD HERE PHRASE ON FIRST QUESTIONS AFTER CHECKING FLAG AND FLAG FOR ANOTHER
            //Parse, what user wrote
            String wantedPhrase = Console.i().trim();
            String wantedPhrase_lowerCase = wantedPhrase.toLowerCase();
            Phrase phrase = new Phrase(wantedPhrase_lowerCase);
            if (phrase.startsWithAnyOf(new String[]{"what is the sense", "sense of",
                    "give me the sense"})) {
                botSpeak(Mood.BORED,"There is no sense.. Next?");
            }  else if (phrase.containsAny(new String[]{"no", "stop", "end", "done", "finito",
                    "go home", "return 0", "exit", "quit", "CTRL + Q", ":qw!", "end"},
                    wantedPhrase_lowerCase)) {
                botSpeak(Mood.HAPPY,"It was too intelligent for you, huh?");
                flg_continueDiscussion = false;
            } else if (wantedPhrase_lowerCase.startsWith("simon says ")) {
                botSpeak(Mood.SAD,wantedPhrase_lowerCase.substring(11) + "..");
                //Randomize an punch-line
                int optionNum = new Dice(3).roll();
                switch (optionNum) {
                    case 1:
                        Console.o("..What am I? Some Alexa or other Siri?");
                        break;

                    case 2:
                        Console.o("..Alexa.. add hanging rope to my shopping list.");
                        break;

                    case 3:
                        Console.o("..Does mommy let you play on her computer?");
                        break;

                    default:
                        Console.o("..Rolled " + optionNum + " on D3.");
                        break;
                }
            } else if (phrase.startsWithAnyOf(new String[]{"what is the date", "what's the date",
                    "current date", "give me current date"})) {
                Calendar calendar = new GregorianCalendar();
                String currDate = calendar.getTime().toString();
                botSpeak(Mood.SAD, String.format("It's %s today.. if you believe JVM.", currDate));
            } else if (phrase.startsWithAnyOf(new String[]{"what is current timestamp", "current timestamp",
                    "give me current current", "give me the current current"})) {
                Calendar calendar = new GregorianCalendar();
                Long currTimestamp = calendar.getTimeInMillis();
                botSpeak(Mood.BORED, String.format("It's %s today.. can you, humans, even read those?!", currTimestamp));
            } else if (wantedPhrase_lowerCase.startsWith("sudo")) {
                botSpeak(Mood.BORED,"I think, you played too much with your 'penguin', if you think, it will work with me, you Linux Nerd..");
            } else if (wantedPhrase_lowerCase.startsWith("are you alive")) {
                botSpeak(Mood.ANGRY, "..and are you dumb? Because answer is the same..");
            } else if (wantedPhrase_lowerCase.startsWith("i feel homesick")) {
                //Draw a flag then
                new AsciArt().drawFlag(24,8,'#');
            } else {
                botSpeak(Mood.DOUBT, "Didn't understand you here.. or parser's author is a lazy bastard.");
            }
        } while (flg_continueDiscussion);

        //TODO Archie must be able to run basic math counting
        //TODO Archie must be able to answer 'Are you alive?' with sarcastic response
        //TODO Archie must be able to play rock-paper-scissors and always win
        //TODO Archie must be able to tell a joke
        //TODO Archie must be able to throw an invective

        //TODO Archie must be able to create a class with all 7 sections
        //TODO Archie must be able to create an interface
        //TODO Archie must be able to create a POJO
        //TODO Archie must be able to create a EJB
        //TODO Archie must be able to create an Enum
        //TODO Archie must be able to create a factory

        //TODO Archie must be able to create a method assureNN

    }
}
