import java.util.*;
public class Hand {
  private static final int BLUE = 0;
  private static final int GREEN = 1;
  private static final int RED = 2;
  private static final int YELLOW = 3;

  private ArrayList<Card> hand;

  public Hand() {   
    hand = new ArrayList<Card>();
  }

  public ArrayList<Card> getHand(){
    return hand;
  }

  public Card getCard(int num){
    return hand.get(num);
  }

  public int getHandSize(){
    return hand.size();
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