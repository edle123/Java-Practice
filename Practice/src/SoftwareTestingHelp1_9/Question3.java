package SoftwareTestingHelp1_9;

public class Question3 {

	public static void main(String[] args) {
		// Write a Java Program to swap two numbers using the third variable.
		
		int x = 5;
		int y = 10;
		System.out.println(x+"\t"+y);
		int z = y;
		y = x;
		x = z;
		System.out.println(x+"\t"+y);
	}
}
