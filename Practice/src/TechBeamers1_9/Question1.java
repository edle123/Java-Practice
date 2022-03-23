package TechBeamers1_9;

public class Question1 extends Super {

	public Question1(int index) {
		index = index;
	}

	public static void main(String[] args) {
		Question1 q1 = new Question1(10);
		System.out.println(q1.index);
		/*
		 * Output is 1. index is initialized with a value of 1 in the super class, and
		 * the constructor taking in the argument for an int has a paramater name that
		 * is the same as the variable name, so the line index = index makes no change
		 * to the index variable. To avoid this, change the paramater name to be
		 * different from the variable name. Alternatively, the assignment can be
		 * rewritten as "this.index = index".
		 */
	}
}
