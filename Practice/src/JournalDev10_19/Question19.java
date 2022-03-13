package JournalDev10_19;

import java.util.Arrays;

public class Question19 {
	public static void main(String[] args) {
		// Find second largest number in an array?
		int[] array1 = { 1, 2, 3 };
		int[] array2 = { 1, 1, 1 };
		System.out.println(Arrays.toString(array1));
		System.out.println(secondLargest(array1));
		System.out.println(Arrays.toString(array2));
		System.out.println(secondLargest(array2));
	}

	public static int secondLargest(int[] array) {
		int largest = 0;
		int secondLargest = 0;
		if (array.length <= 1) {
			return -1;
		} else {
			for (int i = 0; i < array.length; i++) {
				if (largest < array[i]) {
					secondLargest = largest;
					largest = array[i];
				}
				else if (secondLargest < array[i]){
					secondLargest = array[i];
				}
			}
			return secondLargest;
		}
	}
}
