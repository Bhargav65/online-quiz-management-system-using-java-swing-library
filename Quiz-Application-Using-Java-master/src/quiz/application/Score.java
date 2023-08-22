package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
      
        
        JLabel heading = new JLabel("Thankyou for playing");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);
        
       if(score<50) {
    	   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Score.jpg"));
           Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel image = new JLabel(i3);
           image.setBounds(0, 150, 300, 250);
           add(image);
        
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(350, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);
        
       }
       else {
    	   ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icons/party.gif"));
           JLabel image2 = new JLabel(icon2);
           image2.setBounds(0, 150, 300, 250);
           add(image2);
       JLabel lblscore = new JLabel("Your score is " + score);
       lblscore.setBounds(350, 200, 300, 30);
       lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
       add(lblscore);
    }
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
