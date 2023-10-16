package crypto;

import java.math.BigInteger;
import java.util.Random;

/**
 * A classe KeyPairGenerator é responsável por gerar um par de chaves RSA, incluindo a chave pública (n, e) e a chave privada (d).
 */
public class KeyPairGenerator {
    private BigInteger p;    // Um número primo 'p'.
    private BigInteger q;    // Um número primo 'q'.
    private BigInteger n;    // O módulo de criptografia 'n'.
    private BigInteger phiN; // O valor da função totiente de 'n' (φ(n)).
    private BigInteger e;    // O expoente de criptografia (chave pública 'e').
    private BigInteger d;    // O expoente de descriptografia (chave privada 'd').

    /**
     * Construtor da classe KeyPairGenerator que gera automaticamente um par de chaves ao ser instanciado.
     */
    public KeyPairGenerator() {
        generateKeys();
    }

    /**
     * Gera um par de chaves RSA, a chave pública e privada.
     */
    public void generateKeys() {
        // Gere dois números primos p e q.
        p = generatePrime();
        q = generatePrime();

        // Calcule o módulo de criptografia 'n' e φ(n).
        n = p.multiply(q);
        phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Escolha um valor para o expoente de criptografia 'e' (deve ser coprimo a φ(n)).
        e = new BigInteger("65537");
        //e = choosePublicKey(phiN);  // Opção alternativa para escolher 'e'.

        // Calcule o valor do expoente de descriptografia 'd' (chave privada).
        d = calculatePrivateKey(e, phiN);
    }

    /**
     * Gera um número primo grande.
     *
     * @return Um número primo gerado aleatoriamente.
     */
    private static BigInteger generatePrime() {
        BigInteger prime;
        do {
            prime = BigInteger.probablePrime(1024, new Random());
        } while (!prime.isProbablePrime(100));
        return prime;
    }

    /**
     * Escolhe um valor para o expoente de criptografia 'e' (chave pública).
     *
     * @param phiN O valor de φ(n).
     * @return Um valor de 'e' que é coprimo a φ(n).
     */
    private static BigInteger choosePublicKey(BigInteger phiN) {
        BigInteger publicKey;
        do {
            publicKey = new BigInteger(16, new Random());
        } while (publicKey.compareTo(BigInteger.ONE) <= 0 || publicKey.compareTo(phiN) >= 0 || !publicKey.gcd(phiN).equals(BigInteger.ONE));
        return publicKey;
    }

    /**
     * Calcula o valor do expoente de descriptografia 'd' (chave privada).
     *
     * @param publicKey O expoente de criptografia 'e' (chave pública).
     * @param phiN      O valor de φ(n).
     * @return O valor de 'd' calculado.
     */
    private static BigInteger calculatePrivateKey(BigInteger publicKey, BigInteger phiN) {
        return publicKey.modInverse(phiN);
    }

    /**
     * Obtém o valor do módulo de criptografia 'n' que faz parte da chave pública.
     *
     * @return O valor de 'n'.
     */
    public BigInteger getN() {
        return n;
    }

    /**
     * Obtém o valor do expoente de criptografia 'e' que faz parte da chave pública.
     *
     * @return O valor de 'e'.
     */
    public BigInteger getE() {
        return e;
    }

    /**
     * Obtém o valor do expoente de descriptografia 'd' que faz parte da chave privada.
     *
     * @return O valor de 'd'.
     */
    public BigInteger getD() {
        return d;
    }

    /**
     * Obtém o valor do número primo 'p'.
     *
     * @return O valor de 'p'.
     */
    public BigInteger getP() {
        return p;
    }

    /**
     * Obtém o valor do número primo 'q'.
     *
     * @return O valor de 'q'.
     */
    public BigInteger getQ() {
        return q;
    }

    /**
     * Obtém o valor da função totiente de 'n' (φ(n)).
     *
     * @return O valor de φ(n).
     */
    public BigInteger getPhiN() {
        return phiN;
    }
}


