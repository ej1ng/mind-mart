import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class Image {

    public BufferedImage getImage(String imagePath) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResource(imagePath));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    public void displayImage(Graphics2D g2, BufferedImage image, int x, int y, int size) {
        g2.drawImage(image, x, y, size, size, null);
    }

    
}
