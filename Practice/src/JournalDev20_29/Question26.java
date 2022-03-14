package JournalDev20_29;

import java.util.HashMap;

public class Question26 {

	public static void main(String[] args) {
		// How to get distinct characters and their count in a String?
		String s = "This is a test string";
		System.out.println(distinctCharacters(s));
	}

	public static HashMap<Character, Integer> distinctCharacters(String s) {
		/*
		 * HashMap<String, Integer> count = new HashMap<String, Integer>(); String
		 * string = s.toLowerCase();
		 * 
		 * for (int i = 0; i < string.length(); i++) {
		 * if(count.containsKey(Character.toString(string.charAt(i)))) { int value =
		 * count.get(Character.toString(string.charAt(i)));
		 * count.put(Character.toString(string.charAt(i)), value + 1); } else {
		 * count.put(Character.toString(string.charAt(i)), 1); } } return count;
		 */
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		String string = s.toLowerCase();

		for (int i = 0; i < string.length(); i++) {
			if (count.containsKey(string.charAt(i))) {
				int value = count.get(string.charAt(i));
				count.put(string.charAt(i), value + 1);
			} else {
				count.put(string.charAt(i), 1);
			}
		}
		return count;
	}
}
