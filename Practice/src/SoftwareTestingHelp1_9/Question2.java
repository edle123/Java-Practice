package SoftwareTestingHelp1_9;

import java.util.Stack;

public class Question2 {

	public static void main(String[] args) {
		// Write a Java Program to reverse a string without using String inbuilt function reverse().
		
		String test = "This is a test string";
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < test.length(); i++) {
			stack.push(test.charAt(i));
		}
		System.out.println(test);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

}
