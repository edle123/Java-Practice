package SoftwareTestingHelp10_20;

public class Question17 {

	public static void main(String[] args) {
		// Write a Java Program to check Armstrong number.
		
		System.out.println(checkArmstrong(153));
		System.out.println(checkArmstrong(1634));
		System.out.println(checkArmstrong(1));
		System.out.println(checkArmstrong(20));
	}

	public static String checkArmstrong(int x) {
		String string = x + "";
		char[] charArray = string.toCharArray();
		int[] intArray = new int[charArray.length];
		int length = intArray.length;
		int sum = 0;
		for(int i = 0; i < charArray.length; i++) {
			intArray[i] = Character.getNumericValue(charArray[i]);
		}
		for (int i = 0; i < length; i++) {
			int value = intArray[i];
			int current = value;
			for (int j = 1; j < length; j++) {
				current = current * value;
			}
			sum += current;
		}
		if(sum == x) {
			return x + " is an Armstrong number";
		}
		else {
			return x + " is not an Armstrong number";
		}
	}
}
