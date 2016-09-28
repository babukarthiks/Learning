package com.learning.algos.strings;

public class AtoI {

    public static int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();
        int sign = 1;
        long res = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        if (str.charAt(0) == '+')
            index++;
        else if (str.charAt(0) == '-') {
            sign = -1;
            index++;
        }
        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index))) {
                res = res * 10 + (str.charAt(index++) - '0');
                if (res * sign > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if (res * sign < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            } else {
                index++;
            }
        }
        res = res * sign;
        return (int) res;
    }
    
    
    public static int maxRotateFunction(int[] A) {
        int sum = 0;
        int F = 0;
        for (int i = 0; i < A.length; i++) {
            F += i * A[i];
            sum += A[i];
        }
        int max = F;
        for (int i = A.length - 1; i >= 0; i--) {
            F = F + sum - A[i] * A.length;
            max = Math.max(F, max);
        }
        return max;
    }
    
    
    public static boolean checkIfRepeatedSubString(String s){
        String copy = s;
        while(copy.length()>2){
            
            
        }
        
        return false;
    }

    public static void main(String[] args) {
      //  System.out.println(myAtoi("-1afafafaf2"));
        System.out.println(maxRotateFunction(new int[]{4,3,2,6}));
    }

}
