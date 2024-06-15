import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Answers sub class of Image contains methods that determine and display
 * if the item the user guessed is correct or incorrect.
 * This class also generates displays the hints the user
 * gets after guessing a correct item.
 * 
 */
public class Answers extends Image {
    KeyResponse keyResp; // initializing all objects being passed through the constructor
    Display display;
    Conditions generated;
    BufferedImage screen;
    private boolean correct; // initializing all variables used in the class
    public int count;
    private int temp = 100;
    private String hint;
    private Font font = new Font("Arial", Font.PLAIN, 20); // font object for UI display

    int[][] arrayOfAnswers = { // 2d array of correct item answers for each condition
            { 17, 1, 5 }, // correct item indexes for adhd
            { 19, 0, 14, 10 }, // correct item indexes anxiety
            { 15, 6, 5, 19 }, // correct item indexes for autism
            { 11, 10, 0, 8 }, // correct item indexes for BPD
            { 16, 18, 20, 10 }, // correct item indexes for depression
            { 7, 13, 2 }, // correct item indexes for DID
            { 9, 3, 8 }, // correct item indexes for ED
            { 12, 10, 20, 4 } // correct item indexes for PTSD
    };

    /**
     * constructor: passes through objects from other classes
     * to be used by the Answers class
     * 
     * @param keyResp
     * @param display
     * @param generated
     */
    public Answers(KeyResponse keyResp, Display display, Conditions generated) {
        this.keyResp = keyResp;
        this.display = display;
        this.generated = generated;
        // correct = correctItem();
    }

    /**
     * returns a boolean if the item the user guessed
     * for a specific condition is correct or incorrect
     * pre: none
     * post: boolean returned
     * 
     * @return correct
     */
    public boolean correctItem() {
        int condition = generated.getIndex(); // gets the index of the condition originally generated
        int userItem = keyResp.checkoutItem; // gets the index of the item the user guessed

        if (userItem >= 0 && userItem <= 20) { // if userItem is within range of array
            correct = false;
            for (int j = 0; j < arrayOfAnswers[condition].length; j++) { // loops through the elements of the specified
                                                                         // conditions row
                if (userItem == arrayOfAnswers[condition][j]) { // if userItem is equal to one of the correct items in
                                                                // the array of the row of the originally generated
                                                                // condition
                    correct = true;
                    if (temp != userItem) { // increments count for every unique correct item
                        count++;
                        temp = userItem; // sets previous item to current item
                    }
                    break; // breaks from for loop once correct item is found
                }
            }
        }
        return correct;
    }

    /**
     * getHint() method retrieves a hint from one of two hint files based on the
     * current count value. It reads the appropriate file, stores all hints in an
     * ArrayList, and returns the hint corresponding to a specified condition index.
     * 
     * @return hint
     */
    public String getHint() {
        File firstHint = new File("src/resources/hints/firstHint.txt"); // Define the paths to the hint files
        File secondHint = new File("src/resources/hints/secondHint.txt");

        File[] hintFiles = { firstHint, secondHint }; // Create an array to hold the hint files for easy access
        ArrayList<String> hintList = new ArrayList<String>(); // Initialize an ArrayList to store the hints read from
                                                              // the files
        int condition = generated.getIndex(); // Get the condition index from a generated source

        if (count == 1 || count == 2) { // Check if the count is either 1 or 2 to determine which hint file to use
            try {
                FileReader stream = new FileReader(hintFiles[count - 1]); // Create a FileReader to read the chosen hint
                                                                          // file based on the count
                BufferedReader fileRead = new BufferedReader(stream);
                String line; // Variable to hold each line read from the file
                while ((line = fileRead.readLine()) != null) { // Read lines from the file and add them to the hintList
                    hintList.add(line);
                }
                hint = hintList.get(condition); // Get the hint at the index specified by the condition
                stream.close(); // Close the file streams
                fileRead.close();
            } catch (IOException e) { // Handle any IO exceptions that occur during file reading
                System.out.printf("\nError reading file.\nIOException: %s\n", e.getMessage());
            }
        }
        return hint;
    }

    /**
     * This method processes the hint string by splitting it into multiple lines
     * based on the '/' character. Each segment of the hint is stored in an
     * ArrayList, which is returned as the result.
     *
     * @return totalHint (an arraylist)
     */
    public ArrayList<String> getLineHint() {
        char character;
        String line = "";
        ArrayList<String> totalHint = new ArrayList<String>(); // List to store each line segment of the hint
        boolean letter = false; // Flag to track if the current line contains any characters

        for (int i = 0; i < getHint().length(); i++) { // Iterate through each character in the hint strin
            character = hint.charAt(i);
            if (character == '/') { // Check if the character is a '/'
                totalHint.add(line); // Add the current line to the totalHint list
                line = ""; // Reset the line accumulator
                letter = false; // Reset the letter flag
            } else {
                line += character; // Append the character to the current line
                letter = true; // Set the letter flag to true
            }
        }

        if (letter == true) { // After the loop, check if there is any remaining line to add
            totalHint.add(line);
            line = "";
        }
        return totalHint;
    }

    /**
     * update method determines which screen to output if the user guess is correct
     * or incorrect
     * 
     * @Override Image super class update method
     */
    public void update() {
        if (correctItem()) { // correct
            screen = getImage("resources/correction/correction0.png");
        } else { // incorrect
            screen = getImage("resources/correction/correction1.png");
        }
    }

    /**
     * UI method that displays the screen generated and the hint onto the screen
     * 
     * @Override Image super class show method
     */
    public void show(Graphics2D g2) {
        int x = 570;
        int y = 656;
        Color c = new Color(139, 69, 19);
        g2.setFont(font);
        g2.setColor(c);

        if (keyResp.displayedHint == true) {
            g2.drawImage(screen, 0, 0, display.width, display.height, null);
            if (correct) {
                for (String line : getLineHint()) {
                    g2.drawString(line, x, y);
                    y += 25;
                }
            }

        }

    }

}