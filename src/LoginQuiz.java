import javax.swing.*;
import java.awt.*;

public class LoginQuiz
{
    JFrame frame = new JFrame();
    Questions_GUI questions_gui;
    JTextField studentNameField;
    JTextField studentIDField;

    LoginQuiz() {
        frame.setTitle("Quiz - Login Page");
        frame.setSize(1200, 800);
        frame.setLocation(200, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBounds(0, 0, 600, 800);
        leftPanel.setLayout(null);

        // Assuming image files are in the same directory as the compiled classes or provide full path
        // User needs to provide this image: 5198971.png
        ImageIcon frameIcon = new ImageIcon("5198971.png");
        frame.setIconImage(frameIcon.getImage());

        // User needs to provide this image: th.jpg
        ImageIcon quizTimeIcon = new ImageIcon("th.jpg");
        Image quizTimeImg = quizTimeIcon.getImage();
        Image scaledQuizTimeImg = quizTimeImg.getScaledInstance(500, 350, Image.SCALE_SMOOTH); // Adjusted size
        ImageIcon scaledQuizTimeIcon = new ImageIcon(scaledQuizTimeImg);
        JLabel quizTimeLabel = new JLabel(scaledQuizTimeIcon);
        quizTimeLabel.setBounds(50, 200, 500, 350);
        leftPanel.add(quizTimeLabel);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255, 174, 0));
        rightPanel.setBounds(600, 0, 600, 800);
        rightPanel.setLayout(null);

        // User needs to provide this image: download.jpg
        ImageIcon logoIcon2 = new ImageIcon("download.jpg");
        JLabel logoLabel2 = new JLabel(logoIcon2);
        logoLabel2.setBounds(50, 20, logoIcon2.getIconWidth(), logoIcon2.getIconHeight()); // Adjusted Y and size if needed
        rightPanel.add(logoLabel2);

        JLabel title = new JLabel("Visual Programming Quiz");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setBounds(150, 490, 400, 40); // Adjusted width
        title.setForeground(Color.BLACK);
        rightPanel.add(title);

        JLabel title2 = new JLabel("Enter Your Name & ID to Continue");
        title2.setFont(new Font("SansSerif", Font.BOLD, 20)); // Adjusted size
        title2.setBounds(130, 520, 400, 40); // Adjusted position and width
        rightPanel.add(title2);

        JLabel studentNameLabel = new JLabel("Student Name:");
        studentNameLabel.setBounds(30, 600, 150, 30);
        studentNameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        studentNameLabel.setForeground(Color.BLACK);
        rightPanel.add(studentNameLabel);

        studentNameField = new JTextField(); // Initialize here
        studentNameField.setBounds(180, 600, 250, 30); // Adjusted width
        studentNameField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        studentNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        rightPanel.add(studentNameField);

        JLabel studentIDLabel = new JLabel("Student ID:");
        studentIDLabel.setBounds(30, 650, 150, 30);
        studentIDLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        studentIDLabel.setForeground(Color.BLACK);
        rightPanel.add(studentIDLabel);

        studentIDField = new JTextField(); // Initialize here
        studentIDField.setBounds(180, 650, 250, 30); // Adjusted width
        studentIDField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        studentIDField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        rightPanel.add(studentIDField);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        loginButton.setBounds(230, 710, 100, 30); // Centered a bit
        loginButton.setForeground(Color.BLACK);
        loginButton.setBackground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        rightPanel.add(loginButton);

        loginButton.addActionListener(_ ->
        {
            String studentName = studentNameField.getText();
            String studentId = studentIDField.getText();
            if (studentName.isEmpty())
            {
                JOptionPane.showMessageDialog(frame, "Please enter your name.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else if (studentId.isEmpty())
            {
                JOptionPane.showMessageDialog(frame, "Please enter your student ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                questions_gui = new Questions_GUI(studentName, studentId);
                questions_gui.setVisible(true);
                frame.setVisible(false);
            }
        });

        frame.add(leftPanel);
        frame.add(rightPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginQuiz::new);
    }
}

