import java.util.ArrayList;


class QuestionStructure {
    String questionText;
    String[] choices;
    String correctAnswer; // Should be 'A', 'B', 'C', or 'D'

    public QuestionStructure(String questionText, String[] choices, String correctAnswer)
    {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(String userAnswer)
    {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}

// This class holds all the quiz questions and their logic
class Quiz
{
    private ArrayList<QuestionStructure> questions;

    public Quiz()
    {
        questions = new ArrayList<>();

        // Choices are presented to the user, the correct answer is the letter corresponding to the correct choice
        String[] choice1 = {"A. Bottom-right", "B. Bottom-left", "C. Center", "D. Top-left"};
        questions.add(new QuestionStructure("1. Where does the coordinate system (0,0) begin in an applet?", choice1, "D"));

        String[] choice2 = {"A. Every second", "B. After paint", "C. Once when the applet is first loaded", "D. Every time the applet is displayed"};
        questions.add(new QuestionStructure("2. The method init() in applets is called: ... ", choice2, "C"));

        String[] choice3 = {"A. A database tool", "B. A standalone application", "C. A Java compiler", "D. A program that runs inside a web browser"};
        questions.add(new QuestionStructure("3. What is an applet in Java?", choice3, "D"));

        String[] choice4 = {"A. .html", "B. .class", "C. .java", "D. .exe"};
        questions.add(new QuestionStructure("4. What file extension does a compiled Java class have?", choice4, "B"));

        String[] choice5 = {"A. g.drawLineTo()", "B. g.draw()", "C. g.drawLine()", "D. g.paintLine()"};
        questions.add(new QuestionStructure("5. Which of the following is used to draw a line in Java?", choice5, "C"));

        String[] choice6 = {"A. Object", "B. JApplet", "C. Applet", "D. JFrame"};
        questions.add(new QuestionStructure("6. Which class does a Java applet typically extend?", choice6, "B")); // JApplet is common for Swing applets, Applet for AWT

        String[] choice7 = {"A. ON_CLOSE_HIDE", "B. DISPOSE_ON_CLOSE", "C. EXIT_ON_CLOSE", "D. ON_CLOSE_EXIT"};
        questions.add(new QuestionStructure("7. Which constant makes the JFrame close the application on exit?", choice7, "C"));

        String[] choice8 = {"A. redraw()", "B. repaint()", "C. update()", "D. paint()"};
        questions.add(new QuestionStructure("8. Which method is used to redraw a component?", choice8, "B"));

        String[] choice9 = {"A. JFrame", "B. JWindow", "C. JDialog", "D. JComponent"};
        questions.add(new QuestionStructure("9. Which class provides the root window for Swing applications?", choice9, "A"));

        String[] choice10 = {"A. JMenuBar", "B. JMenuItem", "C. JMenuBarItem", "D. MenuBar"};
        questions.add(new QuestionStructure("10. Which class is used to create a menu bar in Java?", choice10, "A"));
    }

    public QuestionStructure getQuestionAt(int index) {
        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        }
        return null;
    }

}

