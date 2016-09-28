package com.google.learning;

public class AddPlusOneToArray {

    public static void main(String[] args) {

        for (int i : addPlusOne(new int[] { 9,9 })) {
            System.out.println(i);
        }

    }

    public static int[] addPlusOne(int[] number) {

        int carry = 1;

        for (int i = (number.length) - 1; i >= 0; i--) {

            int value = number[i] + carry;
            number[i] = value % 10;
            carry = value / 10;
        }

        if (carry > 0) {
            int [] plusNumber = new int[number.length + 1];
            plusNumber[0] = carry;
            for(int i=0; i<number.length;i++){
                plusNumber[i+1] = number[i];
            }
            return plusNumber;
        } else {
            return number;
        }
    }

}
