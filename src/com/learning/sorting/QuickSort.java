package com.learning.sorting;

import java.util.Random;

public class QuickSort {

    static Random r = new Random();

    public static int[] sort(int[] nums) {

        int pivot = nums.length / 2;
        nums = quickSort(0, nums.length - 1, nums);
        // nums = quickSort(pivot + 1, nums.length, nums);

        for (int i : nums) {
            System.out.println(i);
        }

        return null;
    }

    private static int[] quickSort(int min, int max, int[] nums) {

        int i = min, j = max;
        int pivot = (min + max) / 2;

        while (i < j) {
            while (nums[i] < nums[pivot]) {
                i++;
            }
            while (nums[j] > nums[pivot]) {
                j--;
            }
            if (i <= j) {
                nums = swap(nums, i, j);
                i++;
                j--;
            }
        }
        if (min < j) {
            quickSort(min, j, nums);
        }
        if (i < max) {
            quickSort(i, max, nums);
        }
        return nums;
    }

    private static int[] swap(int[] nums, int min, int max) {
        int temp = nums[max];
        nums[max] = nums[min];
        nums[min] = temp;
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 5, 1, 4, 9, 3, 8, 7, 6 };
        sort(nums);
    }

}
