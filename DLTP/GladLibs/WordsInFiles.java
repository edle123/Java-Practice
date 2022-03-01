
/**
 * Write a description of WordsInFiles here.
 * 
 * @Eric
 * @version 1, February 28th, 2022
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import edu.duke.DirectoryResource;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> wordMap;

    public WordsInFiles(){
        wordMap = new HashMap<String,ArrayList<String>>();
    }

    private void addWordsFromFile(File f){
        Scanner scan = null;
        try {
            scan = new Scanner(f);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        while(scan.hasNextLine()){
            String currentLine = scan.nextLine();
            String[] words = currentLine.split(" ");
            for(String s : words){
                if(s.length()>0){
                    ArrayList<String>sList = wordMap.get(s);
                    if(wordMap.containsKey(s)){
                        if(!sList.contains(f.getName())){
                            sList.add(f.getName());
                        }
                    }
                    else{
                        sList = new ArrayList<String>();
                        sList.add(f.getName());
                        wordMap.put(s, sList);
                    }
                }
            }
        }
    }

    public void buildWordFileMap(){
        wordMap.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }

    public int maxNumber(){
        int max = 0;
        for (HashMap.Entry<String, ArrayList<String>> word : wordMap.entrySet()){
            if (max < word.getValue().size()){
                max = word.getValue().size();
            }
        }
        return max;
    }

    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> containList = new ArrayList<String>();
        for (HashMap.Entry<String, ArrayList<String>> word : wordMap.entrySet()){
            if(word.getValue().size() == number && word.getKey().length()>0){
                containList.add(word.getKey());
            }
        }
        return containList;
    }

    public void printFilesIn(String word){
        for (HashMap.Entry<String, ArrayList<String>> hashWord : wordMap.entrySet()){
            if(hashWord.getKey().equals(word)){
                System.out.println(hashWord.getValue());
            }
        }
    }

    public void tester(){
        //Build HashMap
        buildWordFileMap();
        //Number of maximum amount of files for a word to possibly be found
        System.out.println("Maximum number of files a word can be found in: "+maxNumber());
        //All words that are in the maximum number of files
        System.out.println("All words in maximum number of files: "+
            wordsInNumFiles(maxNumber()));
        //The filenames that the max words are found in
        System.out.println("Filenames words are found in: ");
        ArrayList<String> maxWords = wordsInNumFiles(maxNumber());
        Object[] objectMaxWords = maxWords.toArray();
        String[] stringMaxWords = new String[objectMaxWords.length];
        for (int i = 0; i < objectMaxWords.length; i++){
            String s = (String) objectMaxWords[i];
            stringMaxWords[i] = s;
        }
        for(int i = 0; i < stringMaxWords.length; i++){
            System.out.println(stringMaxWords[i]+":");
            printFilesIn(stringMaxWords[i]);
        }
        //Prints the mapping for the HashMap
        System.out.println(wordMap.entrySet());
        //Quiz Q4
        System.out.println("Words that occur in all five files: "
        +wordsInNumFiles(5).size());
        //Quiz Q5
        System.out.println("Words that occur in four files: "+
        wordsInNumFiles(4).size());
        //Quiz Q6
        System.out.println("The word 'sad' appears in these files: "+
        wordMap.get("sad"));
        //Quiz Q7
        System.out.println("The word 'red' appears in these files: "+
        wordMap.get("red"));
        //Quiz GladLibs Q12
        System.out.println("Words that occur in all seven files: "
        +wordsInNumFiles(7).size());
        //Quiz GladLibs Q13
        System.out.println("Words that occur in four files: "
        +wordsInNumFiles(4).size());
        //Quiz GladLib Q14
        System.out.println("The word 'sea' appears in these files: "
        +wordMap.get("sea"));
        //Quiz GladLib Q15
        System.out.println("The word 'tree' appears in these files: "
        +wordMap.get("tree"));
    }
}
