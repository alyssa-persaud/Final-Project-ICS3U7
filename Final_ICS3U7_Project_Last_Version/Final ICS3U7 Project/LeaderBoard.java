import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//https://www.javatpoint.com/java-jtable
/**
 *
 * @author Alyssa and Kevin Li
 *Date: January 29, 2021
 *Description:  Program that displays the leaderboard frame
 */
public class LeaderBoard extends JFrame implements ActionListener {
    private static final Color startButton = new Color(50, 82, 123);
    private static final Color backButton = new Color(207, 58, 36);
    private static final Color nextButton = new Color(4, 99, 7);
    private static final Color leaderBoardButton = new Color(212, 175, 55);
    private static Font menuButtons = new Font("Arial Bold", Font.PLAIN, 23);
    private static JPanel leaderboardPanel = new JPanel();
    private static JButton back, next;


    void leaderboard() {
        try {
           this.setContentPane(leaderboardPanel);            //show main panel
            BufferedReader reader = new BufferedReader(new FileReader("username.txt"));
            BufferedReader readerScore1 = new BufferedReader(new FileReader("winner.txt"));
            String playerscore, winnerinput = null;
            int player1wins = 0, player2wins = 0;
            String player1name = "";
            String player1 = null;

            while((player1name = reader.readLine()) != null){
                System.out.println(player1name);
                player1 = player1name;
            }

            while((playerscore =  readerScore1.readLine()) != null){
                System.out.println(playerscore);
                winnerinput = playerscore;
            }

            if (winnerinput.equalsIgnoreCase("Player 2")) {

                player2wins++;
            }
            else{
                player1wins++;
            }

            String info[][] = {{player1, Integer.toString(player1wins)},
                    {"Player 2", Integer.toString(player2wins)}};
            String columns[] = {"Name", "Wins"};
            JTable table = new JTable(info, columns);
            table.setMinimumSize(new Dimension(200,200));
            table.setBounds(30, 100, 100, 50);
            leaderboardPanel.add(table);

            back = new JButton("Back");
            back.setFont(menuButtons);
            back.setBounds(300, 550, 150, 50);
            back.setForeground(Color.white);
            back.setBackground(backButton);
            back.addActionListener(this);
            leaderboardPanel.add(back);

        } catch (IOException ex) {
            System.out.println("Error reading message");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == back) {
            this.dispose();
            MainMenu menuFrame = new MainMenu();
            menuFrame.menu();
            menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
            menuFrame.setSize(800, 600);  //window size
            menuFrame.setLocationRelativeTo(null);  //location is default
            menuFrame.setVisible(true); //window is visible
            menuFrame.setResizable(false);
        }
    }
}

