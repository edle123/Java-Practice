package TechBeamers10_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question18 {

	public static void main(String[] args) throws IOException {
		char bit;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			bit = (char) br.read();
			System.out.print(bit);
		} while (bit != 'q');
		/*
		 * If java Question18 abcqfghqbcd were executed on command line, the output
		 * would be "abcq". bit is set to q during the fourth character, then the bit is
		 * output. Since bit is now equal to q, the do-while loop does not execute
		 * again.
		 */
	}
}
