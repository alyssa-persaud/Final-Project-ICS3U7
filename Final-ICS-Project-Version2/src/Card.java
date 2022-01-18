public class Card {
  private static final int RED = 0;
  private static final int GREEN = 1;
  private static final int BLUE = 2;
  private static final int YELLOW = 3;
  //instnace variables
  private int colour;
  private int number;

  public Card (int theColour, int theNumber){
    colour = theColour;
    number = theNumber;
  }

  private String[] colours = {"Red", "Green", "Blue", "Yellow"};

  private int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

  //getter methods
  public int getColour() {
    return colour;
  }

  public int getNumber() {  
    return number;
  }

  public String colourToString(int num) {
    return colours[num];
  }

  public String toString() {
    String colourString = colours[colour];
    return colourString + " " + number;
  }
}