package com.learning.util;

public class SortingUtil {

	public static int[] swap(int[] array, int position1, int position2) {
		int temp = array[position1];
		array[position1] = array[position2];
		array[position2] = temp;
		return array;
	}

}
