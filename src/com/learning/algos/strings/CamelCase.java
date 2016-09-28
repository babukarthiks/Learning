package com.learning.algos.strings;

import com.learning.util.Read;
import com.learning.util.ReadType;

public class CamelCase {

	public static void main(String[] args) {
		String s = (String) Read.read(ReadType.LINE);

		int count = 1;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'A' && c <= 'Z')
				count++;
		}
		System.out.println(count);
	}

}
