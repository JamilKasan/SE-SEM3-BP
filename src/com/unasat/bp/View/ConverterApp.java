package com.unasat.bp.View;

import com.unasat.bp.Classes.MorseToText;
import com.unasat.bp.Classes.TextToBinary;
import com.unasat.bp.Classes.TextToMorse;
import com.unasat.bp.Requirements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ConverterApp extends JFrame implements Requirements {
    private String currentPage;
    private JPanel contentPane;
    private CardLayout cardLayout;
    JTextField textInput = createInputField();
    JTextField textOutput = createOutputField();
    JTextField morseInput = createInputField();
    JTextField morseOutput = createOutputField();
    JTextField textBinaryInput = createInputField();
    JTextField binaryOutput = createOutputField();


    @Override
    public String[] groepsleden() {
        return new String[]{"Yaish Kedah", "Nikhil", "Peter", "Jamil Kasan", "Peter Shakison"};
    }

    @Override
    public String abs2morse(char inputChar) {
        String value = textInput.getText();
        TextToMorse text = new TextToMorse();
        String results = text.convertChar(inputChar);
        return results;
    }

    @Override
    public char morse2abc(String inputString) {
        MorseToText morse = new MorseToText();
        char results = morse.convertChar(inputString);
        return results;
    }

    @Override
    public void convert() {
        String value = textInput.getText();
        TextToMorse text = new TextToMorse();
        String results = text.convert(value);
        textOutput.setText(results);
        System.out.println("results");


        String valueMorse = morseInput.getText();
        MorseToText morse = new MorseToText();
        String result2 = morse.convert(valueMorse);
        morseOutput.setText(result2);
        System.out.println("result2");

        String valueBinary = textBinaryInput.getText();
        TextToBinary binary = new TextToBinary();
        String resultBinary = binary.textToBinary(valueBinary);
        binaryOutput.setText(resultBinary);
        System.out.println("resultBinary");

    }

    @Override
    public void swap() {
        if (currentPage == "MorseToText")
        {
            currentPage = "TextToMorse";
            cardLayout.show(contentPane, "TextToMorse");
            System.out.println(currentPage);

        }
        else
        {
            currentPage = "MorseToText";
            cardLayout.show(contentPane, currentPage);
            System.out.println(currentPage);


        }
    }

    @Override
    public void clear() {
         textInput.setText("");
         textOutput.setText("");
         morseInput.setText("");
         morseOutput.setText("");
         textBinaryInput.setText("");
         binaryOutput.setText("");
    }

    @Override
    public String exampleMorseCode() {

         return ".... . .-.. .-.. ---  .-- --- .-. .-.. -..";
    }

    @Override
    public String exampleString() {
         return "Hello World";
    }

    @Override
    public String explain() {
        return "1. Voeg een tekstbestand toe door op de 'Bestand toevoegen' knop te klikken.\n\n" +
                "2. Selecteer het gewenste conversietype (bijvoorbeeld 'Tekst naar Morse' of 'Morse naar Tekst').\n\n" +
                "3. Klik op de 'Converteren' knop om de conversie uit te voeren.\n\n" +
                "4. Het resultaat wordt weergegeven in het uitvoerveld of kan worden opgeslagen door op 'Opslaan' te klikken.";
    }


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
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        // Create Edit menu

        // Create View menu
        JMenu organizationMenu = new JMenu("Organization");
        JMenuItem membersMenuItem = new JMenuItem("Members");
        membersMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ConverterApp.this, "Members of the organization: " + String.join(", ", groepsleden()), "Organization Members", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        organizationMenu.add(membersMenuItem);
        menuBar.add(organizationMenu);


        // Create Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("Instructions");
        aboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ConverterApp.this, explain()
                        , "Tutorial", JOptionPane.INFORMATION_MESSAGE);
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
                currentPage = "MorseToText";
                cardLayout.show(contentPane, currentPage);
            }
        });

        textToMorseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPage = "TextToMorse";
                cardLayout.show(contentPane, currentPage);
            }
        });

        textToBinaryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPage = "TextToBinary";
                cardLayout.show(contentPane, currentPage);
            }
        });

        homePanel.add(morseToTextButton);
        homePanel.add(textToMorseButton);
        homePanel.add(textToBinaryButton);

        contentPane.add(homePanel, "Home");

        // Create Morse to Text page
        JPanel morseToTextPanel = createConversionPanel("Morse to Text Converter", "Morse Input:", "Result:");

        JButton convertMorseToTextButton = createConvertButton("Convert");
        JButton swapMorseToText = createConvertButton("Swap");
        JButton morseExampleButton = createExampleButton();

        convertMorseToTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        morseExampleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String exampleMorse = exampleMorseCode();
                morseInput.setText(exampleMorse);
                convert();
            }
        });

        swapMorseToText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                swap();
//                System.out.println(currentPage);
            }
        });

        morseToTextPanel.add(morseInput);
        morseToTextPanel.add(morseOutput);
        morseToTextPanel.add(convertMorseToTextButton);
        morseToTextPanel.add(morseExampleButton);
        morseToTextPanel.add(swapMorseToText);
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

        JButton convertTextToMorseButton = createConvertButton("Convert");
        JButton swapTextToMorse = createConvertButton("Swap");
        JButton textExampleButton = createExampleButton();

        convertTextToMorseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        textExampleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String exampleText = exampleString();
                textInput.setText(exampleText);
                convert();
            }
        });

        swapTextToMorse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                swap();
            }
        });

        textToMorsePanel.add(textInput);
        textToMorsePanel.add(textOutput);
        textToMorsePanel.add(convertTextToMorseButton);
        textToMorsePanel.add(textExampleButton);
        textToMorsePanel.add(swapTextToMorse);
        JButton backButton2 = createBackButton();
        backButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentPage = "Home";
                cardLayout.show(contentPane, currentPage);
            }
        });
        textToMorsePanel.add(backButton2);

        contentPane.add(textToMorsePanel, "TextToMorse");

        // Create Text to Binary page
        JPanel textToBinaryPanel = createConversionPanel("Text to Binary Converter", "Text Input:", "Result:");

        JButton convertTextToBinaryButton = createConvertButton("Convert");
        JButton BinaryExampleButton = createExampleButton();

        convertTextToBinaryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        BinaryExampleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String exampleBinaryText = "Hello World";
                textBinaryInput.setText(exampleBinaryText);
                TextToBinary binary = new TextToBinary();
                String result = binary.textToBinary(exampleBinaryText);
                binaryOutput.setText(result);
            }
        });

        textToBinaryPanel.add(textBinaryInput);
        textToBinaryPanel.add(binaryOutput);
        textToBinaryPanel.add(convertTextToBinaryButton);
        textToBinaryPanel.add(BinaryExampleButton);
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
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ConverterApp();
            }
        });

    }
}
