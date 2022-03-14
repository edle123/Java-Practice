package JournalDev40_50;

public class Question46 {

	public static void main(String[] args) {
		// Guess the Output of Code Snippets

		/*
		 * NullPointerException. It is not possible to perform .equals() on a null
		 * String.
		 */
		String str = null;
		String str1 = "abc";
		System.out.println(str1.equals("abc") | str.equals(null));
	}

}
