package JournalDev30_39;

public interface Question38 {
	// Write an interface with default and static method?
	
	default String turnAlarmOn(){
		return "Turning alarm on.";
	}
	static boolean isNull(String s){
		if (s == null) {
			return true;
		}
		else {
			return false;
		}
	}
}
