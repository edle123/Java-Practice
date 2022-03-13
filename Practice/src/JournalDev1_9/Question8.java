package JournalDev1_9;

public class Question8 {

	public static void main(String[] args) {
		// How to remove Whitespaces from String
		
		String test = "This is a test string.";
		StringBuilder sb = new StringBuilder(test);
		for (int i = 0; i < sb.length(); i++) {
			if (Character.isWhitespace(sb.charAt(i))) {
				sb.deleteCharAt(i);
			}
		}
		String sbtest = sb.toString();
		System.out.println(test);
		System.out.println(sbtest);
	}
}
