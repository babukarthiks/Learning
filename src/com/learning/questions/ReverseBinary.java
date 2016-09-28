package com.learning.questions;

public class ReverseBinary {

    public static int reverse(int x) {

        int n = 0, bits = 0;
        while (bits < 32) {
            int bit = x & 1;
            n = (n << 1) + bit;
            x = x >> 1;
            bits++;
        }
        return n;
    }

    public static boolean palindrome(int x) {

        int n = 0, a = x;
        while (x > 0) {
            int bit = x & 1;
            n = (n << 1) + bit;
            x = x >> 1;
        }
        return a == n;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1));
        System.out.println(palindrome(1365));
        // System.out.println(negate(1));
    }

}
