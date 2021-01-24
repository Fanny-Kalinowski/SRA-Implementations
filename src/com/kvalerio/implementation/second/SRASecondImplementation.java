package com.kvalerio.implementation.second;

import com.kvalerio.Utils;
import com.kvalerio.implementation.SRAImplementation;

import java.util.Random;

public class SRASecondImplementation implements SRAImplementation {

    private static final int primeNumber = 100012421;

    private final int encryptionKey;
    private final int decryptionKey;

    public SRASecondImplementation() {
        this.encryptionKey = getEncryptionKeys();
        this.decryptionKey = moduloInverseWithEuclide(encryptionKey, primeNumber - 1);
    }

    //TODO: comprendre ça, faire variante bruteforce et autre, et refactor ça
    private int moduloInverseWithEuclide(int a, int m) {

        int m0 = m;
        int y = 0, x = 1;

        if (m == 1)
            return 0;

        while (a > 1) {
            // q is quotient
            int q = a / m;
            int t = m;
            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;
            // Update x and y
            y = x - q * y;
            x = t;
        }
        // Make x positive
        if (x < 0)
            x += m0;

        return x;
    }

    private int getEncryptionKeys() {
        int phiP = this.primeNumber - 1;
        int k = new Random().nextInt();
        while (Utils.GCD(phiP, k) != 1) {
            k = new Random().nextInt();
        }
        return k;
    }

    /*
    Algorithme d'exponentiation modulaire
    Méthode right-to-left
    Se base sur l'exponentiation au carré
        ==> Si exponent est pair -> puissance(x², n/2)
        ==> Sinon -> x * puissance(x², (n-1) / 2))
     On calcule des modulos intermediaire afin de préserver la mémoire de très grands nombres
    */
    private long moduloPow(long x, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) > 0) {
                result = (result * x) % this.primeNumber;
            }
            exponent >>= 1;
            x = (x * x) % this.primeNumber;
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
