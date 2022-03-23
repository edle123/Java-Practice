package SoftwareTestingHelp10_20;

public class Question16 {

	public static void main(String[] args) {
		// Write a Java Program to find the second-highest number in an array.

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] array2 = { 1, 1, 1, 1, 1 };
		int[] array3 = {5};
		System.out.println(secondHighest(array));
		System.out.println(secondHighest(array2));
		System.out.println(secondHighest(array3));
	}

	public static int secondHighest(int[] array) {
		int largest = array[0];
		int second = array[0];
		if (array.length == 1) {
			return array[0];
		} else {
			for (int i = 0; i < array.length; i++) {
				if (largest < array[i]) {
					second = largest;
					largest = array[i];
				}
			}
			return second;
		}
	}
}
