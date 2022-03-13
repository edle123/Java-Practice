package JournalDev1_9;

import java.util.ArrayList;

public class Question6 {
	public static void main(String[] args) {
		//Check if a List of integers contains only odd numbers?
		
		ArrayList<Integer> even = new ArrayList<Integer>();
		even.add(2);
		even.add(4);
		even.add(6);
		even.add(8);
		even.add(10);
		
		ArrayList<Integer> odd = new ArrayList<Integer>();
		odd.add(1);
		odd.add(3);
		odd.add(5);
		odd.add(7);
		odd.add(9);
		
		ArrayList<Integer> both = new ArrayList<Integer>(even);
		for(int i = 0; i < odd.size(); i++) {
			both.add(odd.get(i));
		}
		
		System.out.println(checkOdd(even));
		System.out.println(checkOdd(odd));
		System.out.println(checkOdd(both));
	}
	
	public static String checkOdd(ArrayList<Integer> list) {
		String check = "";
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) % 2 == 0) {
				count++;
			}
		}
		if (count == 0) {
			check = "This list only contains odd numbers";
		}
		else {
			check = "This list contains an even number";
		}
		return check;
	}

}
