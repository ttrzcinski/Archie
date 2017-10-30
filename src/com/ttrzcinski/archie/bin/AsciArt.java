package com.ttrzcinski.archie.bin;

/**
 * CGenerates Ascii Art drawings.
 *
 * Created by theadmin on 15.10.17.
 */
public class AsciArt {
    /**
     * Creates new flag in the console.
     *
     * @param width width of wanted drawing
     * @param height height of wanted drawing
     * @param ch given character as a fill up character
     */
    public void drawFlag(int width, int height, char ch) {
        //Clear screen
        Console.clearWholeScreen();
        //Create a line to draw with length x
        char[] charArr = new char[width];
        for (int j = 0; j < width; j++) {
            charArr[j] = ch;
        }
        String line = String.valueOf(charArr);
        //Draw y of them
        for (int i = 0; i < height; i++) {
            if (i < height / 2) {
                Console.o(line);
            } else {
                Console.e(line);
            }
        }
    }
}
