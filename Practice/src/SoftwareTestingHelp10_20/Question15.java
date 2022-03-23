package SoftwareTestingHelp10_20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Question15 {

	public static void main(String[] args) {
		// Write a Java Program to find the duplicate characters in a string.
		
		String test = "This is a test string";
		test = test.toLowerCase();
		char[] array = test.toCharArray();
		System.out.println(Arrays.toString(array));
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < array.length; i++) {
			if(map.containsKey(array[i])) {
				int value = map.get(array[i]);
				map.put(array[i], value + 1);
			}
			else {
				map.put(array[i], 1);
			}
		}
		System.out.println(map);
		System.out.println("Duplicate characters in string: ");
		for(Entry<Character,Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.print(entry.getKey()+" ");
			}
		}
	}
}
