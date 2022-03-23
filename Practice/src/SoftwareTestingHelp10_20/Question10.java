package SoftwareTestingHelp10_20;

import java.util.ArrayList;
import java.util.Iterator;

public class Question10 {

	public static void main(String[] args) {
		// Write a Java Program to iterate ArrayList using for-loop, while-loop, and advance for-loop.
		
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			Integer wrap = Integer.valueOf(array[i]);
			list.add(wrap);
		}
		// For-loop
		System.out.println("For-loop");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// While-loop
		System.out.println("While-loop");
		Iterator iter = list.listIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		// Advanced for-loop, for-each loop
		System.out.println("For-each loop");
		for (int i : list) {
			System.out.println(i);
		}
	}

}
