package TechBeamers10_19;

public class Question15 {

	public static void main(String[] args) {
		int bits;

		/*
		 * Arithmetic shift right, signed
		 * Divide by 2
		 * -3 => -2
		 */
		bits = -3 >> 1;
		System.out.println(bits);

		/*
		 * Logical shift right, unsigned
		 * Divide by 2^2
		 * -2 => 1073741823
		 */
		bits = bits >>> 2;
		System.out.println(bits);

		/*
		 * Signed shift left
		 * Multiply by 2
		 * 1073741823 => 2147483646
		 */
		bits = bits << 1;
		System.out.println(bits);
		/* Output is 2147483646 */
	}
}
