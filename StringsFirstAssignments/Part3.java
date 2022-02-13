
/**
 * The method twoOccurrences() checks to see if there are at least two occurences of one string
 * insde of another string.
 * The method lastPart() checks if one string is inside of another string. If it does
 * then the rest of the string after the first occurence of the initial string is output.
 * If not, then the entirety of the second string is output.
 * 
 * @Eric
 * @version 1, February 12th, 2022
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int count = 0;
        int length = stringa.length();
        int index = stringb.indexOf(stringa);
        if(index == -1){
            return false;
        }
        else{
            do{
                count++;
                index = stringb.indexOf(stringa, index+length);
            } while (index != -1);
            if(count>=2){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void testing(){
        boolean test1 = twoOccurrences("by", "A story by Abby Long");
        System.out.println("by, " + "A story by Abby Long : " + test1);

        System.out.println("a, " + "banana : " + twoOccurrences("a", "banana"));

        System.out.println("atg, " + "ctgtatgta : " + twoOccurrences("atg", "ctgtatgta"));

        System.out.println("an, " + "banana: " + lastPart("an", "banana"));
        System.out.println("zoo, " + "forest: " + lastPart("zoo", "forest"));
    }

    public String lastPart(String stringa, String stringb){
        int index = stringb.indexOf(stringa);
        int length = stringa.length();
        String lastPart = "";
        if(index == -1){
            lastPart = stringb;
        }
        else{
            lastPart = stringb.substring(index+length,stringb.length());
        }
        return lastPart;
    }
}
