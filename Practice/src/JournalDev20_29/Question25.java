package JournalDev20_29;

public class Question25 {

	public static void main(String[] args) {
		// remove all occurrences of a given character from input String?
		String test = "This is a test string";
		System.out.println(test);
		System.out.println(removeChar(test, 'i'));
		System.out.println(removeChar(test, 't'));
	}

	public static String removeChar(String s, char c) {
		StringBuilder sb = new StringBuilder(s);
		for(int i = 0; i < sb.length(); i++) {
			if(Character.toLowerCase(sb.charAt(i)) == Character.toLowerCase(c)) {
				sb.deleteCharAt(i);
			}
		}
		String result = sb.toString();
		return result;
	}
}
