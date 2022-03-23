package TechBeamers1_9;

public class Question6 {

	String args[] = { "1", "2" };

	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println(args.length);
			/*
			 * The program compiles, but prints nothing. It accesses the parameter args,
			 * rather than the String array declared outside of the main method.
			 */
		}
	}
}
