package crypto;

import java.math.BigInteger;

import java.util.Random;

public class KeyPairGenerator {
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger phiN;
    private BigInteger e;
    private BigInteger d;

    public KeyPairGenerator() {
        generateKeys();
    }

    public void generateKeys() {
        // Gere números primos p e q
        p = generatePrime();
        q = generatePrime();

        // Calcule n e phi(n)
        n = p.multiply(q);
        phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Escolha um valor para e (deve ser um número ímpar e coprimo a phi(n))
        e = choosePublicKey(phiN);

        // Calcule o valor de d (chave privada)
        d = calculatePrivateKey(e, phiN);
    }

    // Função para gerar um número primo grande
    private static BigInteger generatePrime() {
        BigInteger prime;
        do {
            prime = BigInteger.probablePrime(1024, new Random());
        } while (!prime.isProbablePrime(100));
        return prime;
    }

    // Função para escolher um valor para e (chave pública)
    private static BigInteger choosePublicKey(BigInteger phiN) {
        BigInteger publicKey;
        do {
            publicKey = new BigInteger(phiN.bitLength(), new Random());
        } while (publicKey.compareTo(BigInteger.ONE) <= 0 || publicKey.compareTo(phiN) >= 0 || !publicKey.gcd(phiN).equals(BigInteger.ONE));
        return publicKey;
    }

    // Função para calcular o valor de d (chave privada)
    private static BigInteger calculatePrivateKey(BigInteger publicKey, BigInteger phiN) {
        return publicKey.modInverse(phiN);
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

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getPhiN() {
        return phiN;
    }
}

