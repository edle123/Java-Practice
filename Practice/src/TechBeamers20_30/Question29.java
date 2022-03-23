package TechBeamers20_30;

public class Question29 {

	public static void main(String[] args) {
		int[] table = { 1, 2, 3, 4, 5 };
		table[1] = (table[2 * 1] == 2 - args.length) ? table[3] : 99;
		System.out.println(table[1]);
		/*
		 * Output is "99". The ternary operator. If the condition is false, then the
		 * code after : is executed, if it is true, the code between the ? and : is
		 * executed instead. table[2 * 1] is the same as table[2], which is 3. 2 -
		 * args.length is equal to 0, so that would be 3 == 2, which is false.
		 */
	}

}
