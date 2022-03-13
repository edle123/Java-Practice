package JournalDev1_9;

public class Question3 {
	public static void main (String[] args) {
		// Java Program to check if a vowel is present in the string?
		String noVowel = "bcdfghjklmnpqrstvwxyz";
		String vowel = "aeiou";
		String test = vowel;
		int count = 0;
		
		//Method 1
		for (int i = 0; i < test.length(); i++) {
			if(test.charAt(i) == 'a' || test.charAt(i) == 'e' || test.charAt(i) == 'i'
					|| test.charAt(i) == 'o' || test.charAt(i) == 'u') {
				count++;
			}
		}
		System.out.println(vowelCheck(count));
		
		//Method 2
		count = 0;
		for (int i = 0; i < test.length(); i++) {
			int index = vowel.indexOf(test.charAt(i));
			if (index != -1) {
				count++;
			}
		}
		System.out.println(vowelCheck(count));
	}
	
	public static String vowelCheck (int count) {
		String check = "";
		if(count == 0) {
			check = "String does not contain a vowel";
		}
		else {
			check = "String contains a vowel";
		}
		return check;
	}

}
