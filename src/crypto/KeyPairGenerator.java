package crypto;

import java.math.BigInteger;
import java.security.SecureRandom;

public class KeyPairGenerator {

    private static BigInteger n;
    private static BigInteger e;
    private BigInteger p, q, d, phiN;

    public KeyPairGenerator() {
        privateKey();
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }

    public static void publicKey(BigInteger p, BigInteger q) {

        n = p.multiply(q);
        e = new BigInteger("65537");

    }

    void privateKey() {

        do {
            p = BigInteger.probablePrime(2048, new SecureRandom());
            q = BigInteger.probablePrime(2048, new SecureRandom());
        } while(!p.isProbablePrime(100) || !q.isProbablePrime(100) || p.equals(q));

        publicKey(p, q);

        phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        d = e.modInverse(phiN);

    }

}
