package JournalDev20_29;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Question21 {

	public static void main(String[] args) throws FileNotFoundException {
		// How to find if a string is present in a text file?
		System.out.println(check("Test", "test"));
		System.out.println(check("Test", "Hello"));
		System.out.println(check("FNF", "test"));
	}

	public static String check(String pathname, String str) {
		String check = "String is not found in file";
		try {
			File file = new File(pathname);
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				line.toLowerCase();
				if (line.contains(str.toLowerCase())) {
					scan.close();
					check = "String is found in file";
					break;
				}
			}
		} catch (FileNotFoundException e) {
			return "File not found";
		}
		return check;

	}
}
