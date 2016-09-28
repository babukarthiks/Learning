package com.learning.questions;

/**
 * Given an array find the maximum consecutive and non consecutive sum and print them.
 */

public class KadanesMaxSubArray {
    public int sumOfConsecutiveMaxSubArray(int[] array) {

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if ((sum + array[i]) < sum) {
                sum = array[i];
            } else if ((sum + array[i]) >= sum) {
                sum += array[i];
            }
        }
        return sum;
    }

    public int findMaxSumInArray(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                sum += array[i];
            }

        }
        return sum;
    }
}
