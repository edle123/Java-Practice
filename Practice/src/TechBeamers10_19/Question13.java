package TechBeamers10_19;

public class Question13 {

	public static void main(String[] args) {
		System.out.println(test());
		/*
		 * This would result in a compile time error. Java doesn't allow local variables
		 * (the float x in the test() method) to be declared as static.
		 */
	}

	static float test() {
		static float x = 0.0;
		return ++x;
	}
}
