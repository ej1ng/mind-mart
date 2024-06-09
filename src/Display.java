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

    
    KeyResponse keyResp = new KeyResponse(this);
    Thread gameThread;

    // create objects for game
    Story story = new Story(this, keyResp);
    Conditions conditions = new Conditions(this);
    Items item = new Items(this, keyResp);

    Guessing guessing = new Guessing(this,keyResp,conditions);
    Answers ans = new Answers(keyResp, this, conditions);
    Tokens currency = new Tokens (this,keyResp, ans);


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
            currency.update();
            ans.update();
        }
        if (gameState == guess) {
            guessing.update();
            
            
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
            conditions.showScenario(g2); // generate random scenario
            item.show(g2);
            ans.show(g2);
            currency.show(g2);

        }
        if (gameState == guess) {
            guessing.show(g2);
            guessing.write(g2);

        }
        g2.dispose(); 

    }
}
