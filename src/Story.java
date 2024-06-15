import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Story class extends Image to manage and display story slides in the game.
 */
public class Story extends Image {
    Display display;
    KeyResponse keyResp;
    private int slideNum;
    BufferedImage slide;

    /**
     * Constructor for Story class.
     * 
     * @param display The display panel.
     * @param keyResp The key response handler.
     */
    public Story(Display display, KeyResponse keyResp) {
        this.display = display;
        this.keyResp = keyResp;
        slideNum = 1; // Start with the first slide
        slide = getImage("resources/intro/intro" + slideNum + ".png"); // Load default welcome screen image
    }

    /**
     * Updates the current story slide based on key presses.
     * Advances to the next slide when 'Next' key is pressed.
     * 
     * @Override Image super class update method
     */
    public void update() {
        if (slideNum < 9) { // Check if current slide number is less than 9
            if (keyResp.nextPressed) { // Check if 'Next' key is pressed
                keyResp.nextPressed = false; // Reset the nextPressed flag
                slideNum++; // Move to the next slide
                slide = getImage("resources/intro/intro" + slideNum + ".png"); // Load the next slide image
            }
        } else if (slideNum == 9) { // If on the last slide (slide 9)
            slide = getImage("resources/intro/intro" + slideNum + ".png"); // Load the last slide image
            if (keyResp.nextPressed) { // Check if 'Next' key is pressed
                keyResp.nextPressed = false; // Reset the nextPressed flag
                slideNum = Integer.MAX_VALUE; // Set slideNum to a large value to indicate end of story
            }
        } else { // After all slides are shown
            display.gameState = display.shop; // Switch game state to shop mode
        }
    }

    /**
     * Displays the current story slide on the screen.
     * 
     * @param g2 The graphics context.
     * @Override Image super class show method
     */
    public void show(Graphics2D g2) {
        g2.drawImage(slide, 0, 0, display.width, display.height, null); // Draw the current slide image
    }
}
