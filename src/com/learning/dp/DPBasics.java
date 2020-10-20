package com.learning.dp;

public class DPBasics {
    public static void main(String[] args) {

        int[] prices = new int[]{1,5,8,9,10,17,17,20,24,30};

        cutRods(prices, 10);
    }

    private static void cutRods(int[] prices, int i) {

        cutRodsDP(prices, i);
    }

    private static void cutRodsDP(int[] prices, int n) {

        int[] revenue = new int[10];
        int[] sizes = new int[10];

        for(int i=0;i<10;i++){
            revenue[i] = -1;
            sizes[i] =-1;
        }

        revenue[0] = 0;
        sizes[0] = 0;


        for(int i=1; i<n ;i++){
            int temp = -1;
            for(int j=1;j<i;j++){
                if(temp < prices[j] + revenue[i-j]){
                    temp = prices[j] + revenue[i-j];
                    sizes[i] = j;
                }
            }
            revenue[i] = temp;
        }
        System.out.println("revenues : ");

        for(int i=0;i<10;i++){
            System.out.println(  revenue[i]);
        }


        System.out.println("sizes : ");

        for(int i=0;i<10;i++){
            System.out.println(  sizes[i]);
        }






    }
}
