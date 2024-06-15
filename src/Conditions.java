import java.util.Random;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Conditions sub class of Image contains methods that determine and display
 * the random condition generated to the screen
 */
public class Conditions extends Image {
    private int index;
    private String scenario;
    private Font font = new Font("Arial", Font.PLAIN, 20);
    BufferedImage template;
    Display display;
    

    File adhd = new File("src/conditions/adhd.txt"); // Creates objects for all condition files
    File anxiety = new File("src/conditions/anxiety.txt");
    File autism = new File("src/conditions/autism.txt");
    File bpd = new File("src/conditions/bpd.txt");
    File depression = new File("src/conditions/depression.txt");
    File did = new File("src/conditions/did.txt");
    File ed = new File("src/conditions/ed.txt");
    File ptsd = new File("src/conditions/ptsd.txt");

    private File[] conditionListFiles = {adhd,anxiety,autism,bpd,depression,did,ed,ptsd};
    /**
     * Constructor: Initializes the Conditions object and sets the display.
     * Generates a random number within the length of the conditionList array.
     * 
     * @param display The Display object to be associated with this Conditions
     *                object.
     */
    public Conditions(Display display) {
        this.display = display;
    }

    /**
     * Generates and returns a scenario description by reading from a randomly
     * selected condition file.
     * 
     * @return The scenario description as a String.
     */
    public String getScenario() {
        setIndex();
        StringBuffer fileContent = new StringBuffer(); // Initialize a StringBuffer to hold the file content
        try {
            FileReader stream = new FileReader(conditionListFiles[index]); // Create file stream
            BufferedReader fileRead = new BufferedReader(stream); // Wrap FileReader in BufferedReader for efficient
                                                                  // reading

            String line;
            while ((line = fileRead.readLine()) != null) { // Read while there are still more lines to read
                fileContent.append(line).append(" "); // Append each line to the StringBuffer
            }
            stream.close(); // Close file streams
            fileRead.close();
        } catch (IOException e) { // Handle any IO exceptions that occur during file reading
            System.out.printf("\nError reading file.\nIOException: %s\n", e.getMessage());
        }
        scenario = fileContent.toString(); // Convert StringBuffer to String and assign to scenario
        return scenario;
    }

    /**
     * Generates a random index number and sets it.
     */
    public void setIndex() {
        Random random = new Random();
        index = random.nextInt(conditionListFiles.length); // Generate random int between 0-7
    }

    /**
     * Returns the index value.
     * 
     * @return The current index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Abstract method from the Image class. This implementation does not use this
     * method.
     */
    public void update() {
        // Abstract method that is defined in Image class - not used in this
        // implementation
    }

    /**
     * Displays the scenario template image on the screen.
     * 
     * @param g2 The Graphics2D object used for drawing the image.
     * @Override Image super class show method
     */
    public void show(Graphics2D g2) {
        template = getImage("resources/background/scenario.png"); // Get the scenario template image
        g2.drawImage(template, 0, 0, display.width, display.height, null); // Draw the template image on the screen
    }
    
    String randScenario = getScenario(); // Generate the scenario string by calling getScenario()
    /**
     * Splits the scenario description into multiple lines based on the '/'
     * character.
     * 
     * @return An ArrayList containing the segments of the scenario description
     *         split by '/'.
     */
    public ArrayList<String> getLineArray() {
        char character; // Variable to hold each character in the scenario description
        String line = ""; // String to accumulate characters until a '/' is found
        ArrayList<String> totalScenario = new ArrayList<String>(); // List to store each line segment of the scenario
        boolean letter = false; // Flag to track if the current line contains any characters

        // Iterate through each character in the scenario string
        for (int i = 0; i < randScenario.length(); i++) {
            character = randScenario.charAt(i); // Get the current character
            if (character == '/') { // Check if the character is a '/'
                totalScenario.add(line); // Add the current line to the totalScenario list
                line = ""; // Reset the line accumulator
                letter = false; // Reset the letter flag
            } else {
                line += character; // Append the character to the current line
                letter = true; // Set the letter flag to true
            }
        }

        // After the loop, check if there is any remaining line to add
        if (letter) {
            totalScenario.add(line); // Add the last line to the totalScenario list
            line = ""; // Reset the line accumulator (not strictly necessary here)
        }

        return totalScenario; // Return the list of line segments
    }

    /**
     * Displays the scenario description on the screen, line by line.
     * 
     * @param g2 The Graphics2D object used for drawing the text.
     */
    public void showScenario(Graphics2D g2) {
        int x = 570;
        int y = 585;
        Color c = new Color(139, 69, 19); // Color for the text
        g2.setFont(font); // Set the font for the text
        g2.setColor(c); // Set the color for the text
        
        for (String line : getLineArray()) { // Iterate through each line segment and draw it on the screen
            g2.drawString(line, x, y); // Draw the current line at the specified coordinates
            y += 25;
        }
    }
}
