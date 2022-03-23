package TechBeamers20_30;

import java.io.File;

public class Question23 {

	public static void main(String[] args) {
		File sys = new File("/MVC/system");
		System.out.print(sys.getParent());
		System.out.print(" " + sys.isFile());
		/*Output would be "\MVC false". system is within /MVC.*/
	}

}
