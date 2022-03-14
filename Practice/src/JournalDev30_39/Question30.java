package JournalDev30_39;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Question30 {

	public static void main(String[] args) {
		// Write a Program to show try catch example?

		/*
		 * Creates FileInputStream object (fis) from file named "Test" and if "Test" is
		 * not found, the system outputs the line "File not found"
		 */
		try {
			FileInputStream fis = new FileInputStream("Test");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

	}

}
