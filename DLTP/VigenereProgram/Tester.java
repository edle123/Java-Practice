
/**
 * Class that runs test cases on the other classes of VigenereProgram
 * 
 * @Eric
 * @version 1, March 3rd, 2022
 */
import edu.duke.FileResource;
import java.util.Arrays;

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
    }
}
