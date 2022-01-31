import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class BeginnerMode extends JFrame implements ActionListener{
    private static final Color beginnerColor = new Color(32, 187, 222);
    private Hand playersHand, hand2;
    private Deck deck;
    private ArrayList<JButton> cardButtons;
    private JPanel beginnerPanel, handPanel, hand2Panel;
    private FlowLayout handLayout, hand2Layout;
    private Card topCard;

    void beginner(){

        playersHand =  new Hand();
        hand2 = new Hand();
        deck = new Deck();
        deck.shuffle();
        for (int i = 0; i < 8; i++){
            playersHand.addCard(deck.deal());
            hand2.addCard(deck.deal());
        }

        GridLayout beginnerLayout = new GridLayout(3, 1);
        beginnerLayout.setVgap(15);
        beginnerPanel = new JPanel(beginnerLayout);
        //beginnerPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        beginnerPanel.setBackground(beginnerColor);
        this.setContentPane(beginnerPanel);

        hand2Layout = new FlowLayout();
        hand2Layout.setHgap(10);
        hand2Panel = new JPanel(hand2Layout);
        for (int i = 0; i < hand2.getHandSize(); i++) {
            ImageIcon card2 = new ImageIcon("Images/unoback.png");
            Image cardImage2 = card2.getImage();
            Image newer2 = cardImage2.getScaledInstance(60, 90, Image.SCALE_SMOOTH);
            ImageIcon finalImage2 = new ImageIcon(newer2);

            JLabel cardButton2 = new JLabel(finalImage2);
            cardButton2.setBackground(beginnerColor);

            hand2Panel.setBackground(beginnerColor);
            hand2Panel.add(cardButton2);
        }
        beginnerPanel.add(hand2Panel);

        handLayout = new FlowLayout();
        handLayout.setHgap(10);

        topCard = deck.deal();
        ImageIcon topCardIcon = topCard.getImageIcon();
        Image topCardImage = topCardIcon.getImage();
        Image scaledTopCardImage = topCardImage.getScaledInstance(120, 180, Image.SCALE_SMOOTH);
        ImageIcon finalTopCardImage = new ImageIcon(scaledTopCardImage);

        JLabel topCardLabel = new JLabel(finalTopCardImage);
        beginnerPanel.add(topCardLabel);

        handPanel = new JPanel(new FlowLayout());
        cardButtons = new ArrayList<>();
        for (int i = 0; i < playersHand.getHandSize(); i++){
            ImageIcon card = playersHand.getCard(i).getImageIcon();
            Image cardImage = card.getImage();
            Image newer = cardImage.getScaledInstance(60,90,Image.SCALE_SMOOTH);
            ImageIcon finalImage = new ImageIcon(newer);

            JButton cardButton = new JButton(finalImage);
            cardButton.setPreferredSize(new Dimension(65, 95));
            cardButton.setBorderPainted(false);
            cardButton.setBackground(beginnerColor);
            cardButton.addActionListener(this);

            handPanel.setBackground(beginnerColor);
            handPanel.add(cardButton);
            cardButtons.add(cardButton);
        }
        beginnerPanel.add(handPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        if (!isHandPlayable(playersHand.getHand())){
            playersHand.addCard(deck.deal());
            beginnerPanel.removeAll();
            playRound();
        }

        else{
            for (int i = 0; i < cardButtons.size(); i++){
                if (clicked == cardButtons.get(i) && isPlayable(playersHand.getCard(i))){
                    deck.addCard(playersHand.getCard(i));
                    playersHand.playCard(playersHand.getCard(i));
                    cardButtons.remove(i);
                    beginnerPanel.removeAll();
                    playRound();
                }
            }
        }
    }

    private void playRound(){
        topCard = deck.getCard(deck.getSize()-1);
        playBotRound();
        GridLayout beginnerLayout = new GridLayout(3, 1);
        beginnerLayout.setVgap(20);
        beginnerPanel = new JPanel(beginnerLayout);
        //beginnerPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        beginnerPanel.setBackground(beginnerColor);
        this.setContentPane(beginnerPanel);

        hand2Layout = new FlowLayout();
        hand2Layout.setHgap(10);
        hand2Panel = new JPanel(hand2Layout);
        for (int i = 0; i < hand2.getHandSize(); i++) {
            ImageIcon card2 = new ImageIcon("Images/unoback.png");
            Image cardImage2 = card2.getImage();
            Image newer2 = cardImage2.getScaledInstance(60, 90, Image.SCALE_SMOOTH);
            ImageIcon finalImage2 = new ImageIcon(newer2);

            JLabel cardButton2 = new JLabel(finalImage2);
            cardButton2.setBackground(beginnerColor);

            hand2Panel.setBackground(beginnerColor);
            hand2Panel.add(cardButton2);
        }
        beginnerPanel.add(hand2Panel);

        handLayout = new FlowLayout();
        handLayout.setHgap(10);
        ImageIcon topCardIcon = topCard.getImageIcon();
        Image topCardImage = topCardIcon.getImage();
        Image scaledTopCardImage = topCardImage.getScaledInstance(120, 180, Image.SCALE_SMOOTH);
        ImageIcon finalTopCardImage = new ImageIcon(scaledTopCardImage);

        JLabel topCardLabel = new JLabel(finalTopCardImage);
        beginnerPanel.add(topCardLabel, BorderLayout.CENTER);

        handPanel = new JPanel(new FlowLayout());
        cardButtons = new ArrayList<>();
        for (int i = 0; i < playersHand.getHandSize(); i++){
            ImageIcon card = playersHand.getCard(i).getImageIcon();
            Image cardImage = card.getImage();
            Image newer = cardImage.getScaledInstance(60,90,Image.SCALE_SMOOTH);
            ImageIcon finalImage = new ImageIcon(newer);

            JButton cardButton = new JButton(finalImage);
            cardButton.setPreferredSize(new Dimension(65, 95));
            cardButton.setBorderPainted(false);
            cardButton.setBackground(beginnerColor);
            cardButton.addActionListener(this);

            handPanel.setBackground(beginnerColor);
            handPanel.add(cardButton);
            cardButtons.add(cardButton);
        }
        beginnerPanel.add(handPanel);

        int playerHandSize = playersHand.getHandSize();
        int player2HandSize = hand2.getHandSize();
        if (playerHandSize == 0){
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("winner.txt"));
                BufferedReader reader = new BufferedReader(new FileReader("username.txt"));
                writer.write(reader.readLine());
                writer.close();
                reader.close();
                this.dispose();

                GameEnd end = new GameEnd();
                end.victory();
                end.setTitle("UMO");
                end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
                end.setSize(800, 600);  //window size
                end.setLocationRelativeTo(null);  //location is default
                end.setVisible(true); //window is visible
                end.setResizable(false);
            }
            catch(IOException ex){
                System.out.println("error writing winner to file");
            }
        }

        else if (player2HandSize == 0){
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("winner.txt"));
                writer.write("Player 2");
                writer.close();
                this.dispose();

                GameEnd end = new GameEnd();
                end.victory();
                end.setTitle("UMO");
                end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
                end.setSize(800, 600);  //window size
                end.setLocationRelativeTo(null);  //location is default
                end.setVisible(true); //window is visible
                end.setResizable(false);
            }
            catch(IOException ex){
                System.out.println("error writing to file");
            }

        }

        revalidate();
        repaint();
    }

    public void playBotRound(){
        if (!isHandPlayable(hand2.getHand())){
            hand2.addCard(deck.deal());
        }
        else{
            for (int i = 0; i < hand2.getHandSize(); i++){
                if (isPlayable(hand2.getCard(i))){
                    hand2Panel.remove(i);
                    deck.addCard(hand2.getCard(i));
                    topCard = hand2.getCard(i);
                    hand2.playCard(hand2.getCard(i));
                    break;
                }
            }
        }
    }

    private boolean isPlayable(Card c){
        if (c.getColour() == topCard.getColour() || c.getNumber() == topCard.getNumber()){
            return true;
        }
        return false;
    }

    private boolean isHandPlayable(ArrayList<Card> hand){
        boolean playable = false;
        for (int i = 0; i < hand.size(); i++){
            if (isPlayable(hand.get(i))){
                playable = true;
            }
        }
        return playable;
    }
}
