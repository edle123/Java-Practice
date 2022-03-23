package SoftwareTestingHelp1_9;

public class Question4 {

	public static void main(String[] args) {
		// Write a Java Program to swap two numbers without using the third variable.
		
		int x = 5;
		int y = 10;
		System.out.println(x+"\t"+y);
		x += y;
		y = x - y;
		x = x - y;
		System.out.println(x+"\t"+y);
	}
}
