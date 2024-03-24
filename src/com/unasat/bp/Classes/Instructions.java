package com.unasat.bp.Classes;

public class Instructions {
    public static void main(String[] args) {
        printUsageInstructions();
        printExampleMessage();
        Instructions translator = new Instructions();
        translator.usageInstructions();
    }

    private void usageInstructions() {
        System.out.println("Usage Instructions:");
        System.out.println("1. Create an instance of TextToMorse or MorseToText.");
        System.out.println("2. Call the corresponding method (toMorse or toText) with your message as argument.");
        System.out.println("3. The translated message will be returned.");
        System.out.println();
    }

    private static void printUsageInstructions() {
        System.out.println("Welcome to the Morse Code Translator!");
        System.out.println("This program allows you to convert text messages to Morse code and vice versa.");
        System.out.println("Follow the instructions below to use this translator:");
        System.out.println("1. Create an instance of TextToMorse or MorseToText.");
        System.out.println("2. Call the corresponding method (toMorse or toText) with your message as argument.");
        System.out.println("3. The translated message will be returned.");
        System.out.println();
    }

    private static void printExampleMessage() {
        System.out.println("Example:");
        System.out.println("Input: 'HELLO WORLD'");
        System.out.println("Output: '.... . .-.. .-.. --- / .-- --- .-. .-.. -..'");
        System.out.println();
    }
}

