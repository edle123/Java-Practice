package TechBeamers10_19;

public class Question17 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		System.out.println(array[1] + array[2] + array[3]);
		/*
		 * Output will be 234 because those are the values at those indices. If
		 * "javaQuestion17 1 2 3 4 5" were typed into a command line, the result would
		 * be the same if array weren't initialized and the calls to array were replaced
		 * with calls to args, e.g. array[1] would become args[1].
		 */
	}

}
