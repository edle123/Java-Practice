package JournalDev30_39;

import java.util.Arrays;
import java.util.ArrayList;

public class Question37 {

	public static void main(String[] args) {
		// How to use forEach() method?
		
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		list.forEach(System.out::println);
	}

}
