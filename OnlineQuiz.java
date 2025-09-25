import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlineQuiz extends JFrame implements ActionListener {
    // Questions, options, and correct answers
    String[] questions = {
        "Which language is used for Android development?",
        "What is the capital of France?",
        "Which is the largest planet in our solar system?"
    };

    String[][] options = {
        {"Java", "Python", "C++", "Kotlin"},
        {"Paris", "London", "Berlin", "Madrid"},
        {"Earth", "Mars", "Jupiter", "Venus"}
    };

    int[] correctAnswers = {0, 0, 2}; // Index of correct options
    int[] userAnswers = {-1, -1, -1}; // Store user-selected options

    // GUI components
    JLabel questionLabel, timerLabel;
    JRadioButton[] optionButtons;
    ButtonGroup bg;
    JButton nextBtn, prevBtn, submitBtn;

    int currentQuestion = 0;
    int timeLeft = 60; // seconds
    Timer timer;

    public OnlineQuiz() {
        // Frame properties
        setTitle("Online Quiz");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel for question and timer
        JPanel topPanel = new JPanel(new BorderLayout());
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(questionLabel, BorderLayout.CENTER);

        timerLabel = new JLabel("Time left: " + timeLeft + "s");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        topPanel.add(timerLabel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // Center panel for options
        JPanel centerPanel = new JPanel(new GridLayout(4, 1));
        optionButtons = new JRadioButton[4];
        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            bg.add(optionButtons[i]);
            centerPanel.add(optionButtons[i]);
        }
        add(centerPanel, BorderLayout.CENTER);

        // Bottom panel for navigation buttons
        JPanel bottomPanel = new JPanel();
        prevBtn = new JButton("Previous");
        nextBtn = new JButton("Next");
        submitBtn = new JButton("Submit");

        prevBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        submitBtn.addActionListener(this);

        bottomPanel.add(prevBtn);
        bottomPanel.add(nextBtn);
        bottomPanel.add(submitBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        // Initialize first question
        loadQuestion(currentQuestion);

        // Start timer
        timer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time left: " + timeLeft + "s");
            if (timeLeft <= 0) {
                timer.stop();
                calculateScore();
            }
        });
        timer.start();

        setVisible(true);
    }

    // Load question and restore selected answer
    void loadQuestion(int index) {
        questionLabel.setText("Q" + (index + 1) + ": " + questions[index]);
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(options[index][i]);
        }

        // Restore previous selection if any
        bg.clearSelection();
        if (userAnswers[index] != -1) {
            optionButtons[userAnswers[index]].setSelected(true);
        }
    }

    // Handle button actions
    public void actionPerformed(ActionEvent e) {
        // Store selected answer
        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected()) {
                userAnswers[currentQuestion] = i;
            }
        }

        if (e.getSource() == nextBtn) {
            if (currentQuestion < questions.length - 1) {
                currentQuestion++;
                loadQuestion(currentQuestion);
            }
        } else if (e.getSource() == prevBtn) {
            if (currentQuestion > 0) {
                currentQuestion--;
                loadQuestion(currentQuestion);
            }
        } else if (e.getSource() == submitBtn) {
            timer.stop();
            calculateScore();
        }
    }

    // Calculate and show score
    void calculateScore() {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            if (userAnswers[i] == correctAnswers[i]) {
                score++;
            }
        }
        JOptionPane.showMessageDialog(this, "Your score: " + score + " out of " + questions.length);
        System.exit(0);
    }

    public static void main(String[] args) {
        new OnlineQuiz();
    }
}
