package Swing;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Sound {

        public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

            Scanner scanner = new Scanner(System.in);

            File file = new File("mixkit-achievement-bell-600 (1).wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();
            String response = scanner.next();
        }
    }

