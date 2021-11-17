class Vehicle{
	protected String brand = "Ford"; //Vehicle attribute
	public void honk(){ 				// Vehicle method
		System.out.println("Honk honk!");
	}
}
class Car extends Vehicle{
	protected String modelName = "Mustang"; // Car attribute
}
public class Inheritance {

	public static void main(String[] args) {
		// Car Object
		Car myCar = new Car();
		myCar.honk();
		System.out.println(myCar.brand + " " + myCar.modelName);

	}

}
