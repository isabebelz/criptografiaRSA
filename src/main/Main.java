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

        String[] preCode = PreCode.preCodeASCII(sc.nextLine());

        System.out.println(Arrays.toString(preCode));

        //List<String> blocks = PreCode.addPaddingDivideBlocks(preCode);

        //System.out.println(blocks);

        KeyPairGenerator keyPair = new KeyPairGenerator();

        String[] encryptedText = CryptoCalculator.encrypt(keyPair, preCode);

        System.out.println(Arrays.toString(encryptedText));

        String decryptedText = CryptoCalculator.decrypt(keyPair, encryptedText);

        System.out.println(decryptedText);

        sc.close();

    }
}