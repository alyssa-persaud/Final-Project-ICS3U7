import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class Rules extends JFrame implements ActionListener{
    private static final Color rulesColor = new Color(14, 156, 175);
    private static final Color backButton = new Color(207, 58, 36);
    private static final Color nextButton = new Color(4,99,7);
    private static Font menuButtons = new Font("Arial Bold", Font.PLAIN, 23);
    private static Font rulesFont = new Font("Arial Bold", Font.PLAIN, 17);
    private static Font instructionFont = new Font("Arial Bold", Font.PLAIN, 40);
    private static JPanel rulesPanel;
    private static JButton back, next;

    void rulesPage(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("UNORules.txt"));

            FlowLayout layout = new FlowLayout();
            layout.setVgap(30);
            layout.setHgap(50);
            rulesPanel = new JPanel(layout);
            rulesPanel.setBackground(rulesColor);
            rulesPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
            this.setContentPane(rulesPanel);

            JLabel ruleLabel = new JLabel("Rules");
            ruleLabel.setFont(instructionFont);
            ruleLabel.setForeground(Color.white);
            rulesPanel.add(ruleLabel);

            JTextArea rules = new JTextArea(reader.readLine(), 10, 50);
            rules.setBackground(rulesColor);
            rules.setFont(rulesFont);
            rules.setLineWrap(true);
            rules.setWrapStyleWord(true);
            rules.setForeground(Color.WHITE);
            rulesPanel.add(rules);

            back = new JButton("Back");
            back.setFont(menuButtons);
            back.setBackground(backButton);
            back.addActionListener(this);
            rulesPanel.add(back);

            next = new JButton("Next");
            next.setFont(menuButtons);
            next.setForeground(Color.white);
            next.setBackground(nextButton);
            next.addActionListener(this);
            rulesPanel.add(next);
        }
        catch(IOException ex){
            System.out.println("error reading rules file");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if(clicked == next){
            this.dispose();
            DifficultySelection selectionScreen = new DifficultySelection();
            selectionScreen.difficulty();
            selectionScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
            selectionScreen.setSize(800, 600);  //window size
            selectionScreen.setLocationRelativeTo(null);  //location is default
            selectionScreen.setVisible(true); //window is visible
            selectionScreen.setResizable(false);
        }
        else if( clicked == back){
            this.dispose();
            PlayerInput playingFrame = new PlayerInput();   //create JFrame
            playingFrame.setTitle("Player Login");
            playingFrame.name();
            playingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
            playingFrame.setSize(800, 600);  //window size
            playingFrame.setLocationRelativeTo(null);  //location is default
            playingFrame.setVisible(true); //window is visible
            playingFrame.setResizable(false);  //window is resizable
        }

    }
}