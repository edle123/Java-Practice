package JournalDev40_50;

public class Question43 {

	public static void main(String[] args) {
		// Guess the Output of Code Snippets

		/*Output: 6, ourn
		 * char is automatically type casted into int,
		 * so start + end becomes 6.
		 * The substring start from start (1) and 
		 * ends at the index before end (4)*/
		String s3 = "JournalDev";
		int start = 1;
		char end = 5;
		System.out.println(start + end);
		System.out.println(s3.substring(start, end));
	}

}
