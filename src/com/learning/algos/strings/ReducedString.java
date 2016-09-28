package com.learning.algos.strings;

import com.learning.util.Read;
import com.learning.util.ReadType;

public class ReducedString {

	public static void main(String[] args) {
		String s = (String) Read.read(ReadType.LINE);
		for (int i = 1; i < s.length();) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				s = s.substring(0, i - 1) + s.substring(i + 1);
				i--;
				if (i == 0) {
					i = 1;
				}
			} else {
				i++;
			}
		}

		if (s.length() == 0)
			System.out.println("Empty String");
		else
			System.out.println(s);
	}

}
