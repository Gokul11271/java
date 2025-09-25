import java.awt.*;
import java.awt.event.*;

public class ColorChooserAWT extends Frame implements ItemListener {

    Choice colorChoice; // Drop-down list for colors

    public ColorChooserAWT() {
        // Set frame properties
        setTitle("Color Chooser");
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Create Choice component
        colorChoice = new Choice();

        // Add color options
        colorChoice.add("Red");
        colorChoice.add("Green");
        colorChoice.add("Blue");
        colorChoice.add("Yellow");
        colorChoice.add("Cyan");
        colorChoice.add("Magenta");
        colorChoice.add("White");
        colorChoice.add("Gray");

        // Add Choice to frame
        add(new Label("Select a color:"));
        add(colorChoice);

        // Register ItemListener
        colorChoice.addItemListener(this);

        // Window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // Make frame visible
        setVisible(true);
    }

    // Handle item selection
    public void itemStateChanged(ItemEvent e) {
        String selectedColor = colorChoice.getSelectedItem();

        switch (selectedColor) {
            case "Red":
                setBackground(Color.RED);
                break;
            case "Green":
                setBackground(Color.GREEN);
                break;
            case "Blue":
                setBackground(Color.BLUE);
                break;
            case "Yellow":
                setBackground(Color.YELLOW);
                break;
            case "Cyan":
                setBackground(Color.CYAN);
                break;
            case "Magenta":
                setBackground(Color.MAGENTA);
                break;
            case "White":
                setBackground(Color.WHITE);
                break;
            case "Gray":
                setBackground(Color.GRAY);
                break;
        }
    }

    public static void main(String[] args) {
        new ColorChooserAWT();
    }
}
