package JournalDev40_50;

public class Question42 {

	public static void main(String[] args) {
		// Guess the Output of Code Snippets
		
		/*Output: false
		 * + operator has higher precedence than
		 * == operator, so "s1 == s2 is:abc" is
		 * compared to "abc" */
		String s1 = "abc";
		String s2 = "abc";
		System.out.println("s1 == s2 is:" + s1 == s2);
	}

}
