import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * story class that displays the graphics/storyline
 */
public class Story {
    // creates objects for all condition files
    File adhd = new File("adhd.txt");
    File anxiety = new File("anxiety.txt");
    File autism = new File("autism.txt");
    File bpd = new File("bpd.txt");
    File depression = new File("depression.txt");
    File did = new File("did.txt");
    File ed = new File("ed.txt");
    File ptsd = new File("ptsd.txt");

    File[] conditions = {adhd, anxiety, autism, bpd, depression, did, ed, ptsd}; // array of condition files
    int[] inventory = new int[21]; // inventory for 21 items

    Conditions condition = new Conditions(); // creates condition object
    Items item = new Items(); // creates itme object

    /**
     * run method that starts the entire game
     * pre: none
     * post: game features and functionalities are displayed
     */
    public void run () {
        
    }
}