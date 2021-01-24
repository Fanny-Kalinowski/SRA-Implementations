package com.kvalerio;

import com.kvalerio.implementation.first.SRAFirstImplementation;
import com.kvalerio.implementation.second.SRASecondImplementation;
import com.kvalerio.implementation.third.SRAThirdImplementation;

import java.util.Random;

public class Main {

    /*
           3 algorithmes pour générer avec SRA
           - clés de chiffrement
           - clés de déchiffrement
           - fonction de chiffrement
           - fonction de déchiffrement
    */

    public static void main(String[] args) {
//        testFirstImplementation();
//        testSecondImplementation();
        testThirdImplementation();
    }

    private static void testFirstImplementation() {
        System.out.println("\n======= Testing FIRST implementation ========");
        SRAFirstImplementation SRA = new SRAFirstImplementation();
        int toEncrypt = new Random().nextInt(500);
        long encrypt = SRA.encrypt(toEncrypt);
        System.out.println("Encryption result of " + toEncrypt + " is " + encrypt);
        System.out.println("Decryption result of " + encrypt + " is " + SRA.decrypt(encrypt) + "\n");
    }

    private static void testSecondImplementation() {
        System.out.println("\n======= Testing SECOND implementation ========");
        SRASecondImplementation SRA = new SRASecondImplementation();
        int toEncrypt = new Random().nextInt(500);
        long encrypt = SRA.encrypt(toEncrypt);
        System.out.println("Encryption result of " + toEncrypt + " is " + encrypt);
        System.out.println("Decryption result of " + encrypt + " is " + SRA.decrypt(encrypt) + "\n");
    }

    private static void testThirdImplementation() {
        System.out.println("\n======= Testing THIRD implementation ========");
        SRAThirdImplementation SRA = new SRAThirdImplementation();
        int toEncrypt = new Random().nextInt(500);
        long encrypt = SRA.encrypt(toEncrypt);
        System.out.println("Encryption result of " + toEncrypt + " is " + encrypt);
        System.out.println("Decryption result of " + encrypt + " is " + SRA.decrypt(encrypt) + "\n");
    }
}