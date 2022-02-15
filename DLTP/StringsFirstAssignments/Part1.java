
/**
 * Checks if a string is a strand of DNA. If it is, the strand of DNA is output.
 * Otherwise, the output will be "Not a gene."
 * 
 * @Eric 
 * @version 1, February 12th, 2022
 */
public class Part1 {
    public String findSimpleGene(String dna){
        int startIndex = dna.indexOf("ATG");
        int endIndex = dna.indexOf("TAA",startIndex+3);
        String simpleGene = "";
        int length = 1;
        if(startIndex != -1 && endIndex != -1){
            simpleGene = dna.substring(startIndex,endIndex+3);
            length = simpleGene.length();
        }
        
        if(startIndex == -1 || endIndex == -1 || length % 3 !=0){
            return "Not a gene";
        }
        return "Gene is " + simpleGene;
    }
    
    public void testSimpleGene(){
        String noATG = "ACGTAA";
        String noTAA = "ATGGCA";
        String noATGTAA = "ACGTAG";
        String gene = "ATGTAA";
        String notGene = "ATGTGTAA";
        System.out.println(noATG);
        System.out.println(findSimpleGene(noATG));
        System.out.println(noTAA);
        System.out.println(findSimpleGene(noTAA));
        System.out.println(noATGTAA);
        System.out.println(findSimpleGene(noATGTAA));
        System.out.println(gene);
        System.out.println(findSimpleGene(gene));
        System.out.println(notGene);
        System.out.println(findSimpleGene(notGene));
    }
}
