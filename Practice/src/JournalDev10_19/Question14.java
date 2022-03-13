package JournalDev10_19;

import java.util.Arrays;

public class Question14 {

	public static void main(String[] args) {
		// How to implement Binary Search?
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Arrays.sort(array);
		System.out.println(BinarySearch(array, 0, array.length - 1, 5));
		System.out.println(BinarySearch(array, 0, array.length - 1, 15));
	}

	public static int BinarySearch(int[] array, int low, int high, int key) {
		int mid = (low + high) / 2;

		while (low <= high) {
			if (key > array[mid]) {
				low = mid + 1 ;
			} else if (key == array[mid]) {
				return mid;
			} else {
				high = mid - 1;
			}
			mid = (low + high) / 2;
		}
		return -1;
	}
}
