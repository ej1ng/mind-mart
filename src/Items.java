import java.io.*;
import java.util.ArrayList;

public class Items {
    private int currency;
    private int price;
    KeyResponse keyResp;
    ArrayList<String> descriptionList = new ArrayList<>(); // arraylist of lines from text file
    private int correctPurchases;
    /**
     * constructor
     * pre: none
     * post: sets currency to 0
     */
    public Items(int currency, KeyResponse keyResp, int price, int correctPurchases) {
        this.currency = currency;
        this.keyResp = keyResp;
        this.price = price; // price of item
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
    public void purchase(int currency, int price) { // updates currency
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
     * 
     */
}