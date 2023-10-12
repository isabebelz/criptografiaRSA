package main;


import crypto.CryptoCalculator;
import crypto.KeyPairGenerator;
import precode.PreCode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("type a message baitola");

        String[] preCode = PreCode.preCodeASCII(sc.nextLine());

        System.out.println(Arrays.toString(preCode));

        KeyPairGenerator keyPair = new KeyPairGenerator();

        List<String> encryptedText = CryptoCalculator.encrypt(keyPair, preCode);

        System.out.println();

        System.out.println("p: " + keyPair.getP());
        System.out.println("q: " + keyPair.getQ());
        System.out.println("n: " + keyPair.getN());
        System.out.println("phi(n): " + keyPair.getPhiN());
        System.out.println("e: " + keyPair.getE());
        System.out.println("d: " + keyPair.getD());

        System.out.println();

        System.out.println((encryptedText));

        String decryptedText = CryptoCalculator.decrypt(keyPair, encryptedText);

        System.out.println();

        System.out.println(decryptedText);

        sc.close();

    }
}