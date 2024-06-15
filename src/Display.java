import java.awt.*;
import javax.swing.*;

/**
 * Display class that extends JPanel and implements Runnable to create and
 * manage the game display and its updates.
 */
public class Display extends JPanel implements Runnable {

    // setting up variables for UI functionality
    final int width = 1440;
    final int height = 810;
    final int FPS = 60;
    public int intro = 1;
    public int shop = 2;
    public int guess = 3;
    public int gameState = 1;

    KeyResponse keyResp = new KeyResponse(this); // Key listener for handling keyboard input
    Thread gameThread; // Thread for running the game loop

    // Create objects for different parts of the game
    Story story = new Story(this, keyResp);
    Conditions conditions = new Conditions(this);
    Items item = new Items(this, keyResp);
    Guessing guessing = new Guessing(this, keyResp, conditions);
    Answers ans = new Answers(keyResp, this, conditions);
    Tokens currency = new Tokens(this, keyResp, ans);

    /**
     * Constructor for the Display class, sets up the game window properties.
     */
    public Display() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        this.setOpaque(false);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyResp);
    }

    /**
     * Starts the game thread.
     */
    public void startGameThread() {
        gameThread = new Thread(this); // Create a new thread for the game loop
        gameThread.start();
    }

    /**
     * The run method for the game loop, controls the update (CONTAINS LOGIC) and
     * repaint (UI) cycles.
     */
    public void run() {
        double drawInterval = 1000000000 / FPS; // Calculate the interval between frames in nanoseconds
        double delta = 0;
        long lastTime = System.nanoTime(); // Get the current time in nanoseconds
        long currentTime;

        while (gameThread != null) { // Loop while the game thread is running
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval; // Calculate the time passed since the last frame
            lastTime = currentTime;

            if (delta >= 1) {
                update(); // Update the game state
                repaint(); // Repaint the screen
                delta--;
            }
        }
    }

    /**
     * Updates the game state based on the current gameState.
     * Contains the update() call for all the logic - chain reaction
     */
    public void update() {
        if (gameState == intro) {
            story.update();
        }
        if (gameState == shop) {
            item.update();
            currency.update();
            ans.update();
        }
        if (gameState == guess) {
            guessing.update();
        }
    }

    /**
     * UI - Paints the game components on the screen based on the current gameState.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        if (gameState == intro) {
            story.show(g2);
        }
        if (gameState == shop) {
            conditions.show(g2);
            conditions.showScenario(g2); // Generate random scenario
            item.show(g2);
            ans.show(g2);
            currency.show(g2); // Display
        }
        if (gameState == guess) {
            guessing.show(g2);
            guessing.write(g2);
        }

        g2.dispose();
    }
}