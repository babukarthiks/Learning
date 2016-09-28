package com.learning.questions;

import java.util.Scanner;

public class CountMaxSubArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int count = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < count; i++) {

			String countSum = scanner.nextLine();
			System.out.println(countSum);
			String[] countSumS = countSum.split(" ");
			int size = Integer.parseInt(countSumS[0]);
			int sum = Integer.parseInt(countSumS[1]);
			String values = scanner.nextLine();
			String[] valuesArray = values.split(" ");
			int[] valueInt = new int[valuesArray.length];
			for (int x = 0; x < valuesArray.length; x++) {
				valueInt[x] = Integer.parseInt(valuesArray[x]);
			}

			int sumArray = 0, start = 0;

			for (int y = 0; y < valueInt.length; y++) {
				sumArray += valueInt[y];
				if(sumArray>sum){
					sumArray -=valueInt[start];
					start++;
				}
				if (sumArray == sum) {
					System.out.println((start + 1) + " " + (y + 1));
				}
			}
		}
	}
}
