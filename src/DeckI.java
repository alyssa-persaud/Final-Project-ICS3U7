import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.*;
/**
 *
 * @author Alyssa and Kevin Li
 *Date: January 29, 2021
 *Description:  Program that creates the deck of cards
 */

public class DeckI {
    private static final int BLUE = 0;
    private static final int GREEN = 1;
    private static final int RED = 2;
    private static final int YELLOW = 3;
    private static final int PLUS2 = 10;
    private static final int CANCEL = 11;
    private static final File directory = new File("IntermediateImages/Cards");
    private static final int CARD_COUNT = directory.list().length;


    private ArrayList<CardI> deck;
    private ArrayList<CardI> deck2;
    private String[] images = directory.list();

    public DeckI() {
        deck = new ArrayList<CardI>();
        int count = 0;
        for (int colour = BLUE; colour <= YELLOW; colour++){
            for (int num = 0; num <= 11; num++){
                CardI c = new CardI(colour, num, new ImageIcon("IntermediateImages/Cards/" + images[count]));
                deck.add(c);
                count++;
            }
        }
    }



    //getter method
    public ArrayList<CardI> getcards() {
        return deck;
    }


    public CardI getCard(int n){
        return deck.get(n);
    }

    public int getSize(){
        return deck.size();
    }

    public CardI deal() {
        return deck.remove(0);
    }


    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < deck.size(); i++) {
            int randIndex = rand.nextInt(deck.size());
            CardI c1 = deck.get(i);
            CardI c2 = deck.get(randIndex);
            deck.set(i, c2);
            deck.set(randIndex, c1);
        }
    }

    public void addCard(CardI c){
        deck.add(c);
    }

    public void print() {
        for (CardI card: deck){
            System.out.println(card);
        }
    }
}