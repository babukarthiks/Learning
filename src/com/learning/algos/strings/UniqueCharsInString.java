package com.learning.algos.strings;

import java.util.HashMap;
import java.util.Map;

import com.learning.util.Read;
import com.learning.util.ReadType;

public class UniqueCharsInString {

	public static void main(String[] args) {
		do {

			System.out.println(isUnique((String) Read.read(ReadType.LINE)));
		} while (true);

	}

	// using HashTable
	public static boolean isUnique(final String inputString) {
		Map<Integer, Boolean> uniqueMap = new HashMap<Integer, Boolean>();
		for (int i = 0; i < inputString.length(); i++) {
			int character = inputString.charAt(i);
			if (uniqueMap.get(character) == null) {
				uniqueMap.put(character, Boolean.TRUE);
			} else {
				return false;
			}
		}
		return true;
	}
}
