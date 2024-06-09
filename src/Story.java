import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;


public class Story extends Image{

    Display display;
    KeyResponse keyResp;
    private int slideNum;
    BufferedImage slide;

    public Story (Display display, KeyResponse keyResp) {
        this.display = display;
        this.keyResp = keyResp;
        slideNum = 1;
        slide = getImage("resources/intro/intro" + slideNum + ".png");
    }

    public void update() {
        if (keyResp.nextPressed == true) {
            if (slideNum < 9)  {
                slideNum +=1;
                slide = getImage("resources/intro/intro" + slideNum + ".png");
                System.out.println(slideNum);
            } else {
                display.gameState = display.shop;
            }
        }
    }

    public void show(Graphics2D g2) {
        g2.drawImage(slide,0,0,display.width,display.height,null);
        
    }



}