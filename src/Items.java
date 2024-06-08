import java.io.*;
import java.util.ArrayList;

public class Items {
    private int currency;
    private String description;
    Display display;
    KeyResponse keyResp;
    ArrayList<String> descriptionList = new ArrayList<>(); // arraylist of lines from text fi
    /**
     * constructor
     * pre: none
     * post: sets currency to 0
     */
    public Items(int currency, KeyResponse keyResp) {
        this.currency = currency;
        this.keyResp = keyResp;
    }

    public String getDescription() {
        // gonna read through the item-description.txt file and then save it line by line into an empty array
        try {
            String filePath = "/Users/emilyjing/Documents/code/jamhacks/mind-mart/src/item-descriptions.txt"; // filepath
            FileReader stream = new FileReader(filePath); // creates file stream
            BufferedReader fileRead = new BufferedReader(stream); // reads the file stream

            String line;
            while ((line = fileRead.readLine()) != null) {
                descriptionList.add(line); // adds each line in text file to an element in arraylist
            }
            stream.close();
            fileRead.close();
        } catch (IOException e) { // throws an error if file cannot be accessed and read
            System.out.printf("\nError reading file.\nIOException: %s\n", e.getMessage());
        }
        description = descriptionList.get(keyResp.getPressedKey());
        return description;
    }
    /**
     * get method returns currency
     * pre: none
     * post: currency updated and returned
     */
    public int getCurrency() {
        return currency;
    }
    /**
     * updates the currency in this class from another class
     * pre: none
     * post: currency in this class is updated
     */
    public void setCurrency(int currency) {
        this.currency = currency;
    }
}