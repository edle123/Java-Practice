package TechBeamers1_9;

public class Question7 {

	public static void main() {
		int odd = 1;
		if (odd) {
			System.out.println("odd");
		} else {
			System.out.println("even");
			/*
			 * Type mismatch error. odd is an int, so it cannot be used in the if statement
			 * because that requires a boolean.
			 */
		}
	}
}
