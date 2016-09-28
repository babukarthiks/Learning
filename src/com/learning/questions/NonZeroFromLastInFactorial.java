package com.learning.questions;

import java.util.HashMap;
import java.util.Map;

public class NonZeroFromLastInFactorial {

	static Map<Integer, Integer> rem = new HashMap<Integer, Integer>();

	static int four = 4;
	static int three = 6;

	public static void main(String[] args) {

		findLast(222);

		int result = 1;
		int resultSum = 0;

		for (int key : rem.keySet()) {
			resultSum += key;
		}

		for (int val : rem.values()) {
			result *= findFact(val);
		}

		if (resultSum % 2 == 1) {
			System.out.println((result * 2) % 10);
		} else {
			System.out.println(result % 10);
		}
	}

	private static int findFact(int value) {
		if (value == 4) {
			return four;
		} else if (value == 3) {
			return three;
		} else if (value == 2) {
			return 2;
		}
		return 1;
	}

	private static void findLast(int num) {

		if (num == 0) {
			return;
		}

		int x = num / 5;
		int y = num - (5 * x);
		rem.put(x, y);

		findLast(x);
	}

}
