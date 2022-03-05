import java.util.*;
import edu.duke.*;
import java.io.File;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder slice = new StringBuilder();
        for(int i = whichSlice; i < message.length(); i += totalSlices){
            slice.append(message.charAt(i));
        }
        String finishedSlice = slice.toString();
        return finishedSlice;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for(int i = 0; i < klength; i++){
            String slice = sliceString(encrypted, i, klength);
            key[i] = cc.getKey(slice);
        }
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        DirectoryResource dr = new DirectoryResource();
        HashMap <String, HashSet<String>> languages = 
            new HashMap <String, HashSet<String>>();
        for(File f : dr.selectedFiles()){
            String language = f.getName();
            FileResource fr = new FileResource(f);
            HashSet<String> dictionary = readDictionary(fr);
            languages.put(language, dictionary);
        }
        FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println(breakForAllLangs(message, languages));
    }

    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> dictionary = new HashSet<String>();
        //String words = fr.asString();
        for(String line : fr.lines()){
            dictionary.add(line.toLowerCase());
        }
        return dictionary;
    }

    public int countWords(String message, HashSet<String> dictionary){
        String[] words = message.split("\\W+");
        int count = 0;
        for(int i = 0; i < words.length; i++){
            if(dictionary.contains(words[i].toLowerCase())){
                count++;
            }
        }
        return count;
    }

    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int best = 0;
        int index = 0;
        for(int i = 1; i <= 100; i++){
            int[] key = tryKeyLength(encrypted, i, mostCommonCharIn(dictionary));
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int count = countWords(decrypted, dictionary);
            if (best < count){
                best = count;
                index = i;
            }
        }
        int[] key = tryKeyLength(encrypted, index, mostCommonCharIn(dictionary));
        VigenereCipher vc = new VigenereCipher(key);
        System.out.println("Key length: "+key.length);
        System.out.println("Valid words: "+best);
        return vc.decrypt(encrypted);
    }

    public char mostCommonCharIn(HashSet<String> dictionary){
        char mostCommon = 'a';
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        int max = 0, maxIndex = 0;
        for(String word : dictionary){
            for(int i = 0; i < word.length(); i++){
                int index = alphabet.indexOf(word.charAt(i));
                if (index != -1){
                    counts[index] += 1;
                }
            }
        }
        for(int i = 0; i < counts.length; i++){
            if (max < counts[i]){
                max = counts[i];
                maxIndex = i;
            }
        }
        mostCommon = alphabet.charAt(maxIndex);
        return mostCommon;
    }

    public String breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages){
        //String breakForLanguage(String encrypted, HashSet<String> dictionary)
        //int countWords(String message, HashSet<String> dictionary)
        int best = 0;
        String decrypted = "", bestLanguage = "";
        for(String language : languages.keySet()){
            System.out.println("Current language: "+language);
            int compare = countWords(breakForLanguage(encrypted, languages.get(language)), 
                    languages.get(language));
            if (best < compare){
                best = compare;
                bestLanguage = language;
            }
        }
        decrypted = breakForLanguage(encrypted, languages.get(bestLanguage));
        return decrypted + "\nLanguage: " + bestLanguage;

    }
}
