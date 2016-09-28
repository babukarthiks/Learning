package com.learning.algos.arrays;

public class MoveZerosToEnd {

    public int[] moveZerosToEnd(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        int movedPosition = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[movedPosition] = num;
                movedPosition++;
            }
        }

        for (int i = movedPosition; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }

}
