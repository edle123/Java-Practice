package JournalDev40_50;

import java.io.IOException;

public class Question49 {

	public static void main(String[] args) {
		// Guess the Output of Code Snippets

		/*
		 * Compile-Time Error. The try block already throws the same exception as the
		 * catch block.
		 */
	}

	public class Test {

		public static void main(String[] args) {
			try {
				throw new IOException("Hello");
			} catch (IOException | Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
