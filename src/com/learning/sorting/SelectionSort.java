package com.learning.sorting;

import com.learning.util.SortingUtil;

public class SelectionSort {

	public static int[] sort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			int minPos = i, currentMin = array[i];
			for (int j = i; j < array.length; j++) {
				if (currentMin > array[j]) {
					currentMin = array[j];
					minPos = j;
				}
			}
			array = SortingUtil.swap(array, minPos, i);
		}
		return array;
	}
}
