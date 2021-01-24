package com.kvalerio.implementation.first;

import com.kvalerio.Utils;

import java.util.Random;

public class SRAFirstImplementation {
//
//
//    private final Integer prime; //Nombre premier
//    private final Integer e;  // Clé de chiffrement - secret. 1 < e < p-1 et gcd(e, p-1) = 1
//    private final Integer d; //Clé de déchiffrement - secret^-1
//
//    public SRAFirstImplementation() throws Exception {
//        this.prime =  100012421;
//        this.e = generatePrivateKey();
//        this.d = Utils.modInv(e, prime - 1);
//        checkKeys();
//    }
//
//    //Vérifie les conditions nécéssaires des clés
//    private void checkKeys() throws Exception {
//        if (Utils.GCD(e, prime - 1) != 1) {
//            throw new Exception("gcd(" + e + ", " + prime + "-1) != 1");
//        }
//        if (e < 1) {
//            throw new Exception("e n'est pas bien choisi (e:" + e + ", prime:" + prime + ")");
//        }
//    }
//
//    private Integer generatePrivateKey() {
//        int k = new Random().nextInt(prime - 1);
//        // Tant que le pgcd de Phi et k n'est pas 1, on regénere une clée privée
//        while (Utils.GCD(k, prime - 1) != 1) {
//            k = new Random().nextInt(prime - 1);
//        }
//        return k;
//    }
//
//    public Integer encrypt(Integer message) {
//        return Math.toIntExact(Utils.moduloPow(message, e, prime));
//    }
//
//    public Integer decrypt(Integer message) {
//        return Math.toIntExact(Utils.moduloPow(message, d, prime));
//    }
}