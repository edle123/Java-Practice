package JournalDev10_19;

import java.util.Arrays;

public class Question15 {

	public static void main(String[] args) {
		// Merge Sort in Java?

		int[] array = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };
		int length = array.length;
		// int[] merged = mergeSort(array, 0, array.length - 1);

		System.out.println(Arrays.toString(array));
		mergeSort(array, 0, length - 1);
		System.out.println(Arrays.toString(array));
	}

	public static void mergeSort(int[] array, int low, int high){
		if (low < high) {
			int mid = (low + high ) / 2;
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}

	public static void merge(int[] array, int low, int mid, int high) {
		int a = 0, b = 0, c = 0;
		int n1 = mid - low + 1;
		int n2 = high - mid;

		int[] firstArray, secondArray;
		firstArray = new int[n1];
		secondArray = new int[n2];

		for (int i = 0; i < n1; i++) {
			firstArray[i] = array[low + i];
		}
		for (int i = 0; i < n2; i++) {
			secondArray[i] = array[mid + 1 + i];
		}
		a = 0;
		b = 0;
		c = low;

		while (a < n1 && b < n2) {
			if (firstArray[a] <= secondArray[b]) {
				array[c] = firstArray[a];
				a++;
			} else {
				array[c] = secondArray[b];
				b++;
			}
			c++;
		}

		while (a < n1) {
			array[c] = firstArray[a];
			a++;
			c++;
		}

		while (b < n2) {
			array[c] = secondArray[b];
			b++;
			c++;
		}
	}
}
