package JournalDev10_19;

import java.util.LinkedList;

public class Question13 {

	public static void main(String[] args) {
		// Reverse a Linked List?
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		LinkedList<Integer> reverse = new LinkedList<Integer>();

		list.descendingIterator().forEachRemaining(reverse::add);

		System.out.println("Original linked list: " + list);
		System.out.println("Reversed linked list: " + reverse);
	}
}
