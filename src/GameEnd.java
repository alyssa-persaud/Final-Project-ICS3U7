import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
/**
 *
 * @author Alyssa and Kevin Li
 *Date: January 29, 2021
 *Description:  Program that displays the victory frame after the game ends
 */
public class GameEnd extends JFrame implements ActionListener {
    private static Font titleFont = new Font("Arial Bold", Font.PLAIN, 38);
    private static Font messageFont = new Font("Arial Bold", Font.PLAIN, 30);
    private static Font menuButtons = new Font("Arial Bold", Font.PLAIN, 23);
    private static final Color endingColor = new Color(9, 191, 185);
    private static final Color darkgreen = new Color(1,68,33);
    private JButton menuButton;

    void victory(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("winner.txt"));

            FlowLayout layout = new FlowLayout();
            layout.setHgap(200);
            layout.setVgap(75);
            JPanel endPanel = new JPanel(layout);
            endPanel.setBackground(endingColor);
            endPanel.setBorder(BorderFactory.createEmptyBorder(0, 400, 0, 400));
            this.setContentPane(endPanel);

            JLabel victor = new JLabel(reader.readLine() + " wins!!!");
            victor.setFont(titleFont);
            victor.setForeground(Color.white);
            victor.setHorizontalAlignment(JLabel.CENTER);
            endPanel.add(victor);

            JPanel buttons = new JPanel(layout);
            buttons.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
            buttons.setBackground(endingColor);
            menuButton = new JButton("Main Menu");
            menuButton.setFont(menuButtons);
            menuButton.setForeground(Color.white);
            menuButton.setBackground(darkgreen);
            menuButton.addActionListener(this);
            buttons.add(menuButton);
            endPanel.add(buttons);

        }
        catch(IOException ex){
            System.out.println("Error reading username");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        if (clicked == menuButton){
            this.dispose();
            MainMenu menuFrame = new MainMenu();
            menuFrame.menu();
            menuFrame.setTitle("UMO");
            menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
            menuFrame.setSize(800, 600);  //window size
            menuFrame.setLocationRelativeTo(null);  //location is default
            menuFrame.setVisible(true); //window is visible
            menuFrame.setResizable(false);
        }

    }
}

