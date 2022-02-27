
/**
 * Able to encrypt and decrypt strings using Caesar Cipher
 * 
 * @Eric
 * @version 1, February 26th, 2022
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;

    public CaesarCipher(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }

    public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        String encrypted = "";
        int index = 0;
        for(int i = 0; i < sb.length(); i++){
            index = alphabet.indexOf(sb.charAt(i));
            if (index != -1){
                sb.setCharAt(i, shiftedAlphabet.charAt(index));
            }
            else{
                index = alphabet.indexOf(Character.toUpperCase(sb.charAt(i)));
                if (index != -1){
                    sb.setCharAt(i, Character.toLowerCase(shiftedAlphabet.charAt(index)));
                }
            }
        }
        encrypted = sb.toString();
        return encrypted;
    }

    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);        
    }
}
