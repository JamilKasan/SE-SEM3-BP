package com.unasat.bp.Classes;

public class TextToMorse {
    // Method to convert text to Morse code
    public static String toMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (c == ' ') {
                // Append space separator for words
                morseCode.append(" / ");
            } else if (Morse.codeMap.containsKey(c)) {
                // Append Morse code for characters
                morseCode.append(Morse.codeMap.get(c)).append(" ");
            }
        }
        return morseCode.toString().trim();
    }
    public static void main(String[] args) {
        // Translate text to Morse code
        String inputText = "Hello World";
        String morseCode = TextToMorse.toMorse(inputText);
        System.out.println("Text to Morse Code:");
        System.out.println(inputText + " -> " + morseCode);
    }
}


