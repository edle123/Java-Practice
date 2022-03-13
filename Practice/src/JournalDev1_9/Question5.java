package JournalDev1_9;

public class Question5 {

	public static void main(String[] args) {
		// Fibonacci Series using recursion

		int n = 10;
		//fibonacciSeries(n);
		//System.out.println(fibonacci(n));
		printFibonacci(n);
	}

	// Non-recursive fibonacci
	public static void fibonacciSeries(int count) {
		int x = 0;
		int y = 1;
		int z = 1;
		if (count < 1) {
			System.out.println(count);
		} else {
			for (int i = 1; i <= count; i++) {
				System.out.println(x);
				x = y;
				y = z;
				z = x + y;
			}
		}
	}

	// Find element at the index of count for fibonacci series
	public static int fibonacci(int count) {
		if (count <= 1) {
			return count;
		} else {
			return fibonacci(count - 1) + fibonacci(count - 2);

		}
	}
	
	//Prints results from the fibonacci method. Fibonacci method is recursive.
	public static void printFibonacci(int count) {
		for (int i = 0; i < count; i++) {
			System.out.println(fibonacci(i));
		}
	}
}
