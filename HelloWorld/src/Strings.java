
public class Strings {

	public static void main(String[] args) {
		/* A String is an object, which has functions that can be
		   performed on it*/
		String txt = "ABCDEFG";
		System.out.println("The length of string txt is " + txt.length());
		System.out.println(txt.toUpperCase());
		System.out.println(txt.toLowerCase());
		System.out.println(txt.indexOf('G'));
		
		//Two ways to concatenate strings
		String firstName = "Eric";
		String lastName = "Kang";
		System.out.println(firstName + lastName);
		System.out.println(firstName.concat(lastName));
		
		//Adding two numbers returns a number
		int num1 = 1;
		int num2 = 2;
		System.out.println(num1+num2);
		
		//Concatenating two strings returns a string
		String string1 = "1";
		String string2 = "2";
		System.out.println(string1+string2);
		
		//Adding a number and a string results in a concatenation
		System.out.println(num1+string1);

	}

}
