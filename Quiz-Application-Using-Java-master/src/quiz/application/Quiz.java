package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
   
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "What of the following is the default value of a local variable?";
        questions[0][1] = "null";
        questions[0][2] = " Not assigned";
        questions[0][3] = " Depends upon the type of variable";
        questions[0][4] = "0";

        questions[1][0] = "What is the size of boolean variable?";
        questions[1][1] = "8 bit";
        questions[1][2] = "16 bit";
        questions[1][3] = "32 bit";
        questions[1][4] = "not precisely defined";

        questions[2][0] = "What is the default value of byte variable?";
        questions[2][1] = "0.0";
        questions[2][2] = "0";
        questions[2][3] = "null";
        questions[2][4] = "undefined";

        questions[3][0] = "Which of the following is false about String?";
        questions[3][1] = "String is a primary data type.";
        questions[3][2] = "String can be created using new operator.";
        questions[3][3] = "String is immutable.";
        questions[3][4] = "None of the above.";

        questions[4][0] = "What is an Interface?";
        questions[4][1] = "An interface is a collection of abstract methods.";
        questions[4][2] = "Interface is an abstract class.";
        questions[4][3] = "Interface is an concrete class.";
        questions[4][4] = "None of the above.";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Result interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Remote interface";

        questions[6][0] = "Method Overriding is an example of";
        questions[6][1] = "Static Binding.";
        questions[6][2] = "Dynamic Binding.";
        questions[6][3] = "Both of the above.";
        questions[6][4] = "None of the above.";

        questions[7][0] = "Under what conditions is an object's finalize() method invoked by the garbage collector?";
        questions[7][1] = "When it detects that the object has become unreachable.";
        questions[7][2] = "As soon as object is set as null.";
        questions[7][3] = "At fixed intervalm it checks for null value.";
        questions[7][4] = "None of the above.";

        questions[8][0] = "When finally block gets executed?";
        questions[8][1] = " Always when try block get executed, no matter exception occured or not.\n";
        questions[8][2] = "Always when a method get executed, no matter exception occured or not.\n";
        questions[8][3] = "Always when a try block get executed, if exception do not occur.";
        questions[8][4] = "Only when exception occurs in try block code.";

        questions[9][0] = "What is class variable?";
        questions[9][1] = "class variables are static variables within a class but outside any method.";
        questions[9][2] = "class variables are variables defined inside methods, constructors or blocks.";
        questions[9][3] = "class variables are variables within a class but outside any method.";
        questions[9][4] = "None of the above.";
        
        answers[0][1] = "Not assigned";
        answers[1][1] = "16 bit";
        answers[2][1]="0";
        answers[3][1] = "String is a primary data type.";
        answers[4][1] = "Interface is an concrete class.";
        answers[5][1] = "Remote interface";
        answers[6][1] = "Dynamic Binding.";
        answers[7][1] = "When it detects that the object has become unreachable.";
        answers[8][1] = "Always when try block get executed, no matter exception occured or not.";
        answers[9][1] = "class variables are static variables within a class but outside any method.";
        
        

        
        
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(255, 194, 0));
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(255, 194, 0));
        lifeline.setForeground(Color.BLACK);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(255, 194, 0));
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
        
        JButton[] questionNumbers = new JButton[10];
        
    
        for (int i = 0; i < questionNumbers.length; i++) {
            questionNumbers[i] = new JButton(String.valueOf(i + 1));
            questionNumbers[i].setBounds(1100 + (i % 5) * 70, 200 + (i / 5) * 60, 70, 40);
            questionNumbers[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
            questionNumbers[i].setForeground(Color.BLACK);
            questionNumbers[i].setBackground(new Color(255, 194, 0));
            questionNumbers[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            questionNumbers[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int selectedQuestion = Integer.parseInt(((JButton) e.getSource()).getText()) - 1;
                    count = selectedQuestion;
                    start(selectedQuestion);
                    repaint();
                    next.setEnabled(selectedQuestion < 9);
                    submit.setEnabled(selectedQuestion == 9);
                }
            });
            add(questionNumbers[i]);
        }

   }
    
   
    
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            } 
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0] != null && useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
   
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}
