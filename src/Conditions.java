import java.util.Random;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Conditions extends Image {
    private int index;
    private String scenario;
    private Font font = new Font("Arial",Font.PLAIN,20);
    BufferedImage template;
    Display display;

    // creates objects for all condition files
    File adhd = new File("src/conditions/adhd.txt");
    File anxiety = new File("src/conditions/anxiety.txt");
    File autism = new File("src/conditions/autism.txt");
    File bpd = new File("src/conditions/bpd.txt");
    File depression = new File("src/conditions/depression.txt");
    File did = new File("src/conditions/did.txt");
    File ed = new File("src/conditions/ed.txt");
    File ptsd = new File("src/conditions/ptsd.txt");;
    
    private File[] conditionList = {adhd, anxiety, autism, bpd, depression, did, ed, ptsd}; // array of condition files
    /**
     * constructor: generates a random number within the length of the conditionList array
     * pre: none
     * post: random number generated
     */
    public Conditions(Display display) {
        this.display = display;
    }
    /**
     * generates scenario description
     */
    public String getScenario() {
        Random random = new Random();
        index = random.nextInt(conditionList.length);
        StringBuffer fileContent = new StringBuffer(); // initialize a stringbuffer to hold the file content
        try {
            FileReader stream = new FileReader(conditionList[index]); // creates file stream
            BufferedReader fileRead = new BufferedReader(stream); // reads the file stream

            String line;
            while ((line = fileRead.readLine()) != null) { // reads while there are still more lines to read
                fileContent.append(line).append(" ");
            }
            stream.close();
            fileRead.close();
        } catch (IOException e) { // throws an error if file cannot be accessed and read
            System.out.printf("\nError reading file.\nIOException: %s\n", e.getMessage());
        }
        scenario = fileContent.toString();
        return scenario;
    }

    /**
     * returns the index value
     * pre: none
     * post: index returned
     * @return index
     */
    public int getIndex() {
        return index;
    }


    public void showBg(Graphics2D g2) {
        template = getImage("resources/background/scenario.png");
        g2.drawImage(template,0,0,display.width,display.height,null);
    }

    String randScenario = getScenario();

    public ArrayList<String> getLineArray() {
        char character;
        String line = "";
        ArrayList<String> totalScenario = new ArrayList<String>();
        boolean letter = false;

        for (int i = 0; i < randScenario.length();i++) {
            character = randScenario.charAt(i);
            if (character == '/') {
                totalScenario.add(line);
                line = "";
                letter = false;
            } else {
                line += character;
                letter = true;
            }
        }
        if (letter == true) {
            totalScenario.add(line);
            line = "";
        }
        return totalScenario;
    }

    public void showScenario(Graphics2D g2) { 
        int x = 570;
        int y = 590; 
        Color c = new Color(139,69,19);
        g2.setFont(font);
        g2.setColor(c);
        for (String line : getLineArray()) {
            g2.drawString(line,x,y);
            y += 30;
        }

    }
}
