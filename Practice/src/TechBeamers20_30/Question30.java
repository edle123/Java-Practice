package TechBeamers20_30;

import java.util.Random;

public class Question30 {

	static int count = 0;

	public static void main(String[] args) throws InterruptedException {
		Consumer test = new Consumer();
		Producer prod1 = new Producer(test, "thread-1");
		Producer prod2 = new Producer(test, "thread-2");
		prod1.start();
		prod2.start();
		/*
		 * Sometimes thread-2 will precede thread-1. Perhaps it's based on the value
		 * that each gets from the random number they generate?
		 */
	}
}
