package TechBeamers20_30;

public class Question21 {

	public static void main(String[] args) {
		String myString = new String("cplus");
		StringBuffer myBuffer = new StringBuffer(" plus");
		stringReplace(myString);
		bufferReplace(myBuffer);
		System.out.println(myString + myBuffer);
		/*
		 * Output is "cplus plus". Neither stringReplace nor bufferReplace changes the
		 * values of the parameters passed through.
		 */
	}

	public static void stringReplace(String str) {
		str = str.replace('c', 'c');
	}

	public static void bufferReplace(StringBuffer str) {
		str.trimToSize();
	}
}
