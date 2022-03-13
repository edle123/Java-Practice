package JournalDev1_9;

import java.util.Stack;

public class Question1 {
	public static void main(String[] args) {
		// How to reverse a String in Java?
		String test = "I am a String.";
		
		// Method 1: Stack
		Stack <String>stack = new Stack<String>();
		String rev1 = "";
		for(int i = 0; i < test.length(); i++) {
			stack.push(Character.toString(test.charAt(i)));
		}
		while(!stack.empty()) {
			rev1 = rev1 + stack.pop();
		}
		
		// Method 2: StringBuffer
		StringBuffer sb = new StringBuffer(test);
		sb = sb.reverse();
		String rev2 = sb.toString();
		
		// Method 3: Array
		String rev3 = "";
		char[] charArray = new char[test.length()];
		for (int i = 0; i < test.length(); i++) {
			charArray[i] = test.charAt(i);
		}
		for (int i = charArray.length - 1; i >= 0; i--) {
			rev3 = rev3 + charArray[i];
		}
		System.out.println("Original string: " + test);
		System.out.println("Method 1: " + rev1);
		System.out.println("Method 2: " + rev2);
		System.out.println("Method 3: " + rev3);
	}
}
