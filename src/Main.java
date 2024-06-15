/*
 * Main.java
 * Mind-Mart: A mental health education/awareness game
 * 
 */
import javax.swing.*;
import java.net.URL;

/**
 * Main class that initializes and runs the game application.
 */
class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame(); // Create a new JFrame window

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation to exit on close
        frame.setResizable(false); // Disable window resizing
        frame.setTitle("Mind-Mart"); // Set window title

        Display display = new Display(); // Create a new Display instance (game panel)
        frame.add(display); // Add the Display panel to the JFrame

        frame.pack(); // Adjust JFrame size to fit the Display panel
        frame.setSize(display.width, display.height); // Set JFrame size based on Display panel dimensions
        frame.setLayout(null); // Set layout to null for custom layout handling

        // Load and display a background image using JLabel
        URL bg = Main.class.getResource("/resources/background/placeholderbg.png");
        JLabel bgDisplay = new JLabel("", new ImageIcon(bg), JLabel.CENTER);
        bgDisplay.setSize(display.width, display.height); // Set size of the background image display
        bgDisplay.setBounds(0, 0, display.width, display.height); // Set bounds (position and size) of the background
                                                                  // image
        frame.add(bgDisplay); // Add background image display to JFrame

        frame.setLocationRelativeTo(null); // Center JFrame on the screen
        frame.setVisible(true); // Make JFrame visible

        display.startGameThread(); // Start the game thread in the Display panel
    }
}
