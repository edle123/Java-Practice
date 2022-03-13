package JournalDev10_19;

public class Question16 {

	public static void main(String[] args) {
		// Create a Pyramid of Characters in Java?

		printPyramid(5);
	}

	public static void printPyramid(int rows) {
		for (int i = 1; i <= rows; i++) {
			int numberOfWhiteSpaces = rows - i;
			printString(" ", numberOfWhiteSpaces);
			printString("* ", i);
			System.out.println();
		}
	}
	
	public static void printString(String s, int count) {
		for (int i = 0; i < count; i++) {
			System.out.print(s);
		}
	}
}
