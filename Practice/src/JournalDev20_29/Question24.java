package JournalDev20_29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Question24 {
	public static void main(String[] args) {
		// How to Sort HashMap by values?

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Mario", 5);
		map.put("Luigi", 1);
		map.put("Peach", 3);
		map.put("Daisy", 15);

		System.out.println("Original HashMap: "+ map);
		map = sortByValue(map);
		System.out.println("Sorted HashMap: "+ map);
		map.clear();
	}

	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> map) {
		//HashMap sorted to be returned by function
		LinkedHashMap<String, Integer> sorted = new LinkedHashMap<String,Integer>();
		
		//Set containing all of the entries found in map
		Set<Entry<String,Integer>> entry = map.entrySet();
		
		//ArrayList containing all entries in entry
		ArrayList<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>(entry);
		
		//Sorts entries of list based on their values
		list.sort((x,y) -> x.getValue().compareTo(y.getValue()));
		
		//Loop that puts all entries in list into the sorted HashMap
		for(Entry<String,Integer> e : list) {
			sorted.put(e.getKey(), e.getValue());
		}
		
		//Return sorted HashMap
		return sorted;
	}
}
