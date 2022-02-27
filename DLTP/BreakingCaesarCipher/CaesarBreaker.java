
/**
 * Able to decrypt strings that have up to 2 keys
 * 
 * @Eric
 * @version 1, February 24th, 2022
 */
import edu.duke.FileResource;

public class CaesarBreaker {
    public int[] countLetters(String message){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int index = 0;
        int[] count = new int[26];
        for (int i = 0; i < message.length(); i++){
            index = alphabet.indexOf(Character.toLowerCase(message.charAt(i)));
            if(index != -1){
                count[index] += 1;
            }
        }
        return count;
    }

    public int maxIndex(int[] values){
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

    public String decrypt(String encrypted){
        int key = getKey(encrypted);
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(encrypted, 26 - key);
        return message;
    }

    public String decrypt2(String encrypted, int key){
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(encrypted, 26 - key);
        return message;
    }

    public void testDecrypt(){
        // // String test = "I am a test eeeeeeeee";
        // CaesarCipher cc = new CaesarCipher();
        // FileResource fr1 = new FileResource("ExampleText/wordsLotsOfEs.txt");
        // FileResource fr2 = new FileResource("ExampleText/wordsLotsOfEsEncrypted.txt");
        // String decrypt1 = fr1.asString();
        // String decrypt2 = fr2.asString();
        // // String message = cc.encrypt(test, 4);
        // // System.out.println(test);
        // // System.out.println(message);
        // // System.out.println(decrypt(message));
        // String decrypt3 = decryptTwoKeys(decrypt2);
        // System.out.println(decrypt1);
        // System.out.println(decrypt2);
        // System.out.println(decrypt3);
        FileResource fr = new FileResource();
        String test = fr.asString();
        String decrypt = decryptTwoKeys(test);
        System.out.println(decrypt);
    }

    public String halfOfString(String message, int start){
        String half = "";
        for (int i = start; i < message.length(); i+=2){
            half = half + message.charAt(i);
        }
        return half;
    }

    public int getKey(String s){
        int key = 0;
        int[] freq = countLetters(s);
        int maxIndex = maxIndex(freq);
        key = maxIndex - 4;
        if(maxIndex <4){
            key = 26 - (4 - maxIndex);
        }
        return key;
    }

    public String decryptTwoKeys(String encrypted){
        String firstHalf = halfOfString(encrypted, 0);
        String secondHalf = halfOfString(encrypted, 1);
        String decrypted = "";
        int firstKey = getKey(firstHalf);
        int secondKey = getKey(secondHalf);
        String decryptFirst = decrypt(firstHalf);
        String decryptSecond = decrypt(secondHalf);
        System.out.println("The first key is: "+firstKey+"\nThe second key is: "+secondKey);
        for (int i = 0; i < decryptSecond.length(); i++){
            decrypted = decrypted + decryptFirst.charAt(i) + decryptSecond.charAt(i);
        }
        return decrypted;
    }
    
        public String decryptTwoKeys2(String encrypted){
        String firstHalf = halfOfString(encrypted, 0);
        String secondHalf = halfOfString(encrypted, 1);
        String decrypted = "";
        int firstKey = 2;
        int secondKey = 20;
        String decryptFirst = decrypt2(firstHalf,firstKey);
        String decryptSecond = decrypt2(secondHalf,secondKey);
        System.out.println("The first key is: "+firstKey+"\nThe second key is: "+secondKey);
        for (int i = 0; i < decryptSecond.length(); i++){
            decrypted = decrypted + decryptFirst.charAt(i) + decryptSecond.charAt(i);
        }
        return decrypted;
    }
}
