package TechBeamers20_30;

public class Question27 {

	public static void main(String[] args) {
		String str = (String) returnStringAsArray()[-1 + 1 * 2];
		System.out.println(str);
		/*
		 * Output will be "Quiz". Order of operations dictates that * has more
		 * precedence than +, so "-1 = 1 * 2" equates to 1, and the value at index 1 is
		 * "Quiz".
		 */
	}

	public static Object[] returnStringAsArray() {
		return new String[] { "Java", "Quiz" };
	}
}
