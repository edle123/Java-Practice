package SoftwareTestingHelp10_20;

public class Question19 {

	public static void main(String[] args) {
		// Write a Java Program to remove all white spaces from a string without using replace().

		String test = "\tThis is a test string";
		System.out.println(test);
		StringBuilder sb = new StringBuilder(test);
		for (int i = 0; i < sb.length(); i++) {
			if(Character.isWhitespace(sb.charAt(i))) {
				sb.deleteCharAt(i);
			}
		}
		test = sb.toString();
		System.out.println(test);
	}

}
