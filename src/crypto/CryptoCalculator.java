package crypto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CryptoCalculator {
    public final String encrypt(KeyPairGenerator keyPair, List<String> blocks)  {

        List<String> encryptedText = new ArrayList<>();

        for (String block : blocks) {

            BigInteger m = BigInteger.valueOf(Integer.parseInt(block));

            BigInteger c = m.modPow(keyPair.getE(), keyPair.getN());

            String cString = c.toString();

            encryptedText.add(String.valueOf(c));
        }

        return encryptedText.toString();

    }



}
