
/**
 * Write a description of Part2 here.
 * 
 * @Eric
 * @version 1, February 12th, 2022
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int count = 0;
        int length = stringa.length();
        int startIndex = stringb.indexOf(stringa, 0);
        String remaining = stringb;
        if (startIndex == -1){
            return count;
        }
        else{
            while (startIndex !=-1){ 
                count++;
                remaining = remaining.substring(startIndex + length);
                startIndex = remaining.indexOf(stringa, 0);
            }
            return count;
        }
    }

    public void testHowMany(){
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println(howMany("AA", "ATAAAA"));
        System.out.println(howMany("A", "AAAAA"));
        System.out.println(howMany("A", "BCDEF"));
    }
}
