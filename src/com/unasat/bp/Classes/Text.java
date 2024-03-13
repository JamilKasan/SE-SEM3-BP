package com.unasat.bp.Classes;

import java.util.HashMap;

public class Text {
    // Character to Morse code mapping
    private static final HashMap<Character, String> textToMorseMap = new HashMap<>();

    static {
        textToMorseMap.put('A', ".-");
        textToMorseMap.put('B', "-...");
        textToMorseMap.put('C', "-.-.");
        textToMorseMap.put('D', "-..");
        textToMorseMap.put('E', ".");
        textToMorseMap.put('F', "..-.");
        textToMorseMap.put('G', "--.");
        textToMorseMap.put('H', "....");
        textToMorseMap.put('I', "..");
        textToMorseMap.put('J', ".---");
        textToMorseMap.put('K', "-.-");
        textToMorseMap.put('L', ".-..");
        textToMorseMap.put('M', "--");
        textToMorseMap.put('N', "-.");
        textToMorseMap.put('O', "---");
        textToMorseMap.put('P', ".--.");
        textToMorseMap.put('Q', "--.-");
        textToMorseMap.put('R', ".-.");
        textToMorseMap.put('S', "...");
        textToMorseMap.put('T', "-");
        textToMorseMap.put('U', "..-");
        textToMorseMap.put('V', "...-");
        textToMorseMap.put('W', ".--");
        textToMorseMap.put('X', "-..-");
        textToMorseMap.put('Y', "-.--");
        textToMorseMap.put('Z', "--..");
        textToMorseMap.put('0', "-----");
        textToMorseMap.put('1', ".----");
        textToMorseMap.put('2', "..---");
        textToMorseMap.put('3', "...--");
        textToMorseMap.put('4', "....-");
        textToMorseMap.put('5', ".....");
        textToMorseMap.put('6', "-....");
        textToMorseMap.put('7', "--...");
        textToMorseMap.put('8', "---..");
        textToMorseMap.put('9', "----.");
        textToMorseMap.put('.', ".-.-.-");
        textToMorseMap.put(',', "--..--");
    }

    public static String toMorse(String text) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (textToMorseMap.containsKey(c)) {
                result.append(textToMorseMap.get(c)).append(" ");
            } else if (c == ' ') {
                result.append(" ");
            }
        }
        return result.toString().trim(); // Trim any leading or trailing spaces
    }
}
