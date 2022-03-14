package JournalDev20_29;

public class Question28 {
	// Write a Program to showcase inheritance?

	public class Vehicle{
		String movement;
		int wheels;
		public void sound() {
			
		}
	}
	
	public class Car extends Vehicle{
		int wheels = 4;
		public void sound() {
			System.out.println("Honk");
		}
	}
}
