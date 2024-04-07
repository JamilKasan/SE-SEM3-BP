package com.unasat.bp.Tests;

import com.unasat.bp.Requirements;
import com.unasat.bp.View.ConverterApp;

public class TestConverterApp {
 
        public static void main(String[] args) {
            Requirements requirements = new ConverterApp();

            String[] groupMembers = requirements.groepsleden();
            assertValue(groupMembers != null, "Group members array should not be null");
            assertValue(groupMembers.length > 0, "Group members array should not be empty");

            char inputChar = 'A';
            String morseCode = requirements.abs2morse(inputChar);
            assertValue(morseCode != null, "Morse code should not be null");
            assertValue(!morseCode.isEmpty(), "Morse code should not be empty");

            // Test morse2abc() method
            String inputMorse = ".... . .-.. .-.. ---  .-- --- .-. .-.. -..";
            char character = requirements.morse2abc(inputMorse);
            assertValue(character != '\u0000', "Character should not be null");

            // Test exampleMorseCode() method
            String exampleMorseCode = requirements.exampleMorseCode();
            assertValue(exampleMorseCode != null, "Example Morse code should not be null");
            assertValue(!exampleMorseCode.isEmpty(), "Example Morse code should not be empty");

            // Test exampleString() method
            String exampleString = requirements.exampleString();
            assertValue(exampleString != null, "Example string should not be null");
            assertValue(!exampleString.isEmpty(), "Example string should not be empty");

            // Test explain() method
            String explanation = requirements.explain();
            assertValue(explanation != null, "Explanation should not be null");
            assertValue(!explanation.isEmpty(), "Explanation should not be empty");

            System.out.println("All tests passed successfully!");
        }

        private static void assertValue(boolean condition, String message) {
            assert condition : message;
        }

        private static void assertBoolean(boolean condition, String message) {
            assert condition : message;
        }
    

}
