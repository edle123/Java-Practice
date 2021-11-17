
public class Variables {

	public static void main(String[] args) {
		//The variable name is assigned the value "Eric"
		String name = "Eric";
		System.out.println(name);
		
		//The variable x is assigned the value 8
		int x = 8;
		System.out.println(x);
		
		//The variable y is created and assigned the value later
		int y;
		y = 17;
		System.out.println(y);
		
		//The variable z is assigned a value, which is later overwritten
		int z = 8;
		z = 26;
		System.out.println(z);
		
		/*The keyword final is used to make a variable unable to be overwritten
		final int myNum = 35;
		myNum = 8;
		System.out.println(myNum);*/
		
		//The + character can combine the value of variables
		System.out.println("Hello " + name);
		String last = "Kang";
		String fullName = name + " " + last;
		System.out.println(fullName);
		System.out.println(x + y);
		
		//It is possible to declare many variables at once
		int a = 8, b = 17, c = 26;
		System.out.println(a + b + c);
	}

}
