package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton start, back;
    
    Rules(){
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Instructions :");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. This Quiz Contains 10 Questions" + "<br><br>" +
                "2. Each Question Consists of 4 Options , Select one option among 4 ." + "<br><br>" +
                "3. Each Question carries 1 Mark." + "<br><br>" +
                "4. For each question 50-50 is there , and can be used only once." + "<br><br>" +
                "5. Question Palette is present in the right upper corner to navigate to other questions." + "<br><br>" +
                "6. After attempting all questions , You can submit" + "<br><br>" +
                "7. After Submiting , Score will be displayed." + "<br><br>" +
                "8. Click on Try Again , To attempt Quiz again." + "<br><br>" +
            "<html>"
        );
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        start = new JButton("Continue");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } 
    }
    
    public static void main(String[] args) {
        new Rules();
    }
}
