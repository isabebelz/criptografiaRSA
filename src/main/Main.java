package main;


import crypto.CryptoCalculator;
import crypto.KeyPairGenerator;
import precode.PreCode;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String preCode = PreCode.preCodeASCII(sc.nextLine());

        System.out.println(preCode);

        List<String> blocks = PreCode.addPaddingDivideBlocks(preCode);

        System.out.println(blocks);

        CryptoCalculator cryptoCalculator = new CryptoCalculator();

        KeyPairGenerator keyPair = new KeyPairGenerator();

        String encryptedText = cryptoCalculator.encrypt(keyPair, blocks);

        System.out.println(encryptedText);

        sc.close();

    }
}