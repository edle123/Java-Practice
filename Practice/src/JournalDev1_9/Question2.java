package JournalDev1_9;

public class Question2 {

	public static void main(String[] args) {
		// How to swap two numbers without using a third variable?
		
		int x = 5, y = 10;
		System.out.println("OLD\nx = " + x +"\ny = " + y);
		x = x + y; // x becomes sum of x and y
		y = x - y; // y becomes old x
		x = x - y; // x becomes old y
		System.out.println("NEW\nx = " + x +"\ny = " + y);
	}

}
