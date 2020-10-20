package com.learning.questions;

public class RangeChange {

    public static void main(String[] args) {

        int[][] a =  {
               {1, 3, 2},
               {2, 4, 3},
               {0, 2, -2}
            };
        int[] res = getModifiedArray(5, a);

        for(int i=0; i< res.length;i++){
            System.out.println(res[i]);
        }
    }

    public static int[] getModifiedArray(int length, int[][] updates) {

        int[] res = new int[length];
        for(int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];

            res[start] += value;

            if(end < length - 1)
                res[end + 1] -= value;

        }

        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }

        return res;
    }
}
