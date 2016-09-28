package com.learning.algos.strings;

import com.learning.util.Read;
import com.learning.util.ReadType;

public class BeautifulString {

	public static void main(String[] args) {
		Integer n = (Integer) Read.read(ReadType.INT);
		Read.read(ReadType.LINE);
		String B = (String) Read.read(ReadType.LINE);

		int count = 0;
		for (int i = 0; i < n - 3;) {
			String temp = B.substring(i, i+3);
			if (temp.equalsIgnoreCase("010")) {
				count++;
				i += 2;
			}else{
				i++;
			}
		}
		System.out.println(count);
	}

}
