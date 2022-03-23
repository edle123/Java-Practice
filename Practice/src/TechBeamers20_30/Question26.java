package TechBeamers20_30;

public class Question26 {

	public static void main(String[] args) {
		String initial = "ABCDEFG", after = "";
		after = initial = initial.replace('A', 'Z');
		System.out.println(initial + ", " + after);
		/*
		 * Output is "ZBCDEFG, ZBCDEFG". Assignment operators are evaluated right to
		 * left, so initial is changed, then after is assigned the value of iniital.
		 */
	}

}
