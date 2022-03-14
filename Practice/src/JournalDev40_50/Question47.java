package JournalDev40_50;

public class Question47 {

	public static void main(String[] args) {
		// Guess the Output of Code Snippets

		/*
		 * Output: abc x.concat(y) creates a new string "abcabc", but this new string is
		 * not assigned to any variable.
		 */
		String x = "abc";
		String y = "abc";
		x.concat(y);
		System.out.print(x);
	}

}
