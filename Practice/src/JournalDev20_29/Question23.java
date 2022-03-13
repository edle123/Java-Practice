package JournalDev20_29;

import java.util.ArrayList;

public class Question23 {
	public static void main(String[] args) {
		// How to merge two lists in java?
		
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 6, 7, 8, 9, 10 };
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for(int i = 0; i < array1.length; i++) {
			Integer Int = Integer.valueOf(array1[i]);
			list1.add(Int);
		}
		for(int i = 0; i < array2.length; i++) {
			Integer Int = Integer.valueOf(array2[i]);
			list2.add(Int);
		}
		ArrayList<Integer> list3 = new ArrayList<Integer>(list1);
		list3.addAll(list2);
		System.out.println(list1 + "\n" + list2 + "\n" + list3);
	}
}
