import javax.swing.*;
import java.io.File;
import java.util.*;
public class Deck {
  private static final int BLUE = 0;
  private static final int GREEN = 1;
  private static final int RED = 2;
  private static final int YELLOW = 3;
  private static final File directory = new File("Images/Cards");
  private static final int CARD_COUNT = directory.list().length;

  private ArrayList<Card> deck;
  private String[] images = directory.list();

  public Deck(){
    deck = new ArrayList<Card>();
    int count = 0;
    for (int colour = BLUE; colour <= YELLOW; colour++){
      for (int num = 0; num <= 9; num++){
        Card c = new Card(colour, num, new ImageIcon("Images/Cards/" + images[count]));
        deck.add(c);
        count++;
      }
    }
  }

  //getter method
  public ArrayList<Card> getcards() {
    return deck;
  }

  public Card getCard(int n){
    return deck.get(n);
  }

  public int getSize(){
    return deck.size();
  }

  public Card deal() {
    return deck.remove(0);
  }


  public void shuffle() {
    Random rand = new Random();
    for (int i = 0; i < deck.size(); i++) {
      int randIndex = rand.nextInt(deck.size());
      Card c1 = deck.get(i);
      Card c2 = deck.get(randIndex);
      deck.set(i, c2);
      deck.set(randIndex, c1);
    }
  }

  public void addCard(Card c){
    deck.add(c);
  }

  public void print() {
    for (Card card: deck){
      System.out.println(card);
    }
  }
}