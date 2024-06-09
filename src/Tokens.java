
import java.awt.*;

public class Tokens extends Image {
    private int currency;
    private int price;
    KeyResponse keyResp;
    Display display;
    private Font font = new Font("Arial",Font.PLAIN,20);
    Answers ans;

    /**
     * constructor
     * pre: none
     * post: sets variables
     */
    public Tokens(Display display, KeyResponse keyResp, Answers ans) {
        this.keyResp = keyResp;
        this.display = display;
        this.ans = ans;
        currency = 100; // intialize currency
        price = 20; // initialize item price
    }

    /**
     * get method returns currency
     * pre: none
     * post: currency updated and returned
     */
    public int getCurrency() {
        return currency;
    }
    /**
     * updates currency after purchase
     * pre: none
     * post: subtracts from currency value
     */
    public void checkout(int currency, int price) { // updates currency
        this.currency -= price;
    }
    /**
     * updates the currency in this class from another class
     * pre: none
     * post: currency in this class is updated
     */
    public void setCurrency(int currency) {
        this.currency = currency;
    }
    /**
     * update method
     */
    public void update() {
        if (currency > 0) {
            if (keyResp.checkedOut == true) {
                keyResp.checkedOut = false;
                checkout(currency,price);
            }
        } else if (currency == 0 || ans.count == 3) {
            if (keyResp.nextPressed == true) {
                display.gameState = display.guess;

            }
        }
    }

    /**
     * update and display the currency
     */
    public void show(Graphics2D g2) { 
        int x = 200;
        int y = 105; 
        Color c = new Color(139,69,19);
        g2.setFont(font);
        g2.setColor(c);
        g2.drawString(String.valueOf(currency),x,y);
        
        if (currency == 0) {
            g2.drawString("Press enter to guess the disorder",1030,150);
            
            
            
            
            
            
            
        
        }
    }

}