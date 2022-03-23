package TechBeamers1_9;

public class Question2 {
	public static void main(String[] args) {
		TestApp app = new TestApp();
		System.out.println(app.x + " " + app.y);
		/*
		 * x and y are protected variables found in TestApp. Since TestApp is within the
		 * same package, Question2 has access to these variables. Since x and y have not
		 * been initialized, they are given the default values of 0. So, 0 0 is the
		 * output.
		 */
	}
}
