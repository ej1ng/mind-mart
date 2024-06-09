import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Items extends Image {
    KeyResponse keyResp;
    Display display;
    BufferedImage item;
    BufferedImage correction;

    /**
     * constructor
     * pre: none
     * post: sets keyResp and display
     */
    public Items(Display display, KeyResponse keyResp) {
        this.keyResp = keyResp;
        this.display = display;
        
    }

    public void update() {
        if (keyResp.displayed == true) {
            item = getImage("resources/items/item" + keyResp.pressedKey + ".png");
        }
        if (keyResp.checkedOut == true) {
            correction = getImage("resources/correction/correction.png"); // update later
        }
    }

    public void show(Graphics2D g2) {
        BufferedImage img = item;
        if (keyResp.displayed == true) {
            g2.drawImage(img,0,0,display.width,display.height,null);
        }

    }
    
}