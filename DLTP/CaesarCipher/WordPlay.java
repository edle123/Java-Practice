
/**
 * Method to check is a char is a vowel, method to replace vowels in a string,
 * and a method to replace a specified char in a string to either a '*' or a
 * '+' based on its index.
 * 
 * @Eric
 * @version 1, February 19th, 2022
 */

public class WordPlay {
    public boolean isVowel(char ch){
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
        || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void test(){
        // System.out.println(isVowel('F'));
        // System.out.println(isVowel('a'));
        //System.out.println(replaceVowels("Hello World",'*'));
        System.out.println(emphasize("dna ctgaaactga",'a'));
        System.out.println(emphasize("Mary Bella Abracadabra",'a'));
    }
    
    public String replaceVowels(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        String newPhrase = "";
        for(int i = 0; i < sb.length(); i++){
            if(isVowel(sb.charAt(i)) == true){
                sb.setCharAt(i, ch);
            }
        }
        newPhrase = sb.toString();
        return newPhrase;
    }
    
    public String emphasize(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        String newPhrase = "";
        for (int i = 0; i < sb.length(); i++){
            if (Character.toLowerCase(sb.charAt(i)) == Character.toLowerCase(ch)){
                if(i % 2 == 0){
                    sb.setCharAt(i, '*');
                }
                else{
                    sb.setCharAt(i, '+');
                }
            }
        }
        newPhrase = sb.toString();
        return newPhrase;
    }
}
