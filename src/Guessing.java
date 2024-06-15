import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Guessing class extends Image to handle the guessing logic in the game.
 */
public class Guessing extends Image {
    BufferedImage screen;
    Display display;
    KeyResponse keyResp;
    Conditions condition;
    String guess = "";
    Font font = new Font("Arial", Font.PLAIN, 30);
    private String[] conditionList = { "adhd", "anxiety", "autism", "bpd", "depression", "did", "ed", "ptsd" };

    /**
     * Constructor to initialize the Guessing class.
     * 
     * @param display   The display panel.
     * @param keyResp   The key response handler.
     * @param condition The conditions handler.
     */
    public Guessing(Display display, KeyResponse keyResp, Conditions condition) {
        this.display = display;
        this.keyResp = keyResp;
        this.condition = condition;
        screen = getImage("resources/guess_screens/guess.png"); // Load initial guess screen image
    }

    /**
     * Updates the guess based on the key response.
     * 
     * @Override Image super class update method
     */
    public void update() {
        if (keyResp.guess > 0) { // Check if a guess has been made
            screen = getImage("resources/guess_screens/result" + (condition.getIndex() + 1) + ".png"); // Load result
                                                                                                       // screen image
            guess = conditionList[keyResp.guess - 1]; // Update the guess based on the key response
        }
    }

    /**
     * Displays the current screen image.
     * 
     * @param g2 The graphics context.
     * @Override Image super class show method
     */
    public void show(Graphics2D g2) {
        g2.drawImage(screen, 0, 0, display.width, display.height, null); // Draw the current screen image
    }

    /**
     * Draws the guessed condition on the screen.
     * 
     * @param g2 The graphics context.
     */
    public void write(Graphics2D g2) {
        Color c = new Color(110, 69, 19); // Set the text color
        g2.setFont(font); // Set the font
        g2.setColor(c); // Apply the text color

        if (condition.getIndex() == 6) { // Check if the condition is ED
            g2.drawString(guess.toUpperCase(), 773, 127); // Draw the guess at the specified coordinates
        } else {
            g2.drawString(guess.toUpperCase(), 773, 183); // Draw the guess at the specified coordinates
        }
    }
}
