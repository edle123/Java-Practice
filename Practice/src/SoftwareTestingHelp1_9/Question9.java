package SoftwareTestingHelp1_9;

public class Question9 {

	public static void main(String[] args) {
		// Write a Java Program for the Fibonacci series.

		fibonacci(10);
	}

	public static void fibonacci(int number) {
		int x = 0;
		int y = 1;
		int z = 1;
		if (number <= 1) {
			System.out.println(x);
		}
		else if (number == 2) {
			System.out.println(x+" "+y);
		}
		else {
			for (int i = 1; i <= number; i++) {
				System.out.println(x);
				x = y;
				y = z;
				z = x + y;
			}
		}
	}
}
