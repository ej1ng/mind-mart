import java.awt.*;
import javax.swing.*;


public class Display extends JPanel {

    final int width =  1920;
    final int height = 1080;

    public Display() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        this.setOpaque(false);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

    }

    public void changeDisplay(Graphics g) {
        super.paintComponent(g); 

        Graphics2D g2 = (Graphics2D)g;

        

    }

    public void update() {

    }
    
}
