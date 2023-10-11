package crypto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CryptoCalculator {

    public static String encrypt(KeyPairGenerator keyPair, List<String> blocks)  {

        List<String> encryptedText = new ArrayList<>();

        for (String block : blocks) {

            BigInteger m = new BigInteger(block);

            BigInteger c = m.modPow(keyPair.getE(), keyPair.getN());

            encryptedText.add(String.valueOf(c));
        }

        return encryptedText.toString();

    }





}
