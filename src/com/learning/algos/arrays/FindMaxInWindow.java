package com.learning.algos.arrays;

public class FindMaxInWindow {

    static void findMaxInWindowK(int[] arr, int window) {

        int[] leftToRight = new int[arr.length];
        int[] rightToLeft = new int[arr.length];

        leftToRight[0] = arr[0];
        rightToLeft[arr.length - 1] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            leftToRight[i] = (i % window == 0) ? arr[i] : Math.max(arr[i], leftToRight[i - 1]);

            int j = arr.length - i - 1;

            rightToLeft[j] = (j % window == 0) ? arr[j] : Math.max(arr[j], rightToLeft[j + 1]);
        }

        int[] max = new int[arr.length - window + 1];

        for (int i = 0; i < arr.length - window; i++) {
            max[i] = Math.max(rightToLeft[i], leftToRight[i + window - 1]);
        }

        for (int i = 0; i < max.length; i++) {
            System.out.println(max[i]);
        }
    }

    public static void main(String[] args) {
        int[] x = new int[] { 1, -2, 5, 6, 0, 9, 8, -1, 2, 0 };
        findMaxInWindowK(x, 3);
    }
}
