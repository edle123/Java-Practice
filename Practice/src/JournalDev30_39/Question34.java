package JournalDev30_39;

public class Question34 {

	public static void main(String[] args) {
		// Show example of switch expressions and multi-label case statements

		grade(95);
		grade(82);
		grade(78);
		grade(60);
		grade(24);
	}

	public static void grade(int score) {
		char grade = ' ';
		switch (score) {
		case 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90: {
			grade = 'A';
			break;
		}
		case 89, 88, 87, 86, 85, 84, 83, 82, 81, 80: {
			grade = 'B';
			break;
		}
		case 79, 78, 77, 76, 75, 74, 73, 72, 71, 70: {
			grade = 'C';
			break;
		}
		case 69, 68, 67, 66, 65, 64, 63, 62, 61, 60: {
			grade = 'D';
			break;
		}
		default:
			grade = 'F';
		}
		System.out.println(grade);
	}
}
