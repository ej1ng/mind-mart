import java.util.Random;
import java.io.*;

public class Conditions {
    private int index;
    private String scenario;

    // creates objects for all condition files
    File adhd = new File("/Users/emilyjing/Documents/code/jamhacks/mind-mart/src/conditions/adhd.txt");
    File anxiety = new File("/Users/emilyjing/Documents/code/jamhacks/mind-mart/src/conditions/anxiety.txt");
    File autism = new File("/Users/emilyjing/Documents/code/jamhacks/mind-mart/src/conditions/autism.txt");
    File bpd = new File("/Users/emilyjing/Documents/code/jamhacks/mind-mart/src/conditions/bpd.txt");
    File depression = new File("/Users/emilyjing/Documents/code/jamhacks/mind-mart/src/conditions/depression.txt");
    File did = new File("/Users/emilyjing/Documents/code/jamhacks/mind-mart/src/conditions/did.txt");
    File ed = new File("/Users/emilyjing/Documents/code/jamhacks/mind-mart/src/conditions/ed.txt");
    File ptsd = new File("/Users/emilyjing/Documents/code/jamhacks/mind-mart/src/conditions/ptsd.txt");
    
    private File[] conditionList = {adhd, anxiety, autism, bpd, depression, did, ed, ptsd}; // array of condition files
    /**
     * constructor: generates a random number within the length of the conditionList array
     * pre: none
     * post: random number generated
     */
    public Conditions() {
        Random random = new Random();
        index = random.nextInt(conditionList.length);
    }
    /**
     * generates scenario description
     */
    public String getScenario() {
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
}