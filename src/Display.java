import java.awt.*;
import javax.swing.*;



public class Display extends JPanel implements Runnable{

    final int width =  1440;
    final int height = 810;

    final int FPS = 60; 
    public int intro = 1;
    public int shop = 2;
    public int guess = 3;
    public int gameState = 1; // initialize to intro state cuz we're starting w/ the intro


    // variable for the currency class
    // variable for the currency class
    private int currency = 100; // intialize currency
    private int price = 20; // initialize item price
    private int correctPurchases = 0;


    Conditions conditions = new Conditions(this);
    KeyResponse keyResp = new KeyResponse(this);
    Thread gameThread;

    // create objects for game

    // create objects for game
    Story story = new Story(this, keyResp);
    Items item = new Items(this, keyResp);

    public Display() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        this.setOpaque(false);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyResp);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;



        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();

                repaint();

                delta --;
            }
        }
    }

    public void update() {
        if (gameState == intro) {
            story.update();
        }
        if (gameState == shop) {

            item.update();
            item.update();
        }
        if (gameState == guess) {
            
            
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        Graphics2D g2 = (Graphics2D)g;

        if (gameState == intro) {
            story.show(g2);
        }
        if (gameState == shop) {
            conditions.showBg(g2);
            conditions.showScenario(g2);
            
            if (keyResp.displayed == true) {
                item.show(g2);
            }

            if (keyResp.displayed == true) {
                item.show(g2);
            }

        }

        g2.dispose(); 


    }



}
