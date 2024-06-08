import java.awt.*;

public class Text {
    
    Display display;
    Graphics2D g2;
    Font font;
    
    public Text(Display display) {
        this.display = display;

    }

    public void displayScenarioText(Graphics2D g2, int x, int y, int size, String text) {
        this.g2 = g2; 
        font = new Font("Arial",Font.PLAIN,size);

        for (String line : text.split("\n")) {
            g2.drawString(line,x,y);
            y += 30;
        }
    }




}
