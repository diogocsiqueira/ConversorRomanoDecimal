package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Screenn extends JFrame {

    RomanConverterInterface romanConverter = new RomanConverter();

    public Screenn() {
        setTitle("Conversor Romano");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JPanel romanToDecimalPanel = createPanel(
                mainPanel, cardLayout, "Conversor de Romano para Decimal", "Digite o número romano:",
                "Ir para Decimal → Romano", true);

        JPanel decimalToRomanPanel = createPanel(mainPanel, cardLayout,
                "Conversor de Decimal para Romano", "Digite o número decimal:",
                "Voltar para Romano → Decimal", false);

        mainPanel.add(romanToDecimalPanel, "RomanToDecimal");
        mainPanel.add(decimalToRomanPanel, "DecimalToRoman");
        add(mainPanel);
        setVisible(true);

    }

    private JPanel createPanel(JPanel mainPanel, CardLayout cardLayout, String title, String input, String button, boolean isRomanToDecimal){
        JPanel panel = new JPanel(null);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(100, 20, 500, 30);
        panel.add(titleLabel);

        JLabel inputLabel = new JLabel(input);
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        inputLabel.setBounds(50, 100, 200, 30);
        panel.add(inputLabel);

        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setBounds(250, 100, 150, 30);
        panel.add(textField);

        JLabel resultLabel = new JLabel("Resultado:");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel.setBounds(50, 150, 200, 30);
        panel.add(resultLabel);

        JLabel resultDisplay = new JLabel("Aguardando entrada...");
        resultDisplay.setFont(new Font("Arial", Font.BOLD, 16));
        resultDisplay.setBounds(250, 150, 300, 30);
        panel.add(resultDisplay);

        JButton switchButton = new JButton(button);
        switchButton.setBounds(200, 250, 200, 40);
        switchButton.addActionListener(e -> cardLayout.show(mainPanel, isRomanToDecimal ?  "DecimalToRoman" : "RomanToDecimal"));
        panel.add(switchButton);

        Timer timer = new Timer(500, (ActionEvent e) -> {
            String inputText = textField.getText();
            try {
                if (isRomanToDecimal) {
                    int numberConverted = romanConverter.romanToDecimal(inputText);
                    resultDisplay.setText(inputText + " = " + numberConverted);
                } else {
                    int decimalCode = Integer.parseInt(inputText);
                    String romanCode = romanConverter.decimalToRoman(decimalCode);
                    resultDisplay.setText(inputText + " = " + romanCode);
                }
            } catch (Exception ex) {
                resultDisplay.setText("Entrada inválida!");
            }
        });
        timer.start();

        return panel;
    }
}

