package com.kvalerio.implementation.second;

import com.kvalerio.Utils;
import com.kvalerio.implementation.SRAImplementation;

import java.util.Random;

public class SRASecondImplementation implements SRAImplementation {

    private static final int primeNumber = 2129;

    private final int encryptionKey;
    private final int decryptionKey;

    public SRASecondImplementation() {
        this.encryptionKey = getEncryptionKeys();
        this.decryptionKey = moduloInverseWithEuclide(encryptionKey, primeNumber - 1);
    }

    /*
    Permet de calculer le modulo inverse utilisé pour calculer la clé de déchiffrement
    Utilise l'algorithme d'Euclide etendu, en assumant que gcd et b sont premiers
    En complixité log(n)
    Objectif, trouver a et b tel que ax + by = gcd(a, b)
     */
    private int moduloInverseWithEuclide(int a, int b) {

        int retenue = b;
        int y = 0, finalModulo = 1;

        if (retenue == 1)
            return 0;

        while (a > 1) {
            int quotient = a / retenue;
            int retenueTmp = retenue;
            // On applique l'algorithme d'Euclide
            retenue = a % retenue;
            //On swap les variables
            a = retenueTmp;
            retenueTmp = y;
            // On remet le bon finalModulo et y
            y = finalModulo - quotient * y;
            finalModulo = retenueTmp;
        }

        if (finalModulo < 0)
            finalModulo += b;

        return finalModulo;
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
    public static long moduloPow(long x, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) > 0) {
                result = (result * x) % primeNumber;
            }
            exponent >>= 1;
            x = (x * x) % primeNumber;
        }
        return result;
    }

    public long encrypt(long message) {
        return moduloPow(message, encryptionKey);
    }

    public long decrypt(long cypher) {
        return moduloPow(cypher, decryptionKey);
    }
}
