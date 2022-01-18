import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//https://stackoverflow.com/questions/9829319/centering-a-jlabel-in-a-jpanel
//https://www.plus2net.com/java_tutorial/swing-data-transfer.php
//https://stackoverflow.com/questions/27207887/java-jbutton-opening-another-jframe-that-i-can-input-into
class Main{
  private JButton play, home, exit, leaderboard;

  //variable declaration
  private static final Color teal = new Color(0,153,125);
  private static final Color metalicblue = new Color(50, 82, 123);
  private static final Color differentblue = new Color(38,97,156);
  private static final Color red = new Color(207, 58, 36);
  private static final Color gold = new Color(212, 175, 55);
  private static final Color darkgreen = new Color(1,68,33);
  private static Font titleFont = new Font("Arial Bold", Font.PLAIN, 38);
  private static Font startFont = new Font("Arial Bold", Font.PLAIN, 25);
  private static Font menuButtons = new Font("Arial Bold", Font.PLAIN, 23);
  public static GridBagLayout gbLayout = new GridBagLayout();
  public static GridBagConstraints constraints = new GridBagConstraints();
  public static  Container cont = new Container();
  private static JFrame myFrame, menuFrame;

  public static void main(String[] args) {
    TitleScreen();
    Hand playersHand =  new Hand();
    Hand hand2 = new Hand();
    Hand hand3 = new Hand();
    Deck deck = new Deck();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter name for player 1: ");
    String name = sc.nextLine();
    System.out.println("\nShuffling cards...");
    deck.shuffle();
    System.out.println("\nDealing cards...");
    for (int i = 0; i < 8; i++){
      playersHand.addCard(deck.deal());
      hand2.addCard(deck.deal());
      hand3.addCard(deck.deal());
    }
    System.out.println("\n" + name + "'s hand");
    playersHand.print();
    System.out.println("\nPlayer 2's hand");
    hand2.print();
    System.out.println("\nPlayer 3's hand");
    hand3.print();
    System.out.println("\nRemaining cards in deck");
    deck.print();

  }

  public static void TitleScreen(){
    TitleScreen titleScreen = new TitleScreen();
    titleScreen.title();
    titleScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
    titleScreen.getContentPane().setBackground(teal);

    titleScreen.setSize(800, 600);  //window size
    titleScreen.setLocationRelativeTo(null);  //location is default
    titleScreen.setVisible(true); //window is visible

    titleScreen.setLayout(new BorderLayout());    //layout
    titleScreen.setResizable(false);  //window is resizable
  }


  public static void playing(){
    PlayerInput playingFrame = new PlayerInput();   //create JFrame
    playingFrame.name();
    playingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
    playingFrame.getContentPane().setBackground(metalicblue);
    playingFrame.setSize(800, 600);  //window size
    playingFrame.setLocationRelativeTo(null);  //location is default
    playingFrame.setVisible(true); //window is visible

    playingFrame.setResizable(false);  //window is resizable

  }

  public static void mainMenu(){
    MainMenu menuFrame = new MainMenu();
    menuFrame.menu();
    menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
    menuFrame.setSize(800, 600);  //window size
    menuFrame.setLocationRelativeTo(null);  //location is default
    menuFrame.setVisible(true); //window is visible
    menuFrame.setResizable(false);
  }
}