package main;

import crypto.CryptoCalculator;
import crypto.KeyPairGenerator;
import precode.PreCode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * A classe Main é responsável pela interação com o usuário e demonstra a funcionalidade do sistema de criptografia RSA.
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma mensagem: ");

        // Pré-codificando a mensagem de entrada em formato ASCII
        String[] preCode = PreCode.preCodeASCII(sc.nextLine());

        System.out.println("Mensagem pré-codificada em ASCII: " + Arrays.toString(preCode));

        // Gerando um par de chaves RSA
        KeyPairGenerator keyPair = new KeyPairGenerator();

        System.out.println();
        System.out.println("Detalhes do par de chaves gerado:");
        System.out.println("p: " + keyPair.getP());
        System.out.println("q: " + keyPair.getQ());
        System.out.println("n: " + keyPair.getN());
        System.out.println("phi(n): " + keyPair.getPhiN());
        System.out.println("e: " + keyPair.getE());
        System.out.println("d: " + keyPair.getD());

        // Criptografando a mensagem pré-codificada
        List<String> encryptedText = CryptoCalculator.encrypt(keyPair, preCode);

        System.out.println();
        System.out.println("Mensagem criptografada:");
        System.out.println(encryptedText);

        // Descriptografando a mensagem criptografada
        String decryptedText = CryptoCalculator.decrypt(keyPair, encryptedText);

        System.out.println();
        System.out.println("Mensagem descriptografada: " + decryptedText);

        sc.close();
    }
}
