package com.kvalerio;

public class Utils {

    /*
    Affiche le PGCD entre x et y
     */
    public static Integer GCD(int x, int y) {
        if (y == 0) return x;
        return GCD(y, x % y);
    }
}
