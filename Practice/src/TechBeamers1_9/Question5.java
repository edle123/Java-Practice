package TechBeamers1_9;

import java.util.Arrays;

public class Question5 {
	int i[] = { 0 };

	public static void main(String[] args) {
		int i[] = { 1 };
		// System.out.println(Arrays.toString(i));
		alter(i);
		System.out.println(i[0]);
		/*
		 * The output would be 1. If the desired output of alter is supposed to be 2,
		 * then the alter method should return an int array rather than having a void
		 * return. As it is now, alter does not change the int array passed through
		 * outside of the method. Perhaps this is related to scope?
		 */
	}

	public static void alter(int i[]) {
		int j[] = { 2 };
		i = j;
	}
}
