/**
 * Looks through links on the given site to identify which ones lead to youtube.com
 * 
 * @Eric
 * @version 1, February 12th, 2022
 */

import edu.duke.URLResource;

public class Part4 {
    public void findURL(){
        URLResource ur = 
            new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");

        String check = "youtube.com";
        int length = check.length();
        String link = "";
        for (String s : ur.words()){
            String lowerCheck = s.toLowerCase();
            int midIndex = lowerCheck.indexOf(check);
            if(midIndex != -1){
                int startIndex = s.lastIndexOf("\"",midIndex);
                int endIndex = s.indexOf("\"",midIndex+length);
                link = s.substring(startIndex+1,endIndex);
                System.out.println(link);
            }
        }
    }
}
