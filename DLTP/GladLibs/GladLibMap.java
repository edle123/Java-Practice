
/**
 * Write a description of GladLibMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class GladLibMap {
    private ArrayList<String> usedList;
    private ArrayList<String> consideredList;
    private HashMap<String, ArrayList<String>> myMap;

    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "datalong";

    public GladLibMap(){
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }

    public GladLibMap(String source){
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) {
        String[] categories = {"adjective","noun","color","country","name","animal",
                "timeframe","verb","fruit"};
        for(int i = 0; i < categories.length; i++){
            String category = categories[i];
            ArrayList<String> wordList = new ArrayList<String>();
            wordList = readIt(source+"/"+category+".txt");
            myMap.put(category, wordList);
        }
        usedList = new ArrayList<String>();
        consideredList = new ArrayList<String>();
    }

    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {
        if(label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        else{
            if(!consideredList.contains(label)){
                consideredList.add(label);
            }
            String substitute = randomFrom(myMap.get(label));
            if(myMap.containsKey(label)){
                return substitute;
            }
            else{
                return "**UNKNOWN**";
            }
        }
    }

    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while(usedList.contains(sub)){
            sub = getSubstitute(w.substring(first+1,last)); 
        }
        usedList.add(sub);
        return prefix+sub+suffix;
    }

    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }

    public void makeStory(){
        usedList.clear();
        consideredList.clear();
        System.out.println("\n");
        String story = fromTemplate("datalong/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\nTotal number of words replaced: "+usedList.size());
        System.out.println("Total number of possible words: "+totalWordsInMap());
        System.out.println("Total number of considered words: "+totalWordsConsidered());
    }

    private int totalWordsInMap(){
        int total = 0;
        for (HashMap.Entry<String, ArrayList<String>> word : myMap.entrySet()){
            total += word.getValue().size();
        }
        return total;
    }
    
    private int totalWordsConsidered(){
        int total = 0;
        for(int i = 0; i < consideredList.size(); i++){
            String considered = consideredList.get(i);
            total += myMap.get(considered).size();
        }
        return total;
    }
}
