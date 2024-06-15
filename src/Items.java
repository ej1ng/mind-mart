import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Items class extends Image to manage and display items in the game.
 */
public class Items extends Image {
    KeyResponse keyResp; // KeyResponse object to handle keyboard input
    Display display; // Display object to manage the game display
    BufferedImage item; // BufferedImage to hold the current item image

    /**
     * Constructor for Items class.
     * 
     * @param display The display panel.
     * @param keyResp The key response handler.
     */
    public Items(Display display, KeyResponse keyResp) {
        this.keyResp = keyResp;
        this.display = display;
    }

    /**
     * Updates the item image based on keyboard input.
     * 
     * @Override Image super class update method
     */
    public void update() {
        if (keyResp.displayed) { // Check if an item is currently displayed
            item = getImage("resources/items/item" + keyResp.pressedKey + ".png"); // Load item image based on key
                                                                                   // pressed
        }
    }

    /**
     * Displays the item image on the screen if an item is currently displayed.
     * 
     * @param g2 The graphics context.
     * @Override Image super class show method
     */
    public void show(Graphics2D g2) {
        BufferedImage img = item; // Assign current item image to local variable
        if (keyResp.displayed) { // Check if an item is currently displayed
            g2.drawImage(img, 0, 0, display.width, display.height, null); // Draw item image on the display
        }
    }
}
