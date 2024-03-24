package com.unasat.bp.Classes;

public class MorseToText {
    // Method to convert Morse code to text
    public static String toText(String morseCode) {
        StringBuilder text = new StringBuilder();
        String[] words = morseCode.split(" / ");
        for (String word : words) {
            String[] letters = word.trim().split(" ");
            for (String letter : letters) {
                if (Morse.reverseCodeMap.containsKey(letter)) {
                    // Append corresponding character for Morse code
                    text.append(Morse.reverseCodeMap.get(letter));
                }
            }
            // Append space between words
            text.append(" ");
        }
        return text.toString().trim();
    }
    public static void main(String[] args) {
        // Translate Morse code to text
        String inputMorse = ".... . .-.. .-.. --- / .-- --- .-. .-.. -..";
        String decodedText = MorseToText.toText(inputMorse);
        System.out.println("Morse Code to Text:");
        System.out.println(inputMorse + " -> " + decodedText);
    }
}


