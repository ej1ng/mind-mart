import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Items extends Image {
    KeyResponse keyResp;
    Display display;
    BufferedImage item;
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
            item = getImage("resources/items/item" + keyResp.getPressedKey() + ".png");
        }
    }

    public void show(Graphics2D g2) {
        g2.drawImage(item,0,0,display.width,display.height,null);
    }
}