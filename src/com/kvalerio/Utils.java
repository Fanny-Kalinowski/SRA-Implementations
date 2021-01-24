package com.kvalerio;

public class Utils {

    /*
    Retourne le PGCD entre x et y
     */
    public static Integer GCD(int x, int y) {
        return (y == 0) ? x : GCD(y, x % y);
    }
}
