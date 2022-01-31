import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TitleScreen extends JFrame implements ActionListener{
    private static final Color teal = new Color(0,153,125);
    private static final Color metalicblue = new Color(50, 82, 123);
    private static Font titleFont = new Font("Arial Bold", Font.PLAIN, 38);
    private static Font startFont = new Font("Arial Bold", Font.PLAIN, 25);
    private JButton start;
    void title(){
        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.setBackground(teal);  //set color
        JLabel title = new JLabel("UMO"); //game title
        title.setFont(titleFont); //set font
        title.setForeground(Color.white); //set title color
        titlePanel.add(title);    //add to panel
        start = new JButton("Start");   //start button
        start.setPreferredSize(new Dimension(100, 50)); //dimension of button
        start.setFont(startFont); //button font
        start.setBackground(metalicblue); //button color
        start.setForeground(Color.white);   //button font color
        titlePanel.add(start);  //add to panel
        titlePanel.setBorder(BorderFactory.createEmptyBorder(175,350,225,350));   //set border for panel
        this.setContentPane(titlePanel);
        start.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        if(clicked == start){
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
