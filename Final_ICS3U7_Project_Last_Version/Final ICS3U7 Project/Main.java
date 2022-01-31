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
  //variable declaration
  private static final Color teal = new Color(0,153,125);

  public static void main(String[] args) {
    TitleScreen();
  }

  public static void TitleScreen(){
    TitleScreen titleScreen = new TitleScreen();
    titleScreen.title();
    titleScreen.setTitle("UMO");
    titleScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit JFrame on close
    titleScreen.getContentPane().setBackground(teal);

    titleScreen.setSize(800, 600);  //window size
    titleScreen.setLocationRelativeTo(null);  //location is default
    titleScreen.setVisible(true); //window is visible

    titleScreen.setLayout(new BorderLayout());    //layout
    titleScreen.setResizable(false);  //window is resizable
  }
}