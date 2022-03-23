package TechBeamers20_30;

// Used in Quesiton30

public class Consumer {

	private int count = 0;

	public int nextCounter() {
		synchronized (this) {
			count++;
			return count;
		}
	}
}
