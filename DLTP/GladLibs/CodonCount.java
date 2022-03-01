
/**
 * Builds HashMap of DNA codons based on
 * DNA String found in text file
 * 
 * @Eric
 * @version 1, February 28th, 2022
 */
import java.util.HashMap;
import edu.duke.FileResource;

public class CodonCount {
    private HashMap<String,Integer> codonsMap;

    public CodonCount(){
        codonsMap = new HashMap<String,Integer>();
    }

    public void buildCodonMap(int start, String dna){
        String codon = "";
        if(start >= 0 && start <=2){
            System.out.println("Reading frame is "+start);
            dna = dna.substring(start);
            while(dna.length()>=3){
                if(dna.length() > 3){
                    codon = dna.substring(0,3);
                }
                else{
                    codon = dna;
                }
                if(codonsMap.containsKey(codon)){
                    int value = codonsMap.get(codon);
                    codonsMap.put(codon, value + 1);
                }
                else{
                    if(codon.length()==3){
                        codonsMap.put(codon, 1);
                    }
                }
                dna = dna.substring(3);
            }
        }
        else{
            System.out.println("Start value is invalid. Please choose 0, 1, or 2.");
        }
        //This build is for checking all reading frames from start to 2
        // for (int i = start; i < 3; i++){
        // System.out.println("Reading frame "+i);
        // while(dna.length()>=3){
        // if(dna.length() > 3){
        // codon = dna.substring(start, start+3);
        // }
        // else{
        // codon = dna;
        // }
        // if(codonsMap.containsKey(codon)){
        // int value = codonsMap.get(codon);
        // codonsMap.put(codon, value + 1);
        // }
        // else{
        // codonsMap.put(codon, 1);
        // }
        // dna = dna.substring(1);
        // }
        // }
    }

    public String getMostCommonCodon(){
        String mostCommon = "";
        String maxCodon = "";
        int maxValue = 0;
        for (HashMap.Entry<String,Integer> codon : codonsMap.entrySet()){
            if (codon.getValue() > maxValue){
                maxCodon = codon.getKey();
                maxValue = codon.getValue();
            }
        }
        mostCommon = maxCodon;
        return mostCommon;
    }

    public void printCodonCounts(int start, int end){
        for(HashMap.Entry<String,Integer> codon : codonsMap.entrySet()){
            if(codon.getValue()>=start && codon.getValue()<=end){
                System.out.println(codon.getKey()+"\t"+codon.getValue());
            }
        }
    }

    public void tester(){
        //Prompts user to select a file to read DNA String
        FileResource fr = new FileResource();
        String dnaFile = fr.asString().toUpperCase().trim();
        //Starting frame 0
        codonsMap.clear();
        buildCodonMap(0, dnaFile);
        System.out.println("Total number of unique codons: "+codonsMap.size());
        System.out.println("Most common codon: "+getMostCommonCodon()+"\t"+
        codonsMap.get(getMostCommonCodon()));
        printCodonCounts(1, 5);
        //Starting frame 1
        codonsMap.clear();
        buildCodonMap(1, dnaFile);
        System.out.println("Total number of unique codons: "+codonsMap.size());
        System.out.println("Most common codon: "+getMostCommonCodon()+"\t"+
        codonsMap.get(getMostCommonCodon()));
        printCodonCounts(1, 5);
        //Starting frame 2
        codonsMap.clear();
        buildCodonMap(2, dnaFile);
        System.out.println("Total number of unique codons: "+codonsMap.size());
        System.out.println("Most common codon: "+getMostCommonCodon()+"\t"+
        codonsMap.get(getMostCommonCodon()));
        printCodonCounts(1, 5);
    }
}
