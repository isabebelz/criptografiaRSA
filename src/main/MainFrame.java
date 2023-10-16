package main;

import crypto.CryptoCalculator;
import crypto.KeyPairGenerator;
import precode.PreCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {
    private final JTextField inputTextField;
    private final JTextArea outputTextArea;
    private final KeyPairGenerator keyPair;
    private final JPasswordField passwordField;
    private final JButton showPrivateKeyButton;
    private final JButton encryptButton;
    private final JButton decryptButton;

    private String correctPassword;
    private boolean passwordVerified = false;

    public MainFrame() {

        String savedPassword = null;

        // Solicita a senha ao usuário no início do programa
        do {
            correctPassword = JOptionPane.showInputDialog("Digite a senha desejada:");

            if (correctPassword == null) {
                // O usuário pressionou "Cancelar", portanto, saia do programa
                System.exit(0);
            } else if (correctPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Senha não pode ser vazia.");
            } else {
                savedPassword = correctPassword; // Armazena a senha
            }

        } while (correctPassword.isEmpty());

        keyPair = new KeyPairGenerator();

        setTitle("Criptografia RSA");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel inputLabel = new JLabel("Digite uma mensagem:");
        inputTextField = new JTextField(20);
        encryptButton = new JButton("Criptografar");
        decryptButton = new JButton("Descriptografar");

        inputPanel.add(inputLabel);
        inputPanel.add(inputTextField);
        inputPanel.add(encryptButton);
        inputPanel.add(decryptButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        JPanel keyInfoPanel = new JPanel();
        keyInfoPanel.setLayout(new GridLayout(6, 2));

        JLabel nLabel = new JLabel("n: " + keyPair.getN());
        JLabel eLabel = new JLabel("e: " + keyPair.getE());
        JLabel dLabel = new JLabel("d: *** (senha necessária)");

        keyInfoPanel.add(new JLabel("Modulo de criptografia n"));
        keyInfoPanel.add(nLabel);
        keyInfoPanel.add(new JLabel("Chave pública e"));
        keyInfoPanel.add(eLabel);


        keyInfoPanel.add(dLabel);

        mainPanel.add(keyInfoPanel, BorderLayout.CENTER);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout());

        passwordField = new JPasswordField(10);
        showPrivateKeyButton = new JButton("Mostrar Chave Privada");

        passwordPanel.add(passwordField);
        passwordPanel.add(showPrivateKeyButton);

        mainPanel.add(passwordPanel, BorderLayout.SOUTH);

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputTextField.getText();
                String[] preCode = PreCode.preCodeASCII(inputText);
                List<String> encryptedText = CryptoCalculator.encrypt(keyPair, preCode);
                String decryptedText = CryptoCalculator.decrypt(keyPair, encryptedText);
                outputTextArea.setText("Mensagem Criptografada:\n" + encryptedText + "\n\nMensagem Descriptografada:\n" + decryptedText);
            }
        });

        String finalSavedPassword = savedPassword;
        showPrivateKeyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] password = passwordField.getPassword();
                String enteredPassword = new String(password);
                if (enteredPassword.equals(finalSavedPassword)) {
                    dLabel.setText("d: " + keyPair.getD());
                    passwordVerified = true; // Define a senha como verificada
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this, "Senha incorreta. Acesso negado.");
                }
                // Limpa o campo de senha
                passwordField.setText("");
            }
        });

        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);
        mainPanel.add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

        add(mainPanel);
    }
}






