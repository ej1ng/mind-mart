/**
 * mind-mart: a mental health education game
 */
import java.util.Scanner;
import java.util.Random;

class Main {
    public static void main (String[] args) {
        Story storyline = new Story(); // storyline object created (methods related to storyline, generating ascii art, etc.)
        Random random = new Random(); // random object created to generate random elements

        int index = random.nextInt(4) + 1; // index variable generates random number between 1-4
        String graphic = storyline.art(index); // sets graphic variable to random ascii character using the art method

        System.out.print(graphic); // displays out character generated
    }
}