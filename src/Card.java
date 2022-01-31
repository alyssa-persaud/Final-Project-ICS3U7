import javax.swing.*;
import java.io.*;

public class Card {
  private static final int BLUE = 0;
  private static final int GREEN = 1;
  private static final int RED = 2;
  private static final int YELLOW = 3;
  private static final File directory = new File("Images/Cards");
  private static final int CARD_COUNT = directory.list().length;

  //instnace variables
  private int colour;
  private int number;
  private ImageIcon image;

  public Card(int theColour, int theNumber, ImageIcon theImage){
    colour = theColour;
    number = theNumber;
    image = theImage;
  }

  private String[] colours = {"Blue", "Green", "Red", "Yellow"};

  private int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

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
    return colourString + " " + number;
  }
}