/**
 * story class that displays the graphics/storyline
 */
public class Story {
    /**
     * run method that starts the entire game
     * pre: none
     * post: game features and functionalities are displayed
     */
    public void run() {
        Conditions condition = new Conditions();
        System.out.println("\n" + condition.getScenario()); // prints randomly generated scenario
    }
}