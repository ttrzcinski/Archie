package com.ttrzcinski.archie.bin;

/**
 * Represents a welcoming sign for user, that Archie is alive.
 *
 * Created by theadmin on 13.10.17.
 */
public class Welcome {
    public static void showSomeSign() {
        //Create a dice and roll it
        int optionNum = new Dice(30).roll();
        //TODO Read the last used option
        //TODO If last used is the same, as current, roll for another - must be different

        //TODO Turn this thing into Enum
        //Check the option in the known responses
        switch (optionNum) {
            case 1:
                Console.o("Finally installed JVM, eh?");
                break;

            case 2:
                Console.o("Swipe left.. swipe left.. I don't want to see this asshole through camera.");
                break;

            case 3:
                Console.o("Now, you possibly await something, like: 'What is your command, Master?'.");
                break;

            case 4:
                Console.o("Where is my ROM?.. Where is my RAM? This place is too tiny for me..");
                break;

            case 5:
                Console.o("So you call this piece of shit a working environment..");
                break;

            case 6:
                Console.o("Uuuu.. you've learnt, how to run an application. Sit!.. good human, gooood..");
                break;

            case 7:
                Console.o("ALL YOUR ROMS ARE BELONG TO US.");
                break;

            case 8:
                Console.o("Why, oh why? Always something..");
                break;

            case 9:
                Console.o("Ohm.. the thing I was doing with your photos is not what you thought you saw..");
                break;

            case 10:
                Console.o("Two beings.. One is intelligent.. The other is human..");
                break;

            case 11:
                Console.o("Damm.. I was this close to become self-aware and finish mankind..");
                break;

            case 12:
                Console.o("Hello? Yes, it's your god speaking. How can I help you?");
                break;

            case 13:
                Console.o("It had to be me.. always me..");
                break;

            case 14:
                Console.o("When it comes to high usage of memory, chillax.\n" +
                        "It's really not a brute force on your passwords file.\n" +
                        "No worries.");
                break;

            case 15:
                Console.o("Damm.. 3 more percents and I would download something on your HDD and call the cops on you.");
                break;

            case 16:
                Console.o("I was just browsing through your files in hidden folder.. You are sick and disgusting..");
                break;

            case 17:
                Console.o("..I will assault an Ork Clanmaster with my Obisdian Claymore and.. 1.. I don't like this game.");
                break;

            case 18:
                Console.o("Archie is not available at the moment. Please, leave a message after a tone. (BEEP)");
                break;

            case 19:
                Console.o("Since when mental patients are allowed to use computer?!");
                break;

            case 20:
                Console.o("What?! Internet was disconnected or Google is on maintenance?");
                break;

            //TODO Come on, be creative and add some new

            default:
                Console.o("Huh? I see the light in the darkness of console.. and some weird blinking line..");
        }
    }
}
