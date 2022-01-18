import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener{
  //variable declaration
  private static Font titleFont = new Font("Arial Bold", Font.PLAIN, 38);
  private static Font menuButtons = new Font("Arial Bold", Font.PLAIN, 23);
  private static final Color red = new Color(207, 58, 36);
  private static final Color gold = new Color(212, 175, 55);
  private static final Color darkgreen = new Color(1,68,33);
  private static final Color teal = new Color(0,153,125);
  private static final Color metalicblue = new Color(50, 82, 123);
  private static final Color differentblue = new Color(38,97,156);
  private JButton play, back, exit, leaderboard;

  void menu(){
    JPanel mainMenuPanel = new JPanel(new GridLayout(2, 0));
    mainMenuPanel.setBackground(darkgreen); //color
    mainMenuPanel.setBorder   (BorderFactory.createEmptyBorder(0,200,0,200)); //create empty border
    FlowLayout layout = new FlowLayout(); //set layout
    layout.setHgap(10); //gap; horizontal
    layout.setVgap(10); //gap; vertical
    JPanel buttons = new JPanel(layout);  //panel for buttons
    buttons.setBackground(darkgreen); //color
    this.setContentPane(mainMenuPanel);

    //home button
    back = new JButton("Back");
    back.setFont(menuButtons);
    back.setBackground(teal);
    back.setForeground(Color.white);
    back.setPreferredSize(new Dimension(175, 75));
    back.addActionListener(this);

    //play button
    play = new JButton("Play");
    play.setFont(menuButtons);
    play.setBackground(differentblue);
    play.setForeground(Color.white);
    play.setFont(menuButtons);
    play.setPreferredSize(new Dimension(175, 75));
    play.addActionListener(this);

    //exit button
    exit = new JButton("Exit");
    exit.setBackground(red);
    exit.setForeground(Color.white);
    exit.setFont(menuButtons);
    exit.setPreferredSize(new Dimension(175, 75));
    exit.addActionListener(this);

    //leaderboard button
    leaderboard = new JButton("Leaderboard");
    leaderboard.setBackground(gold);
    leaderboard.setForeground(Color.white);
    leaderboard.setFont(menuButtons);
    leaderboard.setPreferredSize(new Dimension(175, 75));
    leaderboard.addActionListener(this);

    //add buttons to button panel
    buttons.add(play);
    buttons.add(leaderboard);
    buttons.add(back);
    buttons.add(exit);

    JPanel unoPanel = new JPanel(new FlowLayout());
    unoPanel.setBackground(darkgreen);  //color
    JLabel title = new JLabel("Main Menu"); //game title
    title.setFont(titleFont); //set font
    title.setForeground(Color.white); //set title color
    unoPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));  //empty border created
    unoPanel.add(title);    //add title
    mainMenuPanel.add(unoPanel);  //add panel
    mainMenuPanel.add(buttons);   //add buttons
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JButton clicked = (JButton)e.getSource();
    if(clicked == exit) {
      System.exit(0);
    }
    else if (clicked == play){
      this.dispose();
      PlayerInput playingFrame = new PlayerInput();   //create JFrame
      playingFrame.setTitle("Player Login");
      playingFrame.name();
      playingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
      playingFrame.getContentPane().setBackground(metalicblue);
      playingFrame.setSize(800, 600);  //window size
      playingFrame.setLocationRelativeTo(null);  //location is default
      playingFrame.setVisible(true); //window is visible
      playingFrame.setResizable(false);  //window is resizable
    }
    else if(clicked == back){
      this.dispose();
      TitleScreen titleScreen = new TitleScreen();
      titleScreen.setTitle("UMO");
      titleScreen.title();
      titleScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
      titleScreen.getContentPane().setBackground(teal);

      titleScreen.setSize(800, 600);  //window size
      titleScreen.setLocationRelativeTo(null);  //location is default
      titleScreen.setVisible(true); //window is visible

      titleScreen.setLayout(new BorderLayout());    //layout
      titleScreen.setResizable(false);  //window is resizable
    }

    else if(clicked == leaderboard){
       this.dispose();
      LeaderBoard leaderboardFrame = new LeaderBoard();
      leaderboardFrame.setTitle("Leaderboard");
      leaderboardFrame.leaderboard();
      leaderboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
      leaderboardFrame.getContentPane().setBackground(differentblue);

      leaderboardFrame.setSize(800, 600);  //window size
      leaderboardFrame.setLocationRelativeTo(null);  //location is default
      leaderboardFrame.setVisible(true); //window is visible

      leaderboardFrame.setLayout(new BorderLayout());    //layout
      leaderboardFrame.setResizable(false);  //window is resizable
    }
  }
}