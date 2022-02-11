
public class TypeCasting {

	public static void main(String[] args) {
		// Widening casting is done automatically
		int myInt = 8;
		double myDouble = myInt;
		System.out.println(myDouble);
		
		/*Narrowing is done manually by typing the type
		in parentheses before the variable*/
		double myDouble2 = 17.0;
		int myInt2 = (int) myDouble2;
		System.out.println(myInt2);

	}

}
