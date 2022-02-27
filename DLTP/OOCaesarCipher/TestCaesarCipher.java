
/**
 * Test cases for CaesarCipher Class
 * 
 * @Eric 
 * @version 1, February 26th, 2022
 */
import edu.duke.FileResource;

public class TestCaesarCipher {

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

    public void simpleTests(){
        FileResource fr = new FileResource();
        String test = fr.asString();
        CaesarCipher cc = new CaesarCipher(18);
        String encrypted = cc.encrypt(test);
        System.out.println("Original: "+test);
        System.out.println("Encrypted: "+encrypted);
        System.out.println("Decrypted: "+cc.decrypt(encrypted));
        System.out.println("Break Caesar Cipher: "+breakCaesarCipher(encrypted));
        //Quiz Q1
        CaesarCipher testCC = new CaesarCipher(15);
        System.out.println(testCC.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
    }

    public String breakCaesarCipher(String input){
        int key = 0;
        int[] freq = countLetters(input);
        int maxIndex = maxIndex(freq);
        key = maxIndex - 4;
        if(maxIndex <4){
            key = 26 - (4 - maxIndex);
        }
        CaesarCipher cc = new CaesarCipher(key);
        return cc.decrypt(input);
    }
}
