package JournalDev40_50;

import java.util.HashSet;

public class Question44 {

	public static void main(String[] args) {
		// Guess the Output of Code Snippets
		
		/*Output: 100
		 *Adding short to shortSet autmoically converts it to
		 *a short object. i - 1 is converted to an int and
		 *wrapped into an Integer object. Since there
		 *is no Integer objects in shortSet, nothing is removed,
		 *so the size of shortSet is 100.*/
		HashSet shortSet = new HashSet();
		for (short i = 0; i < 100; i++) {
			shortSet.add(i);
			shortSet.remove(i - 1);
		}
		System.out.println(shortSet.size());
	}

}
