package crypto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CryptoCalculator {

    public static List<String> encrypt(KeyPairGenerator keyPair, String[] preCode)  {

        List<String> encryptedText = new ArrayList<>();

        for (String block : preCode) {

            BigInteger m = new BigInteger(block);

            BigInteger c = m.modPow(keyPair.getE(), keyPair.getN());

            encryptedText.add(String.valueOf(c));


        }

        return encryptedText;

    }


    public static String decrypt(KeyPairGenerator keyPair, List<String> encryptedText) {


        StringBuilder decryptedText = new StringBuilder();

        for (String s : encryptedText) {

            BigInteger encryptedBlock = new BigInteger(s);

            BigInteger m = encryptedBlock.modPow(keyPair.getD(), keyPair.getN());

            decryptedText.append((char) m.intValue());

        }


        return decryptedText.toString();
    }


}
