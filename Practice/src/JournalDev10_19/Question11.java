package JournalDev10_19;

public class Question11 {
	public static Question11 obj1 = new Question11();
	public static Question11 obj2 = new Question11();

	public static void main(String[] args) {
		// How to Create a Deadlock Scenario Programatically?

		Thread1 T1 = new Thread1();
		Thread2 T2 = new Thread2();
		T1.start();
		T2.start();
	}

	public static class Thread1 extends Thread {
		public void run() {
			synchronized (obj1) {
				System.out.println("Thread 1: Holding object 1");

				try {
					Thread.sleep(10);
				}

				catch (InterruptedException e) {
				}
				System.out.println("Thread 1: Waiting for object 2");
				synchronized (obj2) {
					System.out.println("Thread 1: Holding object 1 and object 2");
				}
			}
		}
	}

	public static class Thread2 extends Thread {
		public void run() {
			synchronized (obj2) {
				System.out.println("Thread 2: Holding object 2");

				try {
					Thread.sleep(10);
				}

				catch (InterruptedException e) {
				}
				System.out.println("Thread 2: Waiting for object 1");
				synchronized (obj1) {
					System.out.println("Thread 2: Holding object 1 and object 2");
				}
			}
		}
	}
}
