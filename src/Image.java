import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import java.awt.*;

/**
 * Abstract class with methods to get an image and abstract methods to update
 * and show the image.
 */
abstract class Image {

    /**
     * Loads an image from the specified path.
     * 
     * @param imagePath The path to the image file.
     * @return The loaded BufferedImage, or null if an error occurred.
     */
    public BufferedImage getImage(String imagePath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource(imagePath)); // Read image from file
            return image;
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace if an error occurs
        }
        return image;
    }

    /**
     * Abstract method to update the image, to be implemented by subclasses.
     */
    abstract void update();

    /**
     * Abstract method to display the image, to be implemented by subclasses.
     * 
     * @param g2 The graphics context.
     */
    abstract void show(Graphics2D g2);
}
