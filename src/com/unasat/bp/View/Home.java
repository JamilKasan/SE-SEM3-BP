package com.unasat.bp.View;
import javax.swing.*;
import com.unasat.bp.Morse
import com.unasat.bp.Text
import java.awt.*;
import java.awt.event.*;
import com.unasat.bp.Classes.Morse;

public class Home extends JFrame {
    private JTextField morseCodeField;
    private JTextArea decodedStringArea;
    private JButton convertButton;
    private JButton swapButton;
    private JButton clearButton;

    public Home() {
        setTitle("Morse Code Converter");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        morseCodeField = new JTextField();
        decodedStringArea = new JTextArea();
        decodedStringArea.setEditable(false);
        decodedStringArea.setFont(new Font("Arial", Font.PLAIN, 14));
        
        convertButton = new JButton("Convert");
        convertButton.setBackground(new Color(0, 153, 255));
        convertButton.setForeground(Color.WHITE);
        convertButton.setFocusPainted(false);

        swapButton = new JButton("Swap");
        swapButton.setBackground(new Color(0, 153, 255));
        swapButton.setForeground(Color.WHITE);
        swapButton.setFocusPainted(false);

        clearButton = new JButton("Clear"); 
        clearButton.setBackground(new Color(0, 153, 255));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Enter Morse Code:"), BorderLayout.NORTH);
        inputPanel.add(morseCodeField, BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 5, 5)); 
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(convertButton);
        buttonPanel.add(swapButton);
        buttonPanel.add(clearButton);

        inputPanel.add(buttonPanel, BorderLayout.EAST); 

         JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBackground(Color.WHITE);
        outputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        outputPanel.add(new JLabel("Result:"), BorderLayout.NORTH);
        outputPanel.add(decodedStringArea, BorderLayout.CENTER);

         JScrollPane scrollPane = new JScrollPane(outputPanel);

        JScrollPane scrollPane = new JScrollPane(decodedStringArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String inputText = morseCodeField.getText();
                String morseCode = Text.toMorse(inputText);
                decodedStringArea.setText(morseCode);
            }
        });
    
  swapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String temp = morseCodeField.getText();
                morseCodeField.setText(decodedStringArea.getText());
                decodedStringArea.setText(temp);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                morseCodeField.setText("");
                decodedStringArea.setText("");
            }
        });
    }     
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                Home converterGUI = new Home();
                converterGUI.setVisible(true);
            }
        });
    }
}
