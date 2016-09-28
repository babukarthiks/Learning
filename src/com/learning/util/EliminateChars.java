package com.learning.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EliminateChars {

	public static void main(String[] args) throws IOException {
		// File file = new File("/file.txt");
		BufferedReader reader = new BufferedReader(
				new FileReader("/Users/ks044388/KarthikPrep/Learning/src/com/learning/util/file"));
		File output = new File("/Users/ks044388/KarthikPrep/Learning/src/com/learning/util/output.txt");
		PrintWriter writer = new PrintWriter(output);

		String line = reader.readLine();

		while (line != null) {
			if (line.length() > 3) {
				String s = line.substring(3);
				writer.write(s);
				writer.write("\n");
			}
			line = reader.readLine();
		}
		writer.close();
		reader.close();
	}

}
