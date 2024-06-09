import java.awt.*;
import java.awt.image.BufferedImage;

public class Guessing extends Image{

    BufferedImage screen;
    Display display;
    KeyResponse keyResp;
    Conditions condition;
    String guess = "";
    Font font = new Font("Arial",Font.PLAIN,30);
    private String[] conditionList = {"adhd", "anxiety", "autism", "bpd", "depression", "did", "ed", "ptsd"};

    public Guessing(Display display, KeyResponse keyResp, Conditions condition) {
        this.display = display;
        this.keyResp = keyResp;
        this.condition = condition;
        screen = getImage("resources/guess_screens/guess.png");
    }
    
    public void update() {

        if (keyResp.guess > 0) {
            screen = getImage("resources/guess_screens/result" + String.valueOf(condition.getIndex() + 1) + ".png");
            guess = conditionList[keyResp.guess - 1];
        }

    }

    public void show(Graphics2D g2) {
        g2.drawImage(screen,0,0,display.width,display.height,null);

    }


    public void write(Graphics2D g2) {
        Color c = new Color(110,69,19);
        g2.setFont(font);
        g2.setColor(c);

        g2.drawString(guess.toUpperCase(), 773,183);
    }
}
