package com.learning.sorting;

import com.learning.util.SortingUtil;

public class BubbleSort {

	public static int[] sort(int[] array) {
		for (int i = 0; i < array.length - i; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					array = SortingUtil.swap(array, j, j + 1);
				}
			}
		}
		return array;
	}
}
