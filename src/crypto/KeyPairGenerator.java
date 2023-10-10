package crypto;

import java.math.BigInteger;
import java.security.SecureRandom;

public class KeyPairGenerator {

    private BigInteger n;
    private BigInteger e;
    private BigInteger d;

    public KeyPairGenerator() {
        keyPair();
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }

    public void keyPair() {

        BigInteger q;
        BigInteger p;
        do {
            p = BigInteger.probablePrime(1024, new SecureRandom());
            q = BigInteger.probablePrime(1024, new SecureRandom());
        } while(!p.isProbablePrime(100) || !q.isProbablePrime(100) || p.equals(q));

        n = p.multiply(q);
        e = new BigInteger("65537");

        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        d = e.modInverse(phiN);


    }


}
