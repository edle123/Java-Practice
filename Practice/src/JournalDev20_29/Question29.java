package JournalDev20_29;

public class Question29 {
	// Write a Program to Show Diamond Problem with Multiple Inheritance?

	interface I {
		void sound();
	}

	class A implements I {
		public void sound() {

		}
	}

	class B implements I {
		public void sound() {

		}
	}

	/*
	 * Java doesn't allow inheritance from multiple classes because if both classes
	 * override the same method and the class that inherits both of the two classes
	 * does not override that method, then there is ambiguity over which super class
	 * the child class inherits the method from
	 */
	class C extends A,B{

		public void sound() {
			super.sound();
		}
	}
}
