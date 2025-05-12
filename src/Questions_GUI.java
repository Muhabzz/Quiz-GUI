import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Questions_GUI extends JFrame
{
    private ArrayList<ButtonGroup> buttonGroups = new ArrayList<>();
    private String studentName;
    private String studentId;

    Questions_GUI(String studentName, String studentId)
    {
        this.studentName = studentName;
        this.studentId = studentId;

        this.setTitle("Quiz Page!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(screenWidth, screenHeight);
        this.setLayout(null); // Use null layout for the JFrame itself


        ImageIcon image = new ImageIcon("quizz.jpg");
        this.setIconImage(image.getImage());

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255, 174, 0));

        JLabel WelcomeLabel = new JLabel("Welcome to Quiz Page, " + studentName + "!");
        WelcomeLabel.setBounds((screenWidth / 2) - 200, 30, 400, 20); // Centered based on screenWidth
        WelcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel.add(WelcomeLabel);

        // Questions will be added to 'panel'
        int yOffset = 80;

        // Question 1
        yOffset = addQuestion(panel, "1. Where does the coordinate system (0,0) begin in an applet?",
                new String[]{"A. Bottom-right", "B. Bottom-left", "C. Center", "D. Top-left"},yOffset);

        // Question 2
        yOffset = addQuestion(panel, "2. The method init() in applets is called: ... ",
                new String[]{"A. Every second", "B. After paint", "C. Once when the applet is first loaded", "D. Every time the applet is displayed"}, yOffset);

        // Question 3
        yOffset = addQuestion(panel, "3. What is an applet in Java?",
                new String[]{"A. A database tool", "B. A standalone application", "C. A Java compiler", "D. A program that runs inside a web browser"}, yOffset);

        // Question 4
        yOffset = addQuestion(panel, "4. What file extension does a compiled Java class have?",
                new String[]{"A. .html", "B. .class", "C. .java", "D. .exe"}, yOffset);

        // Question 5
        yOffset = addQuestion(panel, "5. Which of the following is used to draw a line in Java?",
                new String[]{"A. g.drawLineTo()", "B. g.draw()", "C. g.drawLine()", "D. g.paintLine()"}, yOffset);

        // Question 6
        yOffset = addQuestion(panel, "6. Which class does a Java applet typically extend?",
                new String[]{"A. Object", "B. JApplet", "C. Applet", "D. JFrame"}, yOffset);

        // Question 7
        yOffset = addQuestion(panel, "7. Which constant makes the JFrame close the application on exit?",
                new String[]{"A. ON_CLOSE_HIDE", "B. DISPOSE_ON_CLOSE", "C. EXIT_ON_CLOSE", "D. ON_CLOSE_EXIT"}, yOffset);

        // Question 8
        yOffset = addQuestion(panel, "8. Which method is used to redraw a component?",
                new String[]{"A. redraw()", "B. repaint()", "C. update()", "D. paint()"}, yOffset);

        // Question 9
        yOffset = addQuestion(panel, "9. Which class provides the root window for Swing applications?",
                new String[]{"A. JFrame", "B. JWindow", "C. JDialog", "D. JComponent"}, yOffset);

        // Question 10
        yOffset = addQuestion(panel, "10. Which class is used to create a menu bar in Java?",
                new String[]{"A. JMenuBar", "B. JMenuItem", "C. JMenuBarItem", "D. MenuBar"}, yOffset);

        JLabel final_label = new JLabel(" * If you finished, submit: ");
        final_label.setBounds(20, yOffset + 30, 800, 20);
        final_label.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(final_label);

        JButton final_button = new JButton(" SUBMIT ");
        final_button.setBounds(280, yOffset + 20, 150, 40); // Adjusted y based on yOffset
        final_button.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(final_button);

        final_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processAnswers();
                System.exit(0);
            }
        });

        panel.setPreferredSize(new Dimension(screenWidth - 40, yOffset + 100)); // Set preferred size for scroll pane

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, screenWidth -15, screenHeight - 40); // Adjust to fit frame
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane);
    }

    private int addQuestion(JPanel panel, String questionText, String[] choices, int yOffset)
    {
        JLabel qLabel = new JLabel(questionText);
        qLabel.setBounds(20, yOffset, 800, 20);
        qLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(qLabel);

        yOffset += 30;

        ButtonGroup group = new ButtonGroup();
        char optionChar = 'A';
        for (String choice : choices)
        {
            JRadioButton rButton = new JRadioButton(choice);
            rButton.setBounds(40, yOffset, 400, 20); // Indented and increased width
            rButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Changed to PLAIN
            rButton.setActionCommand(String.valueOf(optionChar++)); // A - B - C - D
            rButton.setBackground(panel.getBackground()); // Match panel background
            group.add(rButton);
            panel.add(rButton);
            yOffset += 30;
        }
        buttonGroups.add(group);
        return yOffset + 20; // Extra spacing before next question
    }

    private void processAnswers()
    {
        Quiz quiz = new Quiz(); // Contains the questions and correct answers
        int score = 0;
        int totalQuestions = buttonGroups.size();
        StringBuilder resultDetails = new StringBuilder();
        resultDetails.append("Student Name: ").append(studentName).append("\n");
        resultDetails.append("Student ID: ").append(studentId).append("\n\nResults:\n");

        for (int i = 0; i < totalQuestions; i++) {
            ButtonGroup group = buttonGroups.get(i);
            ButtonModel selectedButton = group.getSelection();
            String userAnswer = "";

            if (selectedButton != null) {
                userAnswer = selectedButton.getActionCommand();
            }

            QuestionStructure question = quiz.getQuestionAt(i);
            if (question == null) continue; // Should not happen if quiz is set up correctly

            boolean isCorrect = question.checkAnswer(userAnswer);
            resultDetails.append("Question ").append(i + 1).append(": Your answer - ").append(userAnswer);
            if (isCorrect) {
                score++;
                resultDetails.append(" (Correct)\n");
            } else {
                resultDetails.append(" (Incorrect). Correct answer: ").append(question.correctAnswer).append("\n");
            }
        }

        resultDetails.append("\nYour final score: ").append(score).append("/").append(totalQuestions);
        JOptionPane.showMessageDialog(this, resultDetails.toString(), "Quiz Results", JOptionPane.INFORMATION_MESSAGE);
    }
}

