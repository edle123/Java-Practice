
/**
 * Adds the names of characters in a play to an ArrayList
 * Can filter characters by number of spoken lines
 * 
 * @Eric
 * @version 1, February 27th, 2022
 */
import java.util.ArrayList;
import edu.duke.FileResource;

public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> occurences;
    private int lines;

    public CharactersInPlay(){
        names = new ArrayList<String>();
        occurences = new ArrayList<Integer>();
    }

    private void update(String person){
        if (! names.contains(person.toUpperCase())){
            names.add(person.toUpperCase());
            occurences.add(1);
        }
        else{
            int index = names.indexOf(person.toUpperCase());
            int value = occurences.get(index);
            occurences.set(index, value + 1);
        }
    }

    public void findAllCharacters(){
        names.clear();
        occurences.clear();
        lines = 0;
        FileResource fr = new FileResource();
        for(String line : fr.lines()){
            lines++;
            if(line.contains(".")){
                int dot = line.indexOf(".");
                String name = line.substring(0, dot);
                update(name);
            }
        }
    }

    public void tester(){
        findAllCharacters();
        for(int i = 0; i < occurences.size(); i++){
            if(occurences.get(i) > 19){
                int index = i;
                System.out.println(names.get(i)+"\tspeaks "+occurences.get(i)+" times");
            }
        }
        charactersWithNumParts(10,15);
    }

    public void charactersWithNumParts(int num1, int num2){
        int number = 0;
        if(num1 <= num2){
            for (int i = 0; i < occurences.size(); i++){
                number = occurences.get(i);
                if(number >= num1 && number <= num2){
                    int index = i;
                    System.out.println(names.get(i));
                }
            }
        }
        else{
            System.out.println("num1 must be less than or equal to num2.");
        }
    }
}
