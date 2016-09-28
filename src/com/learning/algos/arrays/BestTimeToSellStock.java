package com.learning.algos.arrays;

public class BestTimeToSellStock {
    public static int findMaxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // empty list
        System.out.println(findMaxProfit(new int[] {}));

        // null array
        System.out.println(findMaxProfit(null));

        // 0 profit case
        System.out.println(findMaxProfit(new int[] { 7, 6, 4, 3, 1 }));

        // +ve profit case 1- 6 = 5
        System.out.println(findMaxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));

    }
}
