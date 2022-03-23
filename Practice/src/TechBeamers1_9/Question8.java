package TechBeamers1_9;

public class Question8 {

	public static void main(String[] args) {
		test(true, true);
		test(true, false);
		test(false, true);
		test(false, false);
		/*
		 * Output is A, A, None, !B. If A is ever true, then the if block is executed,
		 * therefore the else if block is NEVER executed. If A is false, then the else
		 * block will be executed. The else.else block is executed when A is false and B
		 * is true, and the else.if block is executed when both A and B is false.
		 */
	}

	public static void test(boolean a, boolean b) {
		if (a) {
			System.out.println("A");
		} else if (a && b) {
			System.out.println("A && B");
		} else {
			if (!b) {
				System.out.println("!B");
			} else {
				System.out.println("None");
			}
		}
	}
}
