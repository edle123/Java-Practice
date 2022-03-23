package TechBeamers20_30;

public class Question28 {
	public static void main(String[] args) {
		try {
			args[0] = "0";
			return;
		} catch (Exception e) {
			System.out.print("Exception");
		} finally {
			System.out.print("Final");
			/*
			 * Output is "ExceptionFinal" because there are no arguments passed through to
			 * main, so args[0] does not exist to assign a value to.
			 */
		}
	}
}
