import java.awt.*;
import java.awt.image.BufferedImage;

public class Story extends Image {

    Display display;
    KeyResponse keyResp;
    private int slideNum;
    BufferedImage slide;

    public Story (Display display, KeyResponse keyResp) {
        this.display = display;
        this.keyResp = keyResp;
        slideNum = 1;
        slide = getImage("resources/intro/intro" + String.valueOf(slideNum) + ".png"); // default welcome screen
    } 

    public void update() {
        if (slideNum < 9) {
            if (keyResp.nextPressed == true) {
                keyResp.nextPressed = false;
                slideNum += 1;
                slide = getImage("resources/intro/intro" + String.valueOf(slideNum) + ".png");
            }
        } else if (slideNum == 9) {
            slide = getImage("resources/intro/intro" + String.valueOf(slideNum) + ".png");
            if (keyResp.nextPressed == true) {
                keyResp.nextPressed = false;
                slideNum = Integer.MAX_VALUE;
            }
        } else {
            display.gameState = display.shop;
        }
    }

    public void show(Graphics2D g2) {
        g2.drawImage(slide,0,0,display.width,display.height,null);
        
    }



}
