package com.learning.algos.arrays;

public class MergeSortedArrays {

    public static int[] mergerSortedArrays(int[] array1, int[] array2) {

        int[] mergedArray = new int[array1.length + array2.length];
        int i = 0, j = 0, mergedArrayIndex = 0;

        for (; i < array1.length && j < array2.length;) {
            if (array1[i] < array2[j]) {
                mergedArray[mergedArrayIndex] = array1[i];
                i++;
            } else {
                mergedArray[mergedArrayIndex] = array2[j];
                j++;
            }
            mergedArrayIndex++;
        }

        while (i < array1.length) {
            mergedArray[mergedArrayIndex] = array1[i];
            i++;
            mergedArrayIndex++;
        }

        while (j < array2.length) {
            mergedArray[mergedArrayIndex] = array2[j];
            j++;
            mergedArrayIndex++;
        }

        return mergedArray;
    }

    public static void main(String[] args) {

        int[] a = { 1, 3, 5, 7, 9 };
        int[] b = { 2, 4, 6, 8 };

        for (int num : mergerSortedArrays(a, b)) {
            System.out.print(num);
        }
    }
}
