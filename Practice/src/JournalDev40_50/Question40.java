package JournalDev40_50;

import java.util.Arrays;
import java.util.ArrayList;

public class Question40 {

	public static void main(String[] args) {
		// Show an example of using lambda expressions in Java
		
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		System.out.println(list);
		list.forEach((n) -> {System.out.println(n*n);});
	}
}
