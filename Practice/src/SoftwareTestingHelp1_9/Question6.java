package SoftwareTestingHelp1_9;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Question6 {

	public static void main(String[] args) {
		// Write a Java Program to iterate HashMap using While and advance for loop.
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("Mario", 3);
		map.put("Luigi", 5);
		map.put("Peach", 10);
		map.put("Daisy", 8);
		Iterator iter = map.entrySet().iterator();
		int count = 0;
		// While loop
		while(iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		// Advanced for-loop, for-each loop
		for(Map.Entry<String,Integer> entry : map.entrySet()) {
			count += entry.getValue();
		}
		System.out.println(count);
	}

}
