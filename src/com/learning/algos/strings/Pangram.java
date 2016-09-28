package com.learning.algos.strings;

import com.learning.util.Read;
import com.learning.util.ReadType;

public class Pangram {

	public static void main(String[] args) {

		int[] counts = new int[26];
		String s = (String) Read.read(ReadType.LINE);
		s = s.toLowerCase();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z') {
				counts[c - 97]++;
			}
		}

		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == 0) {
				System.out.println("not pangram");
				return;
			}
		}
		System.out.println("pangram");
	}

}
