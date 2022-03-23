package TechBeamers10_19;

public class Question16 {

	public static void main(String[] args) {
		int index = 0;
		boolean flag = true;
		boolean reg1 = false, reg2;
		reg2 = (flag | ((index++) == 0));
		reg2 = (reg1 | ((index += 2) > 0));

		System.out.println(index);
		/*
		 * Output is 3. Perhaps becuse index++ and index += 2 will be executed
		 * regardless of the values of flag and reg1?
		 */
	}

}
