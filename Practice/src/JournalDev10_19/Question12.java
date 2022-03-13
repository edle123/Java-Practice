package JournalDev10_19;

public class Question12 {

	public static void main(String[] args) {
		// Find factorial of an integer?
		
		int n = 6;
		System.out.println(factorial(n));
		System.out.println(factorial2(n));
	}

	//Method 1: Recursion
	public static int factorial (int number) {
		if (number <= 1) {
			return 1;
		}
		else {
			return (number * factorial(number - 1));
		}
	}
	
	//Method 2: Loop
	public static int factorial2 (int number) {
		int fact = number;
		if (number <= 1) {
			return 1;
		}
		else {
			for (int i = number; i > 1 ; i--) {
				fact = fact * (i - 1);
			}
		}
		return fact;
	}
}
