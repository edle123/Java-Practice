
/**
 * Counts the occurences of the different lengths of words found in a selected word
 * 
 * @Eric
 * @version 1, February 24th, 2022
 */
import edu.duke.FileResource;

public class WordLengths {
    public void countWordLengths(FileResource resource, int[] counts){
        for (String words : resource.words()){
            int length = words.length();
            if(Character.isLetter(words.charAt(0)) == false){
                length -= 1;
            }
            if(Character.isLetter(words.charAt(words.length()-1)) == false){
                length -= 1;
            }
            if(length>=30){
                counts[30] += 1;
            }
            else if(length < 30 && length >= 0){
                counts[length] += 1;
            }
        }
    }
    
    public void testCountWordLengths(){
        FileResource fr = new FileResource();
        int [] counts = new int [31];
        countWordLengths(fr, counts);
        System.out.println("The most common length: "+indexOfMax(counts));
        for (int i = 1; i <=30; i++){
            System.out.println("Words with "+i+" characters: "+counts[i]);
        }
    }
    
    public int indexOfMax(int[] values){
        int maxIndex = -1;
        int count = 0;
        for (int i = 0; i < values.length; i++){
            if(count < values[i]){
                count = values[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
