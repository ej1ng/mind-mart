/**
 * mind-mart: a mental health education game
 */
import java.util.Scanner;
import java.util.Random;

import javax.swing.*;
import java.net.URL;

class Main {
    public static void main (String[] args) {
        Story storyline = new Story(); // storyline object created (methods related to storyline, generating ascii art, etc.)

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Mind Mart");

        Display display = new Display();
        frame.add(display);

        frame.setSize(display.width,display.height);
        frame.setLayout(null);

        URL bg = Main.class.getResource("/resources/background/placeholderbg.png");
        JLabel bgDisplay = new JLabel("",new ImageIcon(bg),JLabel.CENTER);
        bgDisplay.setSize(display.width,display.height);
        bgDisplay.setBounds(0,0,display.width,display.height);

        frame.add(bgDisplay);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }
}