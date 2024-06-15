import java.awt.*;

/**
 * Tokens class extends Image to manage and display currency and game state
 * related to tokens.
 */
public class Tokens extends Image {
    private int currency;
    private int price;
    KeyResponse keyResp;
    Display display;
    private Font font = new Font("Arial", Font.PLAIN, 20); // Font for text rendering
    Answers ans; // Reference to manage correct item guesses

    /**
     * Constructor for Tokens class.
     * 
     * @param display The display panel.
     * @param keyResp The key response handler.
     * @param ans     The Answers instance managing correct guesses.
     */
    public Tokens(Display display, KeyResponse keyResp, Answers ans) {
        this.keyResp = keyResp;
        this.display = display;
        this.ans = ans;
        currency = 100; // Initialize currency amount
        price = 20; // Initialize item price
    }

    /**
     * Get method for retrieving current currency.
     * 
     * @return Current currency amount.
     */
    public int getCurrency() {
        return currency;
    }

    /**
     * Method to update currency after purchase.
     * 
     * @param currency Current currency amount.
     * @param price    Price of the item.
     */
    public void checkout(int currency, int price) {
        this.currency -= price; // Deduct price from currency
    }

    /**
     * Set method to update the currency amount from another class.
     * 
     * @param currency New currency amount to set.
     */
    public void setCurrency(int currency) {
        this.currency = currency; // Set currency to the given amount
    }

    /**
     * Update method to manage currency and game state based on key and answer
     * responses.
     * 
     * @Override Image superclass update method
     */
    @Override
    public void update() {
        if (currency > 0) {
            if (keyResp.checkedOut) { // Check if item checkout key is pressed
                keyResp.checkedOut = false; // Reset the checkedOut flag
                checkout(currency, price); // Deduct price from currency
            }
            if (ans.count == 3) { // Check if 3 items are correctly guessed
                if (keyResp.nextPressed) { // Check if 'Next' key is pressed
                    display.gameState = display.guess; // Switch game state to guess mode
                }
            }
        } else if (currency == 0) { // When currency is depleted
            if (keyResp.nextPressed) { // Check if 'Next' key is pressed
                display.gameState = display.guess; // Switch game state to guess mode
            }
        }
    }

    /**
     * Method to update and display currency, correct item guesses, and game
     * prompts.
     * 
     * @param g2 The graphics context.
     * @Override Image super class show method
     */
    public void show(Graphics2D g2) {
        int x = 200; // X-coordinate for currency display
        int y = 105; // Y-coordinate for currency display
        Color c = new Color(139, 69, 19); // Color for text
        g2.setFont(font); // Set font for text rendering
        g2.setColor(c); // Set color for text

        g2.drawString(String.valueOf(currency), x, y); // Display current currency top left
        g2.drawString("Correct items guessed: " + ans.count + " / 3", 70, 160); // Display correct item count

        if ((ans.count == 3 || currency == 0) && !keyResp.displayedHint) { // Display message after 3 correct guesses or
                                                                           // when currency is depleted and hint
                                                                           // is not displayed
            g2.drawString("Press ENTER to guess the condition", 1000, 740);
        }
    }

}