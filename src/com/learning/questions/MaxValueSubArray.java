package com.learning.questions;

public class MaxValueSubArray {

	public static void main(String[] args) {
		int[] x = new int[] { 2, -3, 4, -5, 6, -7, -10 };
		System.out.println(maxSubArray(x));
	}

	private static int maxSubArray(int array[]) {

		int global = array[0], current = array[0];

		for (int i = 1; i < array.length; i++) {

			current = Math.max(array[i], current + array[i]);

			if (current > global) {
				global = current;
			}
		}
		return global;
	}
}
