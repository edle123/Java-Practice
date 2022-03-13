package JournalDev10_19;

import java.util.HashSet;

public class Question17 {
	public static void main(String[] args) {
		// Check if two arrays contains same elements?

		int[] array = { 1, 2, 3 };
		int[] array2 = { 1, 1, 2, 2, 3, 3 };
		int[] array3 = { 1, 2, 3, 4 };

		System.out.println(compare(array, array2));
		System.out.println(compare(array, array3));
	}

	public static String compare(int[] array1, int[] array2) {
		String comparison = "These arrays contain the same elements";
		HashSet<Integer> hs1 = new HashSet<Integer>();
		HashSet<Integer> hs2 = new HashSet<Integer>();

		for (int i = 0; i < array1.length; i++) {
			hs1.add(array1[i]);
		}
		for (int i = 0; i < array2.length; i++) {
			hs2.add(array2[i]);
		}
		
		if (hs1.size() != hs2.size()) {
			comparison = "These arrays do not contain the same elements";
		} else {
			for (Object obj : hs1) {
				if (!hs2.contains(obj)) {
					comparison = "These arrays do not contain the same elements";
				}
			}
		}
		return comparison;
	}
}
