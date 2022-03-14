package JournalDev20_29;

public class Question27 {

	public static void main(String[] args) {
		// How to prove String is immutable programatically?
		String s1 = "Hello";
		String s2 = s1;

		System.out.println(s1 == s2); // Same reference
		s1 = "World";
		System.out.println(s1 == s2);
		// s1 points to a different location, s2 points to the original location
		System.out.println(s1);
		System.out.println(s2);
	}

}
