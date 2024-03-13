package com.unasat.bp.View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.unasat.bp.Classes.Morse;

public class Home extends JFrame {
    private JTextField morseCodeField;
    private JTextArea decodedStringArea;
    private JButton convertButton;

    public Home() {
        setTitle("Morse Code Converter");
        setSize(400, 200);
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

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Enter Morse Code:"), BorderLayout.NORTH);
        inputPanel.add(morseCodeField, BorderLayout.CENTER);
        inputPanel.add(convertButton, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(decodedStringArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String morseCode = morseCodeField.getText();
                String decodedString = Morse.toString(morseCode);
                decodedStringArea.setText(decodedString);
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
