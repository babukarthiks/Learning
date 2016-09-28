package com.learning.questions;

import com.learning.util.Read;
import com.learning.util.ReadType;

public class Jumbled {

	public static void main(String[] args) {

		int number = Read.read(ReadType.INT);
		System.out.println(jumbled(number));
	}

	private static boolean jumbled(int number) {
		if (number / 10 == 0) {
			return true;
		}

		int last = number % 10;

		number = number / 10;

		int next = number % 10;

		jumbled(number);

		if (last - next == 1) {
			return true;
		} else if (last - next == -1) {
			return true;
		} else if (last - next > -1) {
			return false;
		} else {
			return false;
		}
	}

}
