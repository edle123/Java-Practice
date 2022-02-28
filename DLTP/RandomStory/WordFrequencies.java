
/**
 * Uses two ArrayLists, one for unique words
 * and another for the amount of times each
 * word is used.
 * 
 * @Eric
 * @version 1, February 27th, 2022
 */
import java.util.ArrayList;
import edu.duke.FileResource;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String words : fr.words()){
            if(! myWords.contains(words.toLowerCase())){
                myWords.add(words.toLowerCase());
                myFreqs.add(1);
            }
            else{
                int index = myWords.indexOf(words.toLowerCase());
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
        }
    }

    public void tester(){
        findUnique();
        for(int i = 0; i < myWords.size(); i++){
            System.out.println(myWords.get(i) + "\tused\t" + myFreqs.get(i)+"\ttimes");
        }
        System.out.println("Number of unique words:\t" + myWords.size());
        System.out.println("Word with most occurences: " + myWords.get(findIndexOfMax())+
            " used "+myFreqs.get(findIndexOfMax())+" times");
    }

    public int findIndexOfMax(){
        int maxIndex = 0;
        int count = 0;
        for(int i = 0; i < myFreqs.size(); i++){
            if(count < myFreqs.get(i)){
                count = myFreqs.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
