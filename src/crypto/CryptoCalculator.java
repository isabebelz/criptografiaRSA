package crypto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe CryptoCalculator fornece métodos para criptografar e descriptografar mensagens usando o algoritmo RSA.
 */
public class CryptoCalculator {

    /**
     * Criptografa um array de blocos de texto usando a chave pública especificada.
     *
     * @param keyPair  O par de chaves usado para criptografia.
     * @param preCode  Um array de blocos de texto a serem criptografados.
     * @return Uma lista de blocos criptografados como strings.
     */
    public static List<String> encrypt(KeyPairGenerator keyPair, String[] preCode) {

        List<String> encryptedText = new ArrayList<>();

        for (String block : preCode) {
            BigInteger m = new BigInteger(block);
            BigInteger c = m.modPow(keyPair.getE(), keyPair.getN());
            encryptedText.add(String.valueOf(c));
        }

        return encryptedText;
    }

    /**
     * Descriptografa uma lista de blocos de texto criptografados usando a chave privada especificada.
     *
     * @param keyPair       O par de chaves usado para descriptografia.
     * @param encryptedText Uma lista de blocos criptografados.
     * @return A mensagem original descriptografada como uma string.
     */
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

