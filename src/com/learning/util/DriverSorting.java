package com.learning.util;

import com.learning.sorting.BubbleSort;
import com.learning.sorting.SelectionSort;

public class DriverSorting {

	public static void main(String[] args) {
		int[] array = {2,6,9,3,8,1,7,5,4};
		print(SelectionSort.sort(array));
		print(BubbleSort.sort(array));
	}
	
	private static void print(int[] array){
		for(int i=0; i<array.length;i++){
			System.out.print(array[i]);
		}
		System.out.println();
	}
}
