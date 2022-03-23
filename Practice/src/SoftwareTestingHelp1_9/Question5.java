package SoftwareTestingHelp1_9;

import java.util.HashMap;
import java.util.Map;

public class Question5 {

	public static void main(String[] args) {
		// Write a Java Program to count the number of words in a string using HashMap.
		
		String test = "This is a test string";
		String[] words = test.split(" ");
		HashMap <String, Integer> map = new HashMap<String, Integer>();
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			if(map.containsKey(words[i])) {
				int value = map.get(words[i]);
				map.put(words[i], value + 1);
			}
			else {
				map.put(words[i], 1);
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			count += entry.getValue();
		}
		System.out.println("String test contains "+count+" words");
	}
}
