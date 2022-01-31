import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Alyssa and Kevin Li
 *Date: January 29, 2021
 *Description:  Program that displays the intermediate mode of the UNO game
 */
public class IntermediateMode extends JFrame implements ActionListener {
  private static final Color intermediateColor = new Color(7, 111, 137);
    private HandI playersHand, hand2;
    private DeckI deck;
    private ArrayList<JButton> cardButtons;
    private JPanel intermediatePanel, handPanel, hand2Panel;
    private FlowLayout handLayout, hand2Layout;
    private CardI topCard;

  void intermediate(){
      playersHand =  new HandI();
      hand2 = new HandI();
      deck = new DeckI();
      deck.shuffle();
      for (int i = 0; i < 8; i++){
          playersHand.addCard(deck.deal());
          hand2.addCard(deck.deal());
      }

      GridLayout beginnerLayout = new GridLayout(3, 1);
      beginnerLayout.setVgap(15);
      intermediatePanel = new JPanel(beginnerLayout);
      //beginnerPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
      intermediatePanel.setBackground(intermediateColor);
      this.setContentPane(intermediatePanel);

      hand2Layout = new FlowLayout();
      hand2Layout.setHgap(10);
      hand2Panel = new JPanel(hand2Layout);
      for (int i = 0; i < hand2.getHandSize(); i++) {
          ImageIcon card2 = new ImageIcon("Images/unoback.png");
          Image cardImage2 = card2.getImage();
          Image newer2 = cardImage2.getScaledInstance(60, 90, Image.SCALE_SMOOTH);
          ImageIcon finalImage2 = new ImageIcon(newer2);

          JLabel cardButton2 = new JLabel(finalImage2);
          cardButton2.setBackground(intermediateColor);

          hand2Panel.setBackground(intermediateColor);
          hand2Panel.add(cardButton2);
      }
      intermediatePanel.add(hand2Panel);

      handLayout = new FlowLayout();
      handLayout.setHgap(10);

      topCard = deck.deal();
      ImageIcon topCardIcon = topCard.getImageIcon();
      Image topCardImage = topCardIcon.getImage();
      Image scaledTopCardImage = topCardImage.getScaledInstance(120, 180, Image.SCALE_SMOOTH);
      ImageIcon finalTopCardImage = new ImageIcon(scaledTopCardImage);

      JLabel topCardLabel = new JLabel(finalTopCardImage);
      intermediatePanel.add(topCardLabel);

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
          cardButton.setBackground(intermediateColor);
          cardButton.addActionListener(this);

          handPanel.setBackground(intermediateColor);
          handPanel.add(cardButton);
          cardButtons.add(cardButton);
      }
      intermediatePanel.add(handPanel);
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        if (!isHandPlayable(playersHand.getHandInter())){
            playersHand.addCard(deck.deal());
            intermediatePanel.removeAll();
            playRound();
        }



        if (playersHand.getHandSize() == 1){
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

        else if (hand2.getHandSize() == 1){
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

        else{
            for (int i = 0; i < cardButtons.size(); i++){
                if (clicked == cardButtons.get(i) && isPlayable(playersHand.getCard(i))){
                    if (playersHand.getCard(i).getNumber() == 10){
                        hand2.addCard(deck.deal());
                        hand2.addCard(deck.deal());
                        deck.addCard(playersHand.getCard(i));
                        playersHand.playCard(playersHand.getCard(i));
                        cardButtons.remove(i);
                        intermediatePanel.removeAll();
                        playRound();
                    }
                    else if (playersHand.getCard(i).getNumber() == 11){
                        deck.addCard(playersHand.getCard(i));
                        playersHand.playCard(playersHand.getCard(i));
                        cardButtons.remove(i);
                        intermediatePanel.removeAll();
                        skipBotRound();
                    }
                    else{
                        deck.addCard(playersHand.getCard(i));
                        playersHand.playCard(playersHand.getCard(i));
                        cardButtons.remove(i);
                        intermediatePanel.removeAll();
                        playRound();
                    }
                }
            }
        }
    }

    private void playRound(){
        topCard = deck.getCard(deck.getSize()-1);
        playBotRound();
        GridLayout beginnerLayout = new GridLayout(3, 1);
        beginnerLayout.setVgap(20);
        intermediatePanel = new JPanel(beginnerLayout);
        //beginnerPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        intermediatePanel.setBackground(intermediateColor);
        this.setContentPane(intermediatePanel);

        hand2Layout = new FlowLayout();
        hand2Layout.setHgap(10);
        hand2Panel = new JPanel(hand2Layout);
        for (int i = 0; i < hand2.getHandSize(); i++) {
            ImageIcon card2 = new ImageIcon("Images/unoback.png");
            Image cardImage2 = card2.getImage();
            Image newer2 = cardImage2.getScaledInstance(60, 90, Image.SCALE_SMOOTH);
            ImageIcon finalImage2 = new ImageIcon(newer2);

            JLabel cardButton2 = new JLabel(finalImage2);
            cardButton2.setBackground(intermediateColor);

            hand2Panel.setBackground(intermediateColor);
            hand2Panel.add(cardButton2);
        }
        intermediatePanel.add(hand2Panel);

        handLayout = new FlowLayout();
        handLayout.setHgap(10);
        ImageIcon topCardIcon = topCard.getImageIcon();
        Image topCardImage = topCardIcon.getImage();
        Image scaledTopCardImage = topCardImage.getScaledInstance(120, 180, Image.SCALE_SMOOTH);
        ImageIcon finalTopCardImage = new ImageIcon(scaledTopCardImage);

        JLabel topCardLabel = new JLabel(finalTopCardImage);
        intermediatePanel.add(topCardLabel, BorderLayout.CENTER);

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
            cardButton.setBackground(intermediateColor);
            cardButton.addActionListener(this);

            handPanel.setBackground(intermediateColor);
            handPanel.add(cardButton);
            cardButtons.add(cardButton);
        }
        intermediatePanel.add(handPanel);

        revalidate();
        repaint();
    }

    private void skipBotRound(){
        topCard = deck.getCard(deck.getSize()-1);
        GridLayout beginnerLayout = new GridLayout(3, 1);
        beginnerLayout.setVgap(20);
        intermediatePanel = new JPanel(beginnerLayout);
        //beginnerPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        intermediatePanel.setBackground(intermediateColor);
        this.setContentPane(intermediatePanel);

        hand2Layout = new FlowLayout();
        hand2Layout.setHgap(10);
        hand2Panel = new JPanel(hand2Layout);
        for (int i = 0; i < hand2.getHandSize(); i++) {
            ImageIcon card2 = new ImageIcon("Images/unoback.png");
            Image cardImage2 = card2.getImage();
            Image newer2 = cardImage2.getScaledInstance(60, 90, Image.SCALE_SMOOTH);
            ImageIcon finalImage2 = new ImageIcon(newer2);

            JLabel cardButton2 = new JLabel(finalImage2);
            cardButton2.setBackground(intermediateColor);

            hand2Panel.setBackground(intermediateColor);
            hand2Panel.add(cardButton2);
        }
        intermediatePanel.add(hand2Panel);

        handLayout = new FlowLayout();
        handLayout.setHgap(10);
        ImageIcon topCardIcon = topCard.getImageIcon();
        Image topCardImage = topCardIcon.getImage();
        Image scaledTopCardImage = topCardImage.getScaledInstance(120, 180, Image.SCALE_SMOOTH);
        ImageIcon finalTopCardImage = new ImageIcon(scaledTopCardImage);

        JLabel topCardLabel = new JLabel(finalTopCardImage);
        intermediatePanel.add(topCardLabel, BorderLayout.CENTER);

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
            cardButton.setBackground(intermediateColor);
            cardButton.addActionListener(this);

            handPanel.setBackground(intermediateColor);
            handPanel.add(cardButton);
            cardButtons.add(cardButton);
        }
        intermediatePanel.add(handPanel);

        revalidate();
        repaint();
    }

    public void playBotRound(){
        if (!isHandPlayable(hand2.getHandInter())){
            hand2.addCard(deck.deal());
        }
        else{
            for (int i = 0; i < hand2.getHandSize(); i++){
                if (isPlayable(hand2.getCard(i))){
                    if (hand2.getCard(i).getNumber() == 10){
                        playersHand.addCard(deck.deal());
                        playersHand.addCard(deck.deal());
                        deck.addCard(hand2.getCard(i));
                        hand2.playCard(hand2.getCard(i));
                        playRound();
                        break;
                    }
                    else if (hand2.getCard(i).getNumber() == 11){
                        hand2Panel.remove(i);
                        deck.addCard(hand2.getCard(i));
                        topCard = hand2.getCard(i);
                        hand2.playCard(hand2.getCard(i));
                        break;
                    }
                    else{
                        hand2Panel.remove(i);
                        deck.addCard(hand2.getCard(i));
                        topCard = hand2.getCard(i);
                        hand2.playCard(hand2.getCard(i));
                        break;
                    }
                }
            }
        }
    }

    private boolean isPlayable(CardI c){
        if (c.getColour() == topCard.getColour() || c.getNumber() == topCard.getNumber()){
            return true;
        }
        return false;
    }

    private boolean isHandPlayable(ArrayList<CardI> hand){
        boolean playable = false;
        for (int i = 0; i < hand.size(); i++){
            if (isPlayable(hand.get(i))){
                playable = true;
            }
        }
        return playable;
    }
}
