package com.unasat.bp.Classes;

public class TextToBinary {

    public String textToBinary(String text) {
        byte[] bytes = text.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes)
        {
            int val = b;
            for (int i = 0; i < 8; i++)
            {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            binary.append(' ');
        }
        return binary.toString();
//        StringBuilder binaryStringBuilder = new StringBuilder();
//        for (char character : text.toCharArray()) {
//            String binaryString = Integer.toBinaryString(character);
//            String paddedBinaryString = String.format("%8s", binaryString).replace(' ', '0');
//            binaryStringBuilder.append(paddedBinaryString);
//        }
//        return binaryStringBuilder.toString();
    }

}
