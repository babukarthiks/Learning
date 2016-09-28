package com.google.learning;

public class FindNextBigNumber {
    public static void main(String[] args) {
        System.out.println("1,2,3 → 1,3,2");
        for (int i : findNextBigNumber(new int[] { 1, 2, 3 })) {
            System.out.println(i);
        }
        System.out.println("3,2,1 → 1,2,3");
        for (int i : findNextBigNumber(new int[] { 3, 2, 1 })) {
            System.out.println(i);
        }
        System.out.println("1,1,5 → 1,5,1");
        for (int i : findNextBigNumber(new int[] { 1, 1, 5 })) {
            System.out.println(i);
        }
    }

    public static int[] findNextBigNumber(int[] number) {

        int i = number.length - 1;
        for (; i > 0; i--) {

            if (number[i] > number[i - 1]) {
                int temp = number[i];
                number[i] = number[i - 1];
                number[i - 1] = temp;
                break;
            }
        }

        if (i == 0) {
            for (int j = 0; i <= (number.length - 1) / 2; i++) {
                int temp = number[j];
                number[j] = number[number.length - 1 - j];
                number[number.length - 1 - j] = temp;
            }
        }
        return number;
    }

}
