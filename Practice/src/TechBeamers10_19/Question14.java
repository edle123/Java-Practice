package TechBeamers10_19;

public class Question14 {
	static int index = 0;

	public static void main(String[] args) {
		System.out.println(test());
		/*This would result in a compile time error. test() is a non-static
		 * method and cannot be called from within a static method.*/
	}

	int test() {
		int index = 1;
		return index;
	}
}
