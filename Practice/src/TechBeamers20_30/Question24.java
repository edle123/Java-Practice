package TechBeamers20_30;

public class Question24 {
	static int test;boolean final()
	{
		test++;
		return true;
	}

	public static void main(String[] args) {
		test = 0;
		if ((final() | final()) || final()) {
			test++;
		}
		System.out.println(test);
		/*Compilation error. Cannot use keywords as method names.*/
	}

}
