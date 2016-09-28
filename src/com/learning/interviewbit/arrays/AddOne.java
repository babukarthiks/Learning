package com.learning.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class AddOne {

    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<Integer>();
//         a.add(0, 5);
//         a.add(0, 4);
//         a.add(0, 2);
//         a.add(0, 1);
//         a.add(0, 6);
//         a.add(0, 8);
//         a.add(0, 6);
//         a.add(0, 5);
//         a.add(0, 2);
//        a.add(9);
//        a.add(9);
//        a.add(9);
        a.add(9);
        System.out.println(a);
        a = plusOne(a);

        System.out.println(a);
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int carry = 1;
        for (int i = a.size() - 1; i>=0; i--) {
            int value = a.get(i)  + carry;
            a.set(i, value % 10);
            carry = value / 10;
        }

        if (carry == 1) {
            a.add(0, carry);
        }
        return a;
    }
}
