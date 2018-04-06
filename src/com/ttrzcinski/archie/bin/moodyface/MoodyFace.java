package com.ttrzcinski.archie.bin.moodyface;

import com.ttrzcinski.archie.bin.Console;

public class MoodyFace {
    /**
     * Represents known emotions/moods.
     */
    public enum Mood {
        HAPPY, SAD, ANGRY, BORED, DOUBT
    }

    /**
     * Draws a single line with part of face and given part of message.
     *
     * @param art       part of face to draw
     * @param message   part of message to print
     */
    private void drawLine(String art, String message) {
        Console.o(message != null ? (art + " " + message) : art);
    }

    /**
     * Draws a happy face.
     */
    public void drawFaceHappy() {
        this.drawFace(Mood.HAPPY);
    }

    /**
     * Draws a face based of given mood.
     * @param wanted    wanted mood
     */
    public void drawFace(Mood wanted) {
        this.drawFace(wanted, null);
    }

    /**
     * Draws a face based of given mood with given message.
     * @param wanted    wanted mood
     * @param message   message to pass
     */
    public void drawFace(Mood wanted, String message) {
        //TODO Count maximal length of line before wrapping it to next line based on width of console and width of face
        int messageLineWidth = 40;
        String[] lines = (message != null ? message.split("(?<=\\G.{"+messageLineWidth+"})") : new String[0]);
        boolean useMessage = lines.length > 0;
        //Clear screen
        Console.clearWholeScreen();
        //Drawing face based on parts
        Console.o("   XXX   ");
        Console.o("  X   X  ");
        //Eyebrows
        switch (wanted) {
            case HAPPY:
                Console.o("X // \\ X ");
                break;
            case ANGRY:
                Console.o("X \\ // X ");
                break;
            case DOUBT:
                Console.o("X -- '' X ");
                break;
            default:
                Console.o("X       X ");
        }
        int lineNum = 0;
        //Eyes
        switch (wanted) {
            case BORED:
                this.drawLine("X -- -- X", useMessage && lines.length > lineNum ? lines[lineNum] : null);
                break;
            case DOUBT:
                this.drawLine("X <> <> X", useMessage && lines.length > lineNum ? lines[lineNum] : null);
                break;
            default:
                this.drawLine("X == == X", useMessage && lines.length > lineNum ? lines[lineNum] : null);
        }
        //Nose
        lineNum++;
        this.drawLine("X       X", useMessage && lines.length > lineNum ? lines[lineNum] : null);
        //Mouth
        lineNum++;
        switch (wanted) {
            case HAPPY:
                this.drawLine("X  X X  X", useMessage && lines.length > lineNum ? lines[lineNum] : null);
                lineNum++;
                this.drawLine(" X  X  X ", useMessage && lines.length > lineNum ? lines[lineNum] : null);
                break;
            case SAD:
                this.drawLine("X   x   X", useMessage && lines.length > lineNum ? lines[lineNum] : null);
                lineNum++;
                this.drawLine(" X X X X ", useMessage && lines.length > lineNum ? lines[lineNum] : null);
                break;
            case ANGRY:
                this.drawLine("X  xX*  X", useMessage && lines.length > lineNum ? lines[lineNum] : null);
                lineNum++;
                this.drawLine(" X     X ", useMessage && lines.length > lineNum ? lines[lineNum] : null);
                break;
            default:
                this.drawLine("X  ===  X", useMessage && lines.length > lineNum ? lines[lineNum] : null);
                lineNum++;
                this.drawLine(" X     X ", useMessage && lines.length > lineNum ? lines[lineNum] : null);
        }
        //Chin
        lineNum++;
        this.drawLine("  X   X  ", useMessage && lines.length > lineNum ? lines[lineNum] : null);
        lineNum++;
        this.drawLine("   XXX   ", useMessage && lines.length > lineNum ? lines[lineNum] : null);
    }

    /**
     * Draws a face with given mood and message.
     *
     * @param mood      given mood
     * @param message   given message
     */
    public void drawFaceWithMessage(Mood mood, String message) {
        this.drawFace(mood, message);
    }
}
