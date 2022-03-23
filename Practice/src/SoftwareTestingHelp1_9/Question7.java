package SoftwareTestingHelp1_9;

public class Question7 {

	public static void main(String[] args) {
		// Write a Java Program to find whether a number is prime or not.

		System.out.println(isPrime(50));
		System.out.println(isPrime(29));
	}

	public static String isPrime(int number) {
		String status = "Number is prime";
		for (int i = 2; i <= (number/2); i++) {
			if(number % i == 0) {
				status = "Number is not prime";
				break;
			}
		}
		return status;
	}
}
