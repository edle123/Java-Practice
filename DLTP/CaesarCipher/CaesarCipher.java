
/**
 * Write a description of CaesarCipher here.
 * 
 * @Eric
 * @version 1, February 19th, 2022
 */
import edu.duke.FileResource;

public class CaesarCipher {
    public String encrypt(String input, int key){
        //Strings containing upper and lowercase alphabet
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        //New shifted alphabets
        String newUpperAlphabet = upperAlphabet.substring(key);        
        newUpperAlphabet = newUpperAlphabet + upperAlphabet.substring(0, key);
        String newLowerAlphabet = lowerAlphabet.substring(key);
        newLowerAlphabet = newLowerAlphabet + lowerAlphabet.substring(0,key);
        //String builder for input string
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++){
            int index = upperAlphabet.indexOf(sb.charAt(i));
            if(index != -1){
                sb.setCharAt(i, newUpperAlphabet.charAt(index));
            }
            else{
                index = lowerAlphabet.indexOf(sb.charAt(i));
                if(index != -1){
                    sb.setCharAt(i, newLowerAlphabet.charAt(index));
                }
            }
        }
        String encrypt = sb.toString();       
        return encrypt;
    }

    public void testCaesar(){
        // FileResource fr = new FileResource();
        // String message = fr.asString();
        // String encrypted = encrypt(message, key);
        // System.out.println("key is "+key+"\n"+encrypted);
        // System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!",23));
        // System.out.println(encrypt("First Legion",23));
        // System.out.println(encrypt("First Legion",17));
        // System.out.println(encryptTwoKeys("First Legion",23,17));
        //System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!"
        //, 15));
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!"
        ,8,21));
    }

    public String encryptTwoKeys(String input, int key1, int key2){
        //Strings containing upper and lowercase alphabet
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        //New shifted alphabets based on key1
        String newUpperAlphabet1 = upperAlphabet.substring(key1);        
        newUpperAlphabet1 = newUpperAlphabet1 + upperAlphabet.substring(0, key1);
        String newLowerAlphabet1 = lowerAlphabet.substring(key1);
        newLowerAlphabet1 = newLowerAlphabet1 + lowerAlphabet.substring(0,key1);
        //New shifted alphabets based on key2
        String newUpperAlphabet2 = upperAlphabet.substring(key2);        
        newUpperAlphabet2 = newUpperAlphabet2 + upperAlphabet.substring(0, key2);
        String newLowerAlphabet2 = lowerAlphabet.substring(key2);
        newLowerAlphabet2 = newLowerAlphabet2 + lowerAlphabet.substring(0,key2);
        //String builder for input string
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++){
            //Key1
            if(i % 2 == 0){
                int index = upperAlphabet.indexOf(sb.charAt(i));
                //Upper case
                if(index != -1){
                    sb.setCharAt(i, newUpperAlphabet1.charAt(index));
                }
                //Lower case
                else{
                    index = lowerAlphabet.indexOf(sb.charAt(i));
                    //Lower case found
                    if(index != -1){
                        sb.setCharAt(i, newLowerAlphabet1.charAt(index));
                    }
                    //No upper or lower case found, does nothing
                }
            }
            //Key2
            else{
                int index = upperAlphabet.indexOf(sb.charAt(i));
                //Upper case
                if(index != -1){
                    sb.setCharAt(i, newUpperAlphabet2.charAt(index));
                }
                //Lower case
                else{
                    index = lowerAlphabet.indexOf(sb.charAt(i));
                    //Lower case found
                    if(index != -1){
                        sb.setCharAt(i, newLowerAlphabet2.charAt(index));
                    }
                    //No upper or lower case found, does nothing
                }
            }
        }
        String encrypt = sb.toString();
        return encrypt;
    }
}
