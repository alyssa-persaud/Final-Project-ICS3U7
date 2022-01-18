import java.util.*;
public class Hand {
  private static final int RED = 0;
  private static final int GREEN = 1;
  private static final int BLUE = 2;
  private static final int YELLOW = 3;

  private ArrayList<Card> hand;

  public Hand() {   //hmm this is a problem
    hand = new ArrayList<Card>();
  }     

  public void addCard(Card card) {
    hand.add(card);
  }

  public void playCard(Card card) {
    hand.remove(card);
  }

  public void print(){
    for (Card card: hand){
      System.out.println(card);
    }
  }
}