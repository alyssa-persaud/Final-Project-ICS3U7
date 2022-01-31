import java.util.*;
/**
 *
 * @author Alyssa and Kevin Li
 *Date: January 29, 2021
 *Description:  Program that creates the hand of each player
 */
public class HandI {
    private static final int BLUE = 0;
    private static final int GREEN = 1;
    private static final int RED = 2;
    private static final int YELLOW = 3;
    private static final int PLUS2 = 10;
    private static final int CANCEL = 11;

    private ArrayList<CardI> handInter;

    public HandI() {   //hmm this is a problem
        handInter = new ArrayList<CardI>();
    }

    public ArrayList<CardI> getHandInter(){
        return handInter;
    }

    public CardI getCard(int num){
        return handInter.get(num);
    }

    public int getHandSize(){
        return handInter.size();
    }

    public void addCard(CardI card) {
        handInter.add(card);
    }

    public void playCard(CardI card) {
        handInter.remove(card);
    }

    public void print(){
        for (CardI card: handInter){
            System.out.println(card);
        }
    }
}