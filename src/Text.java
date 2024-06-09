import java.awt.*;

public class Text {
    
    Display display;
    Font font;
    
    public void displayText(Graphics2D g2, int x, int y, int size, String text) {
        font = new Font("Comfortaa",Font.PLAIN,40);
        

        for (String line : text.split("\n")) {
            g2.setFont(font);
            g2.setColor(Color.red);
            g2.drawString(line,x,y);
            y += 30;
        }
    }
}