import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionChanger extends JFrame {
    private JLabel questionLabel;
    private List<JRadioButton> answerOptions;
    private JButton[] questionNumberButtons;
    private JButton submitButton;
    private JButton showResultButton;
    private ButtonGroup answerGroup;
    private String[][] questions = {
            {"What is the capital of France?", "Paris", "London", "Berlin", "Madrid"},
            {"Who painted the Mona Lisa?", "Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo"},
            {"What is the largest planet in our solar system?", "Jupiter", "Mars", "Saturn", "Neptune"},
            {"Which of the following option leads to the portability and security of Java?",
                    "Bytecode is executed by JVM", "The applet makes the Java code secure and portable",
                    "Use of exception handling", "Dynamic binding between objects"}
    };
    private List<String> correctAnswers = Arrays.asList(
            "Paris",
            "Leonardo da Vinci",
            "Jupiter",
            "Bytecode is executed by JVM"
    );
    private List<Integer> selectedOptions;

    public QuestionChanger() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Question Changer");
        setLayout(new FlowLayout());

        // Initialize the question label
        questionLabel = new JLabel(questions[0][0]);
        add(questionLabel);

        // Initialize the answer options radio buttons
        answerOptions = new ArrayList<>();
        answerGroup = new ButtonGroup();
        JPanel optionsPanel = new JPanel(new GridLayout(0, 1));
        for (int i = 1; i < questions[0].length; i++) {
            JRadioButton radioButton = new JRadioButton();
            radioButton.setText(questions[0][i]);
            answerOptions.add(radioButton);
            optionsPanel.add(radioButton);
            answerGroup.add(radioButton);
        }
        add(optionsPanel);

        // Initialize the question number buttons
        questionNumberButtons = new JButton[questions.length];
        for (int i = 0; i < questions.length; i++) {
            final int questionIndex = i; // Store the index for the ActionListener

            questionNumberButtons[i] = new JButton("Q" + (i + 1));
            questionNumberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    questionLabel.setText(questions[questionIndex][0]);

                    // Remove existing answer options
                    optionsPanel.removeAll();
                    answerOptions.clear();
                    answerGroup.clearSelection();

                    // Add new answer options
                    for (int j = 1; j < questions[questionIndex].length; j++) {
                        JRadioButton radioButton = new JRadioButton();
                        radioButton.setText(questions[questionIndex][j]);
                        answerOptions.add(radioButton);
                        optionsPanel.add(radioButton);
                        answerGroup.add(radioButton);
                    }

                    // Disable radio buttons if the question has been visited
                

                    // Refresh the panel
                    optionsPanel.revalidate();
                    optionsPanel.repaint();
                    
                }
            });
            add(questionNumberButtons[i]);
        }

        // Initialize the submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedOption = getSelectedOptionIndex();
                if (selectedOption != -1) {
                    selectedOptions.set(getSelectedQuestionIndex(), selectedOption);
                    JOptionPane.showMessageDialog(null, "Answer submitted!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an answer!");
                }
            }
        });
        add(submitButton);

        // Initialize the show result button
        showResultButton = new JButton("Show Result");
        showResultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int correctCount = 0;
                for (int i = 0; i < questions.length; i++) {
                    if (answerOptions.get(selectedOptions.get(i)).getText().equals(correctAnswers.get(i))) {
                        correctCount++;
                    }
                }
                JOptionPane.showMessageDialog(null, "Total Correct Answers: " + correctCount);
            }
        });
        add(showResultButton);

        // Initialize the selected options list
        selectedOptions = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            selectedOptions.add(-1);
        }

        pack();
        setLocationRelativeTo(null);
    }

    private int getSelectedQuestionIndex() {
        for (int i = 0; i < questionNumberButtons.length; i++) {
            if (questionLabel.getText().equals(questions[i][0])) {
                return i;
            }
        }
        return -1;
    }

    private int getSelectedOptionIndex() {
        for (int i = 0; i < answerOptions.size(); i++) {
            if (answerOptions.get(i).isSelected()) {
                return i;
            }
        }
        return -1;
    }

  

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuestionChanger().setVisible(true);
            }
        });
    }
}
