package TechBeamers20_30;

// Used in Question30

import java.util.Random;

public class Producer extends Thread{
	Consumer test;
	String message;
	
	Producer(Consumer test, String mag){
		this.test = test;
		message = mag;
	}
	
	public void run() {
		Random rand = new Random();
		int randomNum = rand.nextInt((1000-10)+1) + 10;
		System.out.println(message);
	}
}
