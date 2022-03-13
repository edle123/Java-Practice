package JournalDev1_9;

import java.util.ArrayList;

public class Question7 {

	public static void main(String[] args) {
		// Palindrome Check

		// reviver, racecar, madam, and refer.

		ArrayList<String> palindrome = new ArrayList<String>();
		palindrome.add("redivider");
		palindrome.add("deified");
		palindrome.add("civic");
		palindrome.add("radar");
		palindrome.add("level");
		palindrome.add("rotor");
		palindrome.add("kayak");
		palindrome.add("reviver");
		palindrome.add("racecar");
		palindrome.add("madam");
		palindrome.add("refer");
		palindrome.add("dad");
		palindrome.add("mom");

		for (String word : palindrome) {
			System.out.println(word);
			int half = word.length() / 2;
			int full = word.length();
			String status = word + " is a palindrome";

			for (int i = 0; i <= half; i++) {
				if (word.charAt(i) != word.charAt((full - 1) - i)) {
					status = word + " is not a palindrome";
					break;
				}
			}
			System.out.println(status);
		}
		
		String test = "Test";
		String status = test + " is a palindrome";
		int half = test.length() / 2;
		int full = test.length();
		
		System.out.println(test);
		for (int i = 0; i < half; i++) {
			if (test.charAt(i) != test.charAt((full - 1) - i)) {
				status = test + " is not a palindrome";
				break;
			}
		}
		System.out.println(status);
		
	}

}
