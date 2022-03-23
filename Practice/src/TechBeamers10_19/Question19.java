package TechBeamers10_19;

import java.io.File;

public class Question19 {

	public static void main(String[] args) {
		File sys = new File("/java/system");
		System.out.print(sys.canWrite());
		System.out.println(" " + sys.canRead());
		/* Output would be "false false". */
	}

}
