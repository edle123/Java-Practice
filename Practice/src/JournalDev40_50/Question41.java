package JournalDev40_50;

public class Question41 {
	// Show examples of overloading and overriding in Java

	public class Vehicle {
		public void sound() {

		}

		public void printString(String s) {
			System.out.println(s);
		}

		/*
		 * Overload: Method with same name, but different signature. In this case, this
		 * method shares its name with another method, but takes a different amount of
		 * parameters.
		 */
		public void printString(String s, int count) {
			for (int i = 0; i < count; i++) {
				System.out.println(s);
			}
		}
	}

	public class Car extends Vehicle {

		/*
		 * Override: Child class uses different implementation of method from superclass
		 * with same method signatures
		 */
		@Override
		public void sound() {
			System.out.println("Honk");
		}
	}

}