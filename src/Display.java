import java.awt.*;
import javax.swing.*;



public class Display extends JPanel implements Runnable{

    final int width =  1440;
    final int height = 810;

    private int currentIntroSlide = 1;

    final int FPS = 60; 
    public final int intro = 1;
    public final int shop = 2;
    public final int guess = 3;
    public int gameState = intro; // initialize to intro state cuz we're starting w/ the intro


    private int currency = 100; // intialize currency
    private int price = 20; // initialize item price
    private int correctPurchases = 0;


    Conditions conditions = new Conditions();
    KeyResponse keyResp = new KeyResponse(this);
    Thread gameThread;


    public Display() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        this.setOpaque(false);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void run() {
        
    }

    public void update() {
        
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        Graphics2D g2 = (Graphics2D)g;


        g2.dispose(); 


    }





}
