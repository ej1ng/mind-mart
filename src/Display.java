import java.awt.*;
import javax.swing.*;


public class Display extends JPanel {

    final int width =  1920;
    final int height = 1080;


    public int gameState = 1; // initialize to intro state cuz we're starting w/ the intro
    public final int intro = 1;
    public final int game = 2;

    Image img = new Image();
    Text txt = new Text(this);
    Conditions conditions = new Conditions();
    KeyResponse keyResp = new KeyResponse(this);
    Graphics2D g2;


    public Display() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        this.setOpaque(false);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

    }

    public void run() {

        
    }
    
    public void changeDisplay(Graphics g) {
        super.paintComponent(g); 

        g2 = (Graphics2D)g;

    }

    public void showBeginningSlides() {

    }

    public void showScenario(String imagePath) {
        // img.displayImage(g2,img.getImage(imagePath), 1,2,200,200); 
        txt.displayText(g2,1,2,20,conditions.getScenario());
    }

}
