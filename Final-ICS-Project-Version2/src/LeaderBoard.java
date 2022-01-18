import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
//https://www.javatpoint.com/java-jtable

public class LeaderBoard extends JFrame implements ActionListener {
	private static final Color titleScreen = new Color(0,153,125);
	private static final Color startButton = new Color(50, 82, 123);
	private static final Color playButton = new Color(38,97,156);
	private static final Color backButton = new Color(207, 58, 36);
	private static final Color nextButton = new Color(4,99,7);
	private static final Color leaderBoardButton = new Color(212, 175, 55);
	private static final Color mainMenuColor = new Color(1,68,33);
  private static Font menuButtons = new Font("Arial Bold", Font.PLAIN, 23);
	private static JPanel main = new JPanel();
	private static JButton back, next;


	void leaderboard(){
		this.setContentPane(main);			//show main panel


		String info[][]={ {"Kris", "4000", "1"},    
				{"Matt","2000", "2"},    
				{"Jane","150","3"}};    //test/layout info
		
		String columns[]={"Name", "Score", "Pos"};        
		JTable table =new JTable(info,columns);    
		table.setBounds(30,100,100,50);          
		JScrollPane scroll=new JScrollPane(table);  
		main.add(scroll);
		
		back = new JButton("Back");
		back.setFont(menuButtons);
		back.setBounds(300,550,150,50);
		back.setForeground(Color.white);
		back.setBackground(backButton);
		back.addActionListener(this);
		main.add(back);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		if(clicked == back) {
			this.dispose();
			MainMenu menuFrame = new MainMenu();
      menuFrame.menu();
      menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
      menuFrame.setSize(800, 600);  //window size
      menuFrame.setLocationRelativeTo(null);  //location is default
      menuFrame.setVisible(true); //window is visible
      menuFrame.setResizable(false);
		}

		else if (clicked == next) {
			 this.dispose();

		}
	}
}
