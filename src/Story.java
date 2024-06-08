/**
 * story class that displays the graphics/storyline
 */
public class Story {
    private String graphic = ""; // sets a private string for the ascii art graphic
    /**
     * constructor
     * pre: none
     * post: storyline is run
     */
    public Story() { // autoruns stuff at the beginning (prints or sets variables of storyline)
        // introductory scenes
        System.out.println("Welcome to Mind-Mart!"); 
    }
    /**
     * art method that returns a random ascii character
     * pre: none
     * post: graphic variable is returned
     */
    public String art(int index) {
        switch (index) {
            case 1:
                graphic = String.format("%8s\n%8s\n%10s\n", "/\\___/\\", "( =^.^= )", "(\") (\")_/");
                break;
            case 2:
                graphic = String.format("%7s\n%s\n%s\n","(\\___/)", "(' x ')", "c(\")(\")");
                break;
            case 3:
                graphic = String.format("%6s\n%s\n%s\n", "^---^", "( `o´ )", "( u u )");
                break;
            case 4:
                graphic = String.format("%7s\n%8s\n%s\n%6s\n", "_____", "(` v ´)", "((_____))", "^ ^");
                break;
        }
        return graphic;
    }
}