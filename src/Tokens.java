import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Tokens extends Image {
    private int currency;
    private int price;
    KeyResponse keyResp;
    private int correctPurchases;
    Display display;
    private Font font = new Font("Arial",Font.PLAIN,20);

    /**
     * constructor
     * pre: none
     * post: sets variables
     */
    public Tokens(int currency, KeyResponse keyResp, int price, int correctPurchases, Display display) {
        this.currency = currency;
        this.keyResp = keyResp;
        this.display = display;
        this.price = price;
        this.correctPurchases = correctPurchases;
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
        currency = this.currency;
    }
    /**
     * update method
     */
    public void update() {
        System.out.println(currency); // before purchase for debug
        // purchasing
        checkout(currency, price);
        setCurrency(currency);

        System.out.println(currency); // after purchase for debug
    }
    /**
     * update and display the currency
     */
    public void showScenario(Graphics2D g2) { 
        int x = 570;
        int y = 585; 
        Color c = new Color(139,69,19);
        g2.setFont(font);
        g2.setColor(c);

    }
}