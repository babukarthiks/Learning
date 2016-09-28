/**
 * 
 */
package com.learning.util;

import java.util.Scanner;

/**
 * @author ks044388
 *
 */
public class Read {

	private static final Scanner scanner = new Scanner(System.in);

	// reads string
	public static <T extends Object> T read(ReadType readType) {

		if (readType == ReadType.LINE) {
			return (T) scanner.nextLine().trim();
		} else if (readType == ReadType.INT) {
			return (T) (Integer) scanner.nextInt();
		} else if (readType == ReadType.HASNEXT) {
			scanner.hasNextLine();
		}
		return null;
	}
}
