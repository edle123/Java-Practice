package JournalDev1_9;

public class Question4 {

	public static void main(String[] args) {
		// Java program to check if the given number is Prime?
		
		int x = 50;
		int y = 29;
		
		System.out.println(primeCheck(x));
		System.out.println(primeCheck(y));
	}
	
	public static String primeCheck(int number) {
		for (int i = 2; i <= (number / 2); i++) {
			if(number % i == 0) {
				return "Number is not prime";
			}
		}
		return "Number is prime";
	}

}
