package com.learning.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray {

    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<Integer>();
        // a.add(0, 6);
        // a.add(0, 3);
        // a.add(0, 2);
        // a.add(0, -7);
        // a.add(0, 5);
        // a.add(0, 2);
        // a.add(0, 1);

        //
        //
        // [1, 2, 5, -7, 2, 3]
        //
        a.add(0, 0);
        a.add(0, -1);
        a.add(0, 0);
        a.add(0, 0);
        // 0, 0, -1, 0

        // a.add(0, -1);
        // a.add(0, -1);
        // a.add(0, -1);
        // a.add(0, -1);

        // a.add(0,-521595368);
        // a.add(0,-1303455736);
        // a.add(0,1540383426);
        // a.add(0,1967513926);

        // a.add(0, -1937477084);
        // a.add(0, -511702305);
        // a.add(0, -982906996);
        // a.add(0, 137806862);

        // , , , -521595368

        // 137806862, -982906996, -511702305,

        System.out.println(a);
        System.out.println(getMaxNonNegativeSubArrayList(a));

    }

    public static ArrayList<Integer> getMaxNonNegativeSubArrayList(ArrayList<Integer> a) {

        if (a == null) {
            return null;
        }

        if (a.isEmpty()) {
            return null;
        }

        long currentSum = 0;
        int currentStartIndex = 0, currentEndIndex = 0;
        long maxSum = Long.MIN_VALUE;
        int maxSumStartIndex = 0, maxSumEndIndex = 0;

        for (int i = 0; i < a.size(); i++) {

            if (a.get(i) >= 0) {
                currentSum += a.get(i);
                currentEndIndex = i;
                if (maxSum <= currentSum) {
                    maxSum = currentSum;
                    if (maxSum != currentSum)
                        maxSumStartIndex = currentStartIndex;
                    maxSumEndIndex = currentEndIndex;
                }
            } else {
                currentSum = 0;
                currentStartIndex = i + 1;
                currentEndIndex = i + 1;
            }
        }
        if (maxSumStartIndex == 0 && maxSumEndIndex == 0) {
            return new ArrayList<Integer>();
        }
        return new ArrayList<Integer>(a.subList(maxSumStartIndex, maxSumEndIndex + 1));
    }

}
