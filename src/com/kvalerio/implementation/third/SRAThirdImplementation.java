package com.kvalerio.implementation.third;

import com.kvalerio.Utils;

import java.util.Random;

public class SRAThirdImplementation {

    private static final int primeNumber = 2129;
    private final int encryptionKey;
    private final int decryptionKey;

    public SRAThirdImplementation() {
        this.encryptionKey = getEncryptionKeys();
        this.decryptionKey = moduloInverseWithFermat(encryptionKey, primeNumber - 1);
    }


    /*
    Permet de calculer le modulo inverse utilisé pour calculer la clé de déchiffrement
    Utilise le petit théorème de Fermat : si p est premier, alors a^p-a est un multiple de p
    Soit a^p congrue a mod p
     */
    private int moduloInverseWithFermat(int a, int m) {
        long value = moduloPow(a, m - 2, m);
        return Math.toIntExact(value);

    }

    private int getEncryptionKeys() {
        int phi = primeNumber - 1;
        int x = new Random().nextInt(500);

        while (Utils.GCD(phi, x) != 1) {
            x = new Random().nextInt(500);
        }
        return x;
    }

    /*
    Algorithme d'exponentiation modulaire
    Méthode right-to-left
    Se base sur l'exponentiation au carré
        ==> Si exponent est pair -> puissance(x², n/2)
        ==> Sinon -> x * puissance(x², (n-1) / 2))
     On calcule des modulos intermediaire afin de préserver la mémoire de très grands nombres
    */
    private long moduloPow(long x, long exponent, long prime) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) > 0) {
                result = (result * x) % prime;
            }
            exponent >>= 1;
            x = (x * x) % prime;
        }
        return result;
    }

    public long encrypt(long message) {
        return moduloPow(message, encryptionKey, primeNumber);
    }

    public long decrypt(long cypher) {
        return moduloPow(cypher, decryptionKey, primeNumber);
    }
}