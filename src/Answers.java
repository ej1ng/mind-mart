import java.awt.*;
import java.awt.image.BufferedImage;

public class Answers extends Image {
    KeyResponse keyResp;
    Display display;
    Conditions generated;
    BufferedImage screen;
    private boolean correct;
    public int count;
    

    int[][] arrayOfAnswers = { // 2d array
        {17,1,5}, // adhd
        {19,0,14,10}, // anxiety
        {15,6,5,19}, // autism
        {11,10,0,8}, // bpd
        {16,18,20,10}, // depression
        {7,13,2}, // did
        {9,3,8}, // ed
        {12,10,20,4} // ptsd
    }; 

    public Answers(KeyResponse keyResp, Display display, Conditions generated) {
        this.keyResp = keyResp;
        this.display = display;
        this.generated = generated;
        correct = correctItem();
    }
    /**
     * returns boolean of either if item guessed for specific condition is correct or incorrect
     * pre: none
     * post: boolean returned
     */
    public boolean correctItem() {
        int condition = generated.getIndex();
        int userItem = keyResp.checkoutItem;


        // add all correct items to arraylist of specific condition
        if (condition >= 0 && condition < arrayOfAnswers.length) {
            // loops through the elements of the specified conditions row
            for (int j = 0; j < arrayOfAnswers[condition].length; j++) {
                if (userItem == arrayOfAnswers[condition][j]) {
                    correct = true;
                    count++;
                }
            }
        } else {
            System.out.println("Invalid row index.");
        }
        return correct;
    }
    
    public void update() {
        if (correctItem()) {
            screen = getImage("resources/correction/correction0.png");
        } else {
            screen = getImage("resources/correction/correction1.png");
        }
    }

    public void show(Graphics2D g2) {
        if (keyResp.displayedHint == true) {
            g2.drawImage(screen,0,0,display.width,display.height,null);
        }


    }

}