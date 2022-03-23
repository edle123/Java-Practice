package SoftwareTestingHelp10_20;

public class Question18 {

	public static void main(String[] args) {
		// Write a Java Program to remove all white spaces from a string with using replace().
		
		String test = "\tThis is a test string";
		System.out.println(test);
		test = test.replaceAll("\\s", "");
		System.out.println(test);
	}
}
