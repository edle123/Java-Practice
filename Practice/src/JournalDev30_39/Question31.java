package JournalDev30_39;

public class Question31 {

	public static void main(String[] args) {
		// Write a code to show NullPointerException

		/*
		 * printString will try to call .toLowerCase() on a null value. A
		 * NullPointerException will be thrown since null has no value to perform the
		 * operation on.
		 */
		printString(null, 3);
	}

	public static void printString(String s, int count) {
		for (int i = 0; i < count; i++) {
			System.out.println(s.toLowerCase());
		}
	}
}
