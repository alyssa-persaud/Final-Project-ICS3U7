import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class DifficultySelection extends JFrame implements ActionListener{
  
    private static Font titleFont = new Font("Arial Bold", Font.PLAIN, 38);
    private static Font messageFont = new Font("Arial Bold", Font.PLAIN, 30);
    private static Font menuButtons = new Font("Arial Bold", Font.PLAIN, 23);
    private static final Color metalicblue = new Color(50, 82, 123);
    private static final Color backButton = new Color(207, 58, 36);
    private static final Color intermediateButton = new Color(4,99,7);
    private static final Color beginnerButton = new Color(32, 176, 37);
    private static final Color difficultySelection = new Color(24, 152, 168);
    private JButton beginner, intermediate, back;

    void difficulty(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("username.txt"));

            FlowLayout layout = new FlowLayout();
            layout.setHgap(100);
            layout.setVgap(65);
            JPanel selection = new JPanel(layout);
            selection.setBackground(difficultySelection);
            this.setContentPane(selection);

            JLabel welcome = new JLabel("Welcome " + reader.readLine());
            welcome.setFont(titleFont);
            welcome.setForeground(Color.white);
            welcome.setHorizontalAlignment(JLabel.CENTER);

            JLabel select = new JLabel("Please select your preferred difficulty");
            select.setFont(messageFont);
            select.setForeground(Color.white);
            select.setHorizontalAlignment(JLabel.CENTER);

            JPanel message = new JPanel(new GridLayout(2, 1));
            message.add(welcome);
            message.add(select);
            message.setBackground(difficultySelection);
            selection.add(message);

            beginner  = new JButton("Beginner");
            beginner.setPreferredSize(new Dimension(250, 150));
            beginner.setFont(menuButtons);
            beginner.setForeground(Color.white);
            beginner.setBackground(beginnerButton);
            beginner.addActionListener(this);
            selection.add(beginner);

            intermediate = new JButton("Intermediate");
            intermediate.setPreferredSize(new Dimension(250, 150));
            intermediate.setFont(menuButtons);
            intermediate.setForeground(Color.white);
            intermediate.setBackground(intermediateButton);
            intermediate.addActionListener(this);
            selection.add(intermediate);

            back = new JButton("Back");
            back.setPreferredSize(new Dimension(100, 50));
            back.setBackground(backButton);
            back.setFont(menuButtons);
            back.addActionListener(this);
            selection.add(back);

            reader.close();
        }
        catch(IOException ex){
            System.out.println("Error reading username");
        }

    }
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        if (clicked == intermediate){
            this.dispose();
            IntermediateMode intermediateScreen = new IntermediateMode();
          intermediateScreen.intermediate();
          intermediateScreen.setTitle("UMO");
          intermediateScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          intermediateScreen.setSize(1000, 800);
          intermediateScreen.setLocationRelativeTo(null);
          intermediateScreen.setVisible(true);
          intermediateScreen.setResizable(false);
        }
        else if(clicked == beginner){
          this.dispose();
          BeginnerMode beginnerScreen = new BeginnerMode();
          beginnerScreen.beginner();
          beginnerScreen.setTitle("UMO");
          beginnerScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          beginnerScreen.setSize(1000, 800);
          beginnerScreen.setLocationRelativeTo(null);
          beginnerScreen.setVisible(true);
          beginnerScreen.setResizable(false);
        }
        else if(clicked == back){
            this.dispose();
            Rules rulesFrame = new Rules();
            rulesFrame.rulesPage();
            rulesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
            rulesFrame.setSize(800, 600);  //window size
            rulesFrame.setLocationRelativeTo(null);  //location is default
            rulesFrame.setVisible(true); //window is visible
            rulesFrame.setResizable(false);
        }
    }
}
