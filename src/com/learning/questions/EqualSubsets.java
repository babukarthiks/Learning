package com.learning.questions;

import java.util.Arrays;

public class EqualSubsets {

    public static void main(String[] args) {


//        System.out.println(canPartition(new int[]{1,5,11,5}));
//        System.out.println(canPartition(new int[]{3,3,3,4,5}));
//        System.out.println(canPartition(new int[]{1,1,1,1}));

//        System.out.println(canPartition(new int[]{1,3,4,4a
        System.out.println(canPartition(new int[]{1,2,3,4,5,6,7}));

    }



        public static boolean canPartition(int[] nums) {

            if(nums.length == 0 )
                return false;

            Arrays.sort(nums);


            int i=0,j = nums.length-1;

            int left = nums[i] , right = nums[nums.length-1];

            while(i < j){

                if(left <right){
                    i++;
                    left+=nums[i];

                }else if(left >right){
                    j--;
                    right+=nums[j];

                }else  if(left == right && i+1==j){

                    return true;
                }else {
                    i++;
                    j--;
                }

            }
            return false;

        }

}
