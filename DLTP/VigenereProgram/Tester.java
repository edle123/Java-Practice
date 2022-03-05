
/**
 * Class that runs test cases on the other classes of VigenereProgram
 * 
 * @Eric
 * @version 1, March 3rd, 2022
 */
import edu.duke.FileResource;
import edu.duke.DirectoryResource;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;

public class Tester {
    public void testCaesarCipher(){
        CaesarCipher cc = new CaesarCipher(8);
        FileResource fr = new FileResource("VigenereTestData/titus-small.txt");
        String message = fr.asString();
        System.out.println("Original: "+message);
        System.out.println("Encrypted: "+cc.encrypt(message));
        System.out.println("Decrypted: "+cc.decrypt(cc.encrypt(message)));
        System.out.println("Encrypt letter 'e': "+cc.encryptLetter('e'));
        System.out.println("Decrypt letter 'e': "+cc.decryptLetter(cc.encryptLetter('e')));
    }

    public void testCaesarCracker(){
        CaesarCracker cc = new CaesarCracker();
        CaesarCracker ccPortuguese = new CaesarCracker('a');
        FileResource fr = new FileResource("VigenereTestData/titus-small_key5.txt");
        FileResource frPortuguese = new FileResource("VigenereTestData/oslusiadas_key17.txt");
        String message = fr.asString();
        String messagePortuguese = frPortuguese.asString();
        System.out.println("Encrypted: "+message);
        System.out.println("Decrypted: "+cc.decrypt(message));
        System.out.println("Encrypted: "+messagePortuguese);
        System.out.println("Decrypted: "+ccPortuguese.decrypt(messagePortuguese));
    }

    public void testVigenereCipher(){
        int[]key = {17,14,12,4};
        VigenereCipher vc = new VigenereCipher(key);
        FileResource fr = new FileResource("VigenereTestData/titus-small.txt");
        String message = fr.asString();
        System.out.println("Original: "+message);
        System.out.println("Encrypted: "+vc.encrypt(message));
        System.out.println("Decrypted: "+vc.decrypt(vc.encrypt(message)));

    }

    public void testVigenereBreaker(){
        VigenereBreaker vb = new VigenereBreaker();
        //Test sliceString(String message, int whichSlice, int totalSlices)
        System.out.println(vb.sliceString("abcdefghijklm", 0, 3)); //should return "adgjm"
        System.out.println(vb.sliceString("abcdefghijklm", 1, 3)); //should return "behk"
        System.out.println(vb.sliceString("abcdefghijklm", 2, 3)); //should return "cfil"
        System.out.println(vb.sliceString("abcdefghijklm", 0, 4)); //should return "aeim"
        System.out.println(vb.sliceString("abcdefghijklm", 1, 4)); //should return "bfj"
        System.out.println(vb.sliceString("abcdefghijklm", 2, 4)); //should return "cgk"
        System.out.println(vb.sliceString("abcdefghijklm", 3, 4)); //should return "dhl"
        System.out.println(vb.sliceString("abcdefghijklm", 0, 5)); //should return "afk"
        System.out.println(vb.sliceString("abcdefghijklm", 1, 5)); //should return "bgl"
        System.out.println(vb.sliceString("abcdefghijklm", 2, 5)); //should return "chm"
        System.out.println(vb.sliceString("abcdefghijklm", 3, 5)); //should return "di"
        System.out.println(vb.sliceString("abcdefghijklm", 4, 5)); //should return "ej"
        //Test tryKeyLength(String encrypted, int klength, char mostCommon)
        FileResource fr = new FileResource("VigenereTestData/athens_keyflute.txt");
        String message = fr.asString();
        System.out.println(Arrays.toString(vb.tryKeyLength(message, 5, 'e')));
        //Quiz Known Language and Key Length Q1
        FileResource q1 = new FileResource("VigenereTestData/secretmessage1.txt");
        String answer = q1.asString();
        System.out.println("Known Language and Key Length Question 1: "
            +Arrays.toString(vb.tryKeyLength(answer, 4, 'e')));
        //Quiz Known Language and Key Length Q2
        System.out.println("Known Language and Key Length Question 2: ");
        vb.breakVigenere();
        //Test mostCommonCharIn(HashSet<String> dictionary)
        FileResource eng = new FileResource("dictionaries/English");
        HashSet<String> dictionary = vb.readDictionary(eng);
        System.out.println("Most common char in English is "
            +vb.mostCommonCharIn(dictionary));
    }

    public void unknownKeyLengthQuiz(){
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource("VigenereTestData/secretmessage2.txt");
        String message = fr.asString();
        FileResource eng = new FileResource("dictionaries/English");
        HashSet<String> dictionary = vb.readDictionary(eng);
        String decrypted = vb.breakForLanguage(message, dictionary);
        System.out.println(decrypted);
        //Quiz Unknown Key Length Q4
        int [] key = vb.tryKeyLength(message, 38, 'e');
        int count = 0;
        //HashSet<String> valid = new HashSet<String>();
        VigenereCipher vc = new VigenereCipher(key);
        String q4 = vc.decrypt(message);
        for(String word : q4.split("\\W+")){
            if(dictionary.contains(word.toLowerCase())){
                count++;
                //valid.add(word.toLowerCase());
            }
        }
        System.out.println("Question 4: "+count);
    }

    public void testBreakingTheVigenereCipherQuiz(){
        VigenereBreaker vb = new VigenereBreaker();
        DirectoryResource dr = new DirectoryResource();
        HashMap <String, HashSet<String>> languages = 
            new HashMap <String, HashSet<String>>();
        for(File f : dr.selectedFiles()){
            String language = f.getName();
            FileResource fr = new FileResource(f);
            HashSet<String> dictionary = vb.readDictionary(fr);
            languages.put(language, dictionary);
        }
        FileResource fr = new FileResource("VigenereTestData/secretmessage3.txt");
        String message = fr.asString();
        System.out.println("Question 1:\n"+vb.breakForAllLangs(message, languages));
        FileResource fr2 = new FileResource("VigenereTestData/secretmessage4.txt");
        String message2 = fr2.asString();
        System.out.println("Question 3:\n"+vb.breakForAllLangs(message2, languages));
    }
}
