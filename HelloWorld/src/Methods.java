
public class Methods {
	static void myMethod() {
		System.out.println("I just got executed!");
	}
	
	//This method requires a string parameter to be passed through
	static void myMethod1(String fname) {
		System.out.println(fname + " Kang");
	}
	
	//This method returns an int + 5
	static int myAdd(int x) {
		return x+5;	
	}
	
	//This method returns the sum of two parameters
	static int mySum(int x, int y) {
		return x+y;
	}
	
	/*his is a recursive method used to add the sum
	of numbers between the parameter and 0*/
	static int sum(int a) {
		if (a>0) {
			return a + sum(a-1);
		}
		else {
			return 0;
		}
	}

	public static void main(String[] args) {
		/*Methods can be executed multiple times
		myMethod();
		myMethod();
		myMethod();*/
		
		/*Methods can have parameters passed to them
		myMethod1("Eric");
		myMethod1("Diane");*/
		
		//System.out.println(myAdd(5));
		
		/*Returns the sum of two parameters
		System.out.println(mySum(5,5));
		int z = mySum(5,5);
		System.out.println(z);*/
		
		int result = sum(3);
		System.out.println(result);
	}

}
