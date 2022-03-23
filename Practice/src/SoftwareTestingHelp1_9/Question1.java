package SoftwareTestingHelp1_9;

public class Question1 {
	public static void main (String[] args) {
		// Write a Java Program to reverse a string without using String inbuilt function.
		
		String test = "This is a test string";
		StringBuffer sb = new StringBuffer(test);
		sb = sb.reverse();
		String sbTest = sb.toString();
		System.out.println(test+"\n"+sbTest);
	}

}
