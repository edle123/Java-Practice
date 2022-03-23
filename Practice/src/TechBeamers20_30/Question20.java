package TechBeamers20_30;

public class Question20 {

	public static void main(String[] args) {
		Cluster tree = new Node1();
		if (tree instanceof Node1) {
			System.out.println("Node1");
		} else if (tree instanceof Cluster) {
			System.out.println("Cluster");
		} else if (tree instanceof Node2) {
			System.out.println("Node2");
		} else {
			System.out.println("Unexpected");
		}
		/*
		 * Output is "Node1". instanceof Node1 is the first statement checked, and since
		 * it is true, the other conditions aren't checked. If Cluster were checked
		 * before Node1, then "Cluster" would be output. tree is an instance of both
		 * Node1 and Cluster because tree is a Node1 object and Node1 extends Cluster.
		 */
	}
}
