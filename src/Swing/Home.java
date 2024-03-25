package Swing;
import com.unasat.bp.Classes.Instructions;
import com.unasat.bp.Classes.Text;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serial;


public class Home extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final JTextField morseCodeField;
    private final JTextArea decodedStringArea;

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

        JButton convertButton = new JButton("Convert");
        convertButton.setBackground(new Color(0, 153, 255));
        convertButton.setForeground(Color.WHITE);
        convertButton.setFocusPainted(false);

        JButton swapButton = new JButton("Swap");
        swapButton.setBackground(new Color(0, 153, 255));
        swapButton.setForeground(Color.WHITE);
        swapButton.setFocusPainted(false);

        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(0, 153, 255));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);

        JButton instructionsButton = new JButton ("Instructions");
        instructionsButton.setBackground(new Color (0, 153, 255));
        instructionsButton.setForeground(Color.WHITE);
        instructionsButton.setFocusPainted(false);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Enter Morse Code:"), BorderLayout.NORTH);
        inputPanel.add(morseCodeField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 5, (int) 5.));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(convertButton);
        buttonPanel.add(swapButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(instructionsButton);

        inputPanel.add(buttonPanel, BorderLayout.EAST);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBackground(Color.WHITE);
        outputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        outputPanel.add(new JLabel("Result:"), BorderLayout.NORTH);
        outputPanel.add(decodedStringArea, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(outputPanel);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        convertButton.addActionListener(e -> {
            String inputText = morseCodeField.getText();
            String morseCode = Text.toMorse(inputText);
            decodedStringArea.setText(morseCode);

            try {
                File file = new File("mixkit-achievement-bell-600 (1).wav");
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        swapButton.addActionListener(e -> {
            String temp = morseCodeField.getText();
            morseCodeField.setText(decodedStringArea.getText());
            decodedStringArea.setText(temp);
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                morseCodeField.setText("");
                decodedStringArea.setText("");
            }
        });
        instructionsButton.addActionListener(e -> {
            Instructions.printUsageInstructions();
            Instructions.printExampleMessage();
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

    private static void actionPerformed(ActionEvent e) {
        Instructions.printUsageInstructions();
    }
}
