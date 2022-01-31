import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author Alyssa and Kevin Li
 *Date: January 29, 2021
 *Description:  Program that creates the cards in the deck
 */
public class CardI {
    private static final int BLUE = 0;
    private static final int GREEN = 1;
    private static final int RED = 2;
    private static final int YELLOW = 3;
    private static final int PLUS2 = 10;
    private static final int CANCEL = 11;
    private static final File directory = new File("IntermediateImages/Cards");
    private static final int CARD_COUNT = directory.list().length;

    //instnace variables
    private int colour;
    private int number;
    private ImageIcon image;

    public CardI(int theColour, int theNumber, ImageIcon theImage) {
        colour = theColour;
        number = theNumber;
        image = theImage;
    }

    private String[] colours = {"Blue", "Green", "Red", "Yellow"};

    private String[] specials = {"Plus2", "Skip"};

    private String[] special = {"Plus2", "Skip"};

    private int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    private String[] images = directory.list();

    //getter methods
    public int getColour() {
        return colour;
    }


    public int getNumber() {
        return number;
    }

    public ImageIcon getImageIcon(){
        return image;
    }


    public String colourToString(int num) {
        return colours[num];
    }


    public String toString() {
        String colourString = colours[colour];
        if (number >= 10){
            return colourString + " " + specials[number-10];
        }
        return colourString + " " + number;
    }
}

