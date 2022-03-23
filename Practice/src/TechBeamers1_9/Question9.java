package TechBeamers1_9;

public class Question9 {

	public static void main(String[] args) {
		class Tutorial {
			public String name;

			public Tutorial(String tutorial) {
				name = tutorial;
			}
		}

		Object obj = new Tutorial("Java Quiz");
		Tutorial tutorial = (Tutorial) obj;
		System.out.println(tutorial.name);
		/*
		 * The program will output "Java Quiz". obj is already instantiated as a
		 * Tutorial object. tutorial is given the properties of an object that is
		 * already of the same type. If obj was instead an instance of the Object class,
		 * this would not be possible because an exception would be thrown when trying
		 * to convert obj to type Tutorial.
		 */
	}

}
