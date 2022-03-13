package JournalDev1_9;

public class Question9 {

	public static void main(String[] args) {
		// How to remove leading and trailing whitespaces from a string?
		
		String test = "\tThis is a test string\t";
		System.out.println(test);
		test = test.strip();
		System.out.println(test);
	}

}
