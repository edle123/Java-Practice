
/**
 * Test cases for CaesarCipherTwo Class
 * 
 * @Eric
 * @version 1, February 26th, 2022
 */
import edu.duke.FileResource;

public class TestCaesarCipherTwo {
    public String halfOfString(String message, int start){
        String half = "";
        for (int i = start; i < message.length(); i+=2){
            half = half + message.charAt(i);
        }
        return half;
    }

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
        CaesarCipherTwo cc = new CaesarCipherTwo(17, 3);
        String encrypted = cc.encrypt(test);
        System.out.println("Original: "+test);
        System.out.println("Encrypted: "+encrypted);
        System.out.println("Decrypted: "+cc.decrypt(encrypted));
        System.out.println("Break Caesar Cipher: "+breakCaesarCipher(encrypted));
        //Quiz Q2
        CaesarCipherTwo testCC = new CaesarCipherTwo(21, 8);
        System.out.println(testCC.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
        //Quiz Q6
        CaesarCipherTwo testCC2 = new CaesarCipherTwo(14,24);
        System.out.println(testCC2.decrypt("Hfs cpwewloj loks cd Hoto kyg Cyy."));
        //Quiz Q7
        System.out.println(breakCaesarCipher("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!"));
        //Quiz Q8
        FileResource fr2 = new FileResource("ExampleText/mysteryTwoKeysQuiz.txt");
        String test2 = fr2.asString();
        System.out.println(breakCaesarCipher(test2));
    }

    public String breakCaesarCipher(String input){
        String decrypted = "";
        String firstHalf = halfOfString(input, 0);
        String secondHalf = halfOfString(input, 1);
        int key1, key2 = 0;
        int[] freq1 = countLetters(firstHalf);
        int[] freq2 = countLetters(secondHalf);
        int maxIndex1 = maxIndex(freq1);
        int maxIndex2 = maxIndex(freq2);
        key1 = maxIndex1 - 4;
        key2 = maxIndex2 - 4;
        if(maxIndex1 < 4){
            key1 = 26 - (4 - maxIndex1);
        }
        if(maxIndex2 < 4){
            key2 = 26 - (4 - maxIndex2);
        }
        CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
        return cc.decrypt(input);
    }
}
