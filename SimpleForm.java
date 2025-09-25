import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleForm extends JFrame implements ActionListener {
    // Components
    JLabel nameLabel, passwordLabel, greetingLabel;
    JTextField nameField;
    JPasswordField passwordField;
    JButton submitBtn;

    public SimpleForm() {
        // Set frame properties
        setTitle("Simple Form");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5)); // 4 rows, 2 columns

        // Initialize components
        nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        submitBtn = new JButton("Submit");
        greetingLabel = new JLabel(""); // Initially empty

        // Add components to frame
        add(nameLabel);
        add(nameField);

        add(passwordLabel);
        add(passwordField);

        add(submitBtn);
        add(greetingLabel); // Greeting message will appear here

        // Register action listener
        submitBtn.addActionListener(this);

        // Make frame visible
        setVisible(true);
    }

    // Handle button click
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        greetingLabel.setText("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        new SimpleForm();
    }
}
