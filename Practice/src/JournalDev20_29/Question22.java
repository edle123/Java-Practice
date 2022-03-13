package JournalDev20_29;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Question22 {

	public static void main(String[] args) {
		// How to print date in specific format?
		String pattern = "yyyy/MM/dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date());
		System.out.println(date);
	}
}
