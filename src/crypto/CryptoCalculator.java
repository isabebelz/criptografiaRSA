package crypto;

import java.math.BigInteger;

public class CryptoCalculator {

    public static String[] encrypt(KeyPairGenerator keyPair, String[] blocks)  {

        String[] encryptedText = new String[blocks.length];

        for (String block : blocks) {

            BigInteger m = new BigInteger(block);

            BigInteger c = m.modPow(keyPair.getE(), keyPair.getN());

            for(int i = 0; i < blocks.length; i++) {
                encryptedText[i] = String.valueOf(c);
            }

        }

        return encryptedText;

    }


    public static String decrypt(KeyPairGenerator keyPair, String[] encryptedText) {


        StringBuilder decryptedText = new StringBuilder();

        for (String s : encryptedText) {

            BigInteger encryptedBlock = new BigInteger(s);

            BigInteger m = encryptedBlock.modPow(keyPair.getD(), keyPair.getN());

            decryptedText.append((char) m.intValue());

        }


        return decryptedText.toString();
    }


}
