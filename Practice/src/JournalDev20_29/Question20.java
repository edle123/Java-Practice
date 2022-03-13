package JournalDev20_29;

import java.util.Random;
import java.util.Arrays;

public class Question20 {

	public static void main(String[] args) {
		// How to Shuffle an Array in Java?
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(Arrays.toString(array));
		shuffle(array);
		System.out.println(Arrays.toString(array));
	}

	public static void shuffle(int[] array) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			int random = rand.nextInt(array.length - 1);
			int temp = array[random];
			array[random] = array[i];
			array[i] = temp;
		}
	}
}
