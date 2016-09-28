package com.learning.algos.arrays;

import com.learning.util.Read;
import com.learning.util.ReadType;

public class AlternateChars {

	public static void main(String[] args) {

		int tests = (Integer) Read.read(ReadType.INT);
		
		System.out.println(tests);
		while (tests > 0) {
			//Read.read(ReadType.INT);
			Read.read(ReadType.HASNEXT);
			String s = (String) Read.read(ReadType.LINE);
			int count = 0;
			System.out.println(s);
			char prev = s.charAt(0);
			for (int i = 1; i < s.length(); i++) {
				if (prev == s.charAt(i)) {
					count++;
				}
			}
			System.out.println(count);
			tests--;
		}
	}

}
