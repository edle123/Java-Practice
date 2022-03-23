package TechBeamers20_30;

public class Question25 {

	public static void main(String[] args) {
		String text = "199";
		try {
			text = text.concat(".5");
			double decimal = Double.parseDouble(text);
			text = Double.toString(decimal);
			int status = (int) Math.ceil(Double.valueOf(text).doubleValue());
			System.out.println(status);
		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
			/*
			 * Output would be "200". text starts as "199", then is concatenated to "199.5",
			 * then is converted to the double "199.5", then converted to the String
			 * "199.5", which is then converted to the int "200" because Math.ceil was used.
			 */
		}
	}
}
