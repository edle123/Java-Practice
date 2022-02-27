
/**
 * Able to encrypt and decrypt using Caesar Cipher and two keys
 * 
 * @Eric
 * @version 1, February 26th, 2022
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey;
    private int subKey;
    
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        mainKey = key1;
        subKey = key2;
    }
    
    public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        String encrypted = "";
        int index = 0;
        for (int i = 0; i < sb.length(); i++){
            if(i % 2 == 0){
                index = alphabet.indexOf(sb.charAt(i));
                if(index != -1){
                    sb.setCharAt(i, shiftedAlphabet1.charAt(index));
                }
                else{
                    index = alphabet.indexOf(Character.toUpperCase(sb.charAt(i)));
                    if(index != -1){
                        sb.setCharAt(i, Character.toLowerCase(shiftedAlphabet1.charAt(index)));
                    }
                }
            }
            else{
                index = alphabet.indexOf(sb.charAt(i));
                if(index != -1){
                    sb.setCharAt(i, shiftedAlphabet2.charAt(index));
                }
                else{
                    index = alphabet.indexOf(Character.toUpperCase(sb.charAt(i)));
                    if(index != -1){
                        sb.setCharAt(i, Character.toLowerCase(shiftedAlphabet2.charAt(index)));
                    }
                }
            }
        }
        encrypted = sb.toString();
        return encrypted;
    }
    
    public String decrypt(String input){
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey, 26 - subKey);
        return cc.encrypt(input);
    }
}
