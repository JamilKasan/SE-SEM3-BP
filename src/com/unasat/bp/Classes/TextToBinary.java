package com.unasat.bp.Classes;

public class TextToBinary {

    // Convert text string to binary string
    public String textToBinary(String text) {
        StringBuilder binaryStringBuilder = new StringBuilder();
        for (char character : text.toCharArray()) {
            String binaryString = Integer.toBinaryString(character);
            // Ensure each binary string is 8 characters long by adding leading zeros if necessary
            String paddedBinaryString = String.format("%8s", binaryString).replace(' ', '0');
            binaryStringBuilder.append(paddedBinaryString);
        }
        return binaryStringBuilder.toString();
    }

}
