package TechBeamers10_19;

import java.io.CharArrayReader;
import java.io.IOException;

public class Question12 {

	public static void main(String[] args) {
		String obj = "abcdef";
		int length = obj.length();
		char c[] = new char[length];
		obj.getChars(0, length, c, 0);
		CharArrayReader io_1 = new CharArrayReader(c);
		CharArrayReader io_2 = new CharArrayReader(c, 1, 4);
		int i, j;
		try {
			while ((i = io_1.read()) == (j = io_2.read())) {
				System.out.print((char) i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * Nothing will be printed. io_2 starts at offset 1 instead of 0, so none of the
		 * indices match with io_1.
		 */
	}
}