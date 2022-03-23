package SoftwareTestingHelp1_9;

public class Question8 {

	public static void main(String[] args) {
		// Write a Java Program to find whether a string or number is palindrome or not.

		System.out.println(isPalindrome(101));
		System.out.println(isPalindrome(11));
		System.out.println(isPalindrome(15));
		System.out.println(isPalindrome("mom"));
		System.out.println(isPalindrome("test"));
	}

	// Palindrome check for integers
	public static String isPalindrome(int number) {
		String status = "Number is palindrome";
		String string = number + "";
		int length = string.length();
		for (int i = 0; i < (length / 2); i++) {
			if (string.charAt(i) != string.charAt((length - 1) - i)) {
				status = "Number is not a palindrome";
				break;
			}
		}
		return status;
	}

	// Palindrome check for strings
	public static String isPalindrome(String word) {
		String result = word.toLowerCase();
		String status = "Word is palindrome";
		for (int i = 0; i < (result.length() / 2); i++) {
			if (result.charAt(i) != result.charAt((result.length() - 1) - i)) {
				status = "Word is not a palindrome";
				break;
			}
		}
		return status;
	}
}
