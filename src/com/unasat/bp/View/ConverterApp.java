package com.unasat.bp.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConverterApp extends JFrame {
    private JPanel contentPane;
    private CardLayout cardLayout;

    public ConverterApp() {
        setTitle("Java Swing Converter App");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create content pane with CardLayout
        contentPane = new JPanel();
        cardLayout = new CardLayout();
        contentPane.setLayout(cardLayout);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        // Create Edit menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        menuBar.add(editMenu);

        // Create View menu
        JMenu viewMenu = new JMenu("View");
        JMenuItem zoomInMenuItem = new JMenuItem("Zoom In");
        JMenuItem zoomOutMenuItem = new JMenuItem("Zoom Out");
        viewMenu.add(zoomInMenuItem);
        viewMenu.add(zoomOutMenuItem);
        menuBar.add(viewMenu);

        // Create Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ConverterApp.this, "This is an example Java Swing application.", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        helpMenu.add(aboutMenuItem);
        menuBar.add(helpMenu);

        // Create Converter Home page
        JPanel homePanel = new JPanel(new GridLayout(0, 1, 10, 10));
        JButton morseToTextButton = createButton("Morse to Text");
        JButton textToMorseButton = createButton("Text to Morse");
        JButton textToBinaryButton = createButton("Text to Binary");

        morseToTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "MorseToText");
            }
        });

        textToMorseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "TextToMorse");
            }
        });

        textToBinaryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "TextToBinary");
            }
        });

        homePanel.add(morseToTextButton);
        homePanel.add(textToMorseButton);
        homePanel.add(textToBinaryButton);

        contentPane.add(homePanel, "Home");

        // Create Morse to Text page
        JPanel morseToTextPanel = createConversionPanel("Morse to Text Converter", "Morse Input:", "Result:");
        JTextField morseInput = createInputField();
        JTextField morseOutput = createOutputField();
        JButton convertMorseToTextButton = createConvertButton("Convert");
        JButton exampleButton1 = createExampleButton();

        convertMorseToTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement conversion logic here
            }
        });

        morseToTextPanel.add(morseInput);
        morseToTextPanel.add(morseOutput);
        morseToTextPanel.add(convertMorseToTextButton);
        morseToTextPanel.add(exampleButton1);
        JButton backButton1 = createBackButton();
        backButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Home");
            }
        });
        morseToTextPanel.add(backButton1);

        contentPane.add(morseToTextPanel, "MorseToText");

        // Create Text to Morse page
        JPanel textToMorsePanel = createConversionPanel("Text to Morse Converter", "Text Input:", "Result:");
        JTextField textInput = createInputField();
        JTextField textOutput = createOutputField();
        JButton convertTextToMorseButton = createConvertButton("Convert");
        JButton exampleButton2 = createExampleButton();

        convertTextToMorseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement conversion logic here
            }
        });

        textToMorsePanel.add(textInput);
        textToMorsePanel.add(textOutput);
        textToMorsePanel.add(convertTextToMorseButton);
        textToMorsePanel.add(exampleButton2);
        JButton backButton2 = createBackButton();
        backButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Home");
            }
        });
        textToMorsePanel.add(backButton2);

        contentPane.add(textToMorsePanel, "TextToMorse");

        // Create Text to Binary page
        JPanel textToBinaryPanel = createConversionPanel("Text to Binary Converter", "Text Input:", "Result:");
        JTextField textBinaryInput = createInputField();
        JTextField binaryOutput = createOutputField();
        JButton convertTextToBinaryButton = createConvertButton("Convert");
        JButton exampleButton3 = createExampleButton();

        convertTextToBinaryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement conversion logic here
            }
        });

        textToBinaryPanel.add(textBinaryInput);
        textToBinaryPanel.add(binaryOutput);
        textToBinaryPanel.add(convertTextToBinaryButton);
        textToBinaryPanel.add(exampleButton3);
        JButton backButton3 = createBackButton();
        backButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Home");
            }
        });
        textToBinaryPanel.add(backButton3);

        contentPane.add(textToBinaryPanel, "TextToBinary");

        // Set menu bar
        setJMenuBar(menuBar);

        // Set content pane
        setContentPane(contentPane);

        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(Color.LIGHT_GRAY);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return button;
    }

    private JPanel createConversionPanel(String title, String inputLabel, String outputLabel) {
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel);

        JLabel inputTextLabel = new JLabel(inputLabel);
        inputTextLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(inputTextLabel);

        JLabel outputTextLabel = new JLabel(outputLabel);
        outputTextLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(outputTextLabel);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return panel;
    }

    private JTextField createInputField() {
        JTextField textField = new JTextField(15);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        return textField;
    }

    private JTextField createOutputField() {
        JTextField textField = new JTextField(15);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setEditable(false);
        return textField;
    }

    private JButton createConvertButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }

    private JButton createBackButton() {
        JButton button = new JButton("Back");
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }

    private JButton createExampleButton() {
        JButton button = new JButton("Example");
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }

}
