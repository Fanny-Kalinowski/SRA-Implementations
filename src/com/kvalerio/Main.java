package com.kvalerio;

import com.kvalerio.implementation.second.SRASecondImplementation;

public class Main {

    /*
           3 algorithmes pour générer avec SRA
           - clés de chiffrement
           - clés de déchiffrement
           - fonction de chiffrement
           - fonction de déchiffrement
    */

    public static void main(String[] args) {

        SRASecondImplementation keyPair = new SRASecondImplementation();
        long encrypt = keyPair.encrypt(3443);
        System.out.println("Encryption result of 3443 is " + encrypt);
        System.out.println("Decryption result of " + encrypt + " is " + keyPair.decrypt(encrypt));


    }
}
