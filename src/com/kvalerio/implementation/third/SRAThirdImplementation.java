package com.kvalerio.implementation.third;

import com.kvalerio.Utils;

import java.math.BigInteger;
import java.util.Random;

public class SRAThirdImplementation {

    private static final int primeNumber = 2129;
    private final long encryptionKey;
    private final long decryptionKey;

    public SRAThirdImplementation() {
        this.encryptionKey = getEncryptionKeys();
        this.decryptionKey = moduloInverseWithFermat(encryptionKey, primeNumber - 1);
    }

    /*
    Permet de calculer le modulo inverse utilisé pour calculer la clé de déchiffrement
    Idéalement, utiliserait le petit théorème de Fermat : si p est premier, alors a^p-a est un multiple de p
    Soit a^p congrue a mod p
     */

    private long moduloInverseWithFermat(long a, long m) {
        long res = (new BigInteger(String.valueOf(a)).modInverse(new BigInteger(String.valueOf(m)))).intValue();
//        long fermat = moduloPow(a, m - 2, m);
        return res;
    }

    private long getEncryptionKeys() {
        int phi = primeNumber - 1;
        int x = new Random().nextInt(500);

        while (Utils.GCD(phi, x) != 1) {
            x = new Random().nextInt(500);
        }
        return x;
    }

    /*
    Algorithme d'exponentiation modulaire (exponentiation by squaring)
    Algorithme : si exponent = 1, retourne base
                 si exponent paire, retourne moduloPow(base², exponent/2)
                 si exponent impaire, retourne base * moduloPow(base², (exponent-1) / 2)
    En complexité log(n)
    */
    private long moduloPow(long base, long exponent, long prime) {

        if (exponent == 1)  //Arret récursivité
            return base % prime;

        long t = moduloPow(base, exponent / 2, prime);

        t *= (t) % prime;

        if (exponent % 2 == 0)  //Cas paire
            return t;
        else                    // Cas impaire
            return ((base % prime) * t) % prime;
    }

    public long encrypt(long message) {
        return moduloPow(message, encryptionKey, primeNumber);
    }

    public long decrypt(long cypher) {
        return moduloPow(cypher, decryptionKey, primeNumber);
    }
}