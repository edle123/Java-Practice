package JournalDev40_50;

public class Question45 {

	public static void main(String[] args) {
		// Guess the Output of Code Snippets
		// What will be the boolean “flag” value to reach the finally block?

		/*
		 * The finally block will never be reached. If flag is true, it is stuck in an
		 * infinite loop. If flag is false, System.exit(1) is executed, exiting the JVM.
		 */
		try {
			if (flag) {
				while (true) {
				}
			} else {
				System.exit(1);
			}
		} finally {
			System.out.println("In Finally");
		}
	}

}
