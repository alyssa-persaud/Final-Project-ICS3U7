import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class PlayerInput extends JFrame implements ActionListener{
    private static Font titleFont = new Font("Arial Bold", Font.PLAIN, 38);
    private static Font startFont = new Font("Arial Bold", Font.PLAIN, 25);
    private static Font menuButtons = new Font("Arial Bold", Font.PLAIN, 23);
    private static final Color metalicblue = new Color(50, 82, 123);
    private static final Color backButton = new Color(207, 58, 36);
    private static final Color nextButton = new Color(4,99,7);
    private JButton back, next;
    private JTextField input;

    void name(){
        FlowLayout layout = new FlowLayout();
        layout.setVgap(100);
        layout.setHgap(25);
        JPanel main1 = new JPanel(layout);
        main1.setBackground(metalicblue);
        main1.setBorder(BorderFactory.createEmptyBorder(0, 200, 0, 200));
        this.setContentPane(main1);

        JLabel title = new JLabel("Player Login");
        title.setFont(titleFont);
        title.setForeground(Color.white);
        main1.add(title);

        JLabel username = new JLabel("Username: ");
        username.setForeground(Color.white);
        username.setFont(startFont);
        main1.add(username);

        input = new JTextField(15);
        main1.add(input);

        back = new JButton("Back");
        back.setFont(menuButtons);
        back.setBackground(backButton);
        back.addActionListener(this);
        main1.add(back);

        next = new JButton("Next");
        next.setFont(menuButtons);
        next.setForeground(Color.white);
        next.setBackground(nextButton);
        next.addActionListener(this);
        main1.add(next);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        if (clicked == back){
            this.dispose();
            MainMenu menuFrame = new MainMenu();
            menuFrame.menu();
            menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
            menuFrame.setSize(800, 600);  //window size
            menuFrame.setLocationRelativeTo(null);  //location is default
            menuFrame.setVisible(true); //window is visible
            menuFrame.setResizable(false);
        }
        else if (clicked == next && !(input.getText().isEmpty())){
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("username.txt"));
                writer.write(input.getText());
                writer.close();
            }
            catch(IOException iox){
                System.out.println("Error getting information");
            }
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
