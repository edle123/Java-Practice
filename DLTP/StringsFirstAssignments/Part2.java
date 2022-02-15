
/**
 * Moddifies the findSimpleGene method from Part1 to accept 3 parameters
 * 
 * @Eric
 * @version 1, February 12th, 2022
 */

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        if(!startCodon.toUpperCase().equals("ATG") || !stopCodon.toUpperCase().equals("TAA")){
            return "Not a gene.";
        }
        else{
            int startIndex = dna.indexOf(startCodon);
            int endIndex = dna.indexOf(stopCodon,startIndex+3);
            String simpleGene = "";
            int length = 1;
            if(startIndex != -1 && endIndex != -1){
                simpleGene = dna.substring(startIndex,endIndex+3);
                length = simpleGene.length();
            }

            if(startIndex == -1 || endIndex == -1 || length % 3 !=0){
                return "Not a gene";
            }
            if(dna.equals(dna.toUpperCase())){
                return "Gene is " + simpleGene.toUpperCase();
            }
            else if(dna.equals(dna.toLowerCase())){
                return "Gene is " + simpleGene.toLowerCase();
            }
            else{
                return "Not valid";
            }
        }
    }

    public void testSimpleGene(){
        /*String noATG = "ACGTAA";
        String noTAA = "ATGGCA";
        String noATGTAA = "ACGTAG";
        String gene = "ATGTAA";
        String notGene = "ATGTGTAA";*/
        String upperCase = "ATGGGTTAAGTC";
        String lowerCase = "gatgctataaat";
        String mixed = "ATGggtTAAgtc";
        /*System.out.println(noATG);
        System.out.println(findSimpleGene(noATG,"ATG","TAA"));
        System.out.println(noTAA);
        System.out.println(findSimpleGene(noTAA,"ATG","TAA"));
        System.out.println(noATGTAA);
        System.out.println(findSimpleGene(noATGTAA,"ATG","TAA"));
        System.out.println(gene);
        System.out.println(findSimpleGene(gene,"ATG","TAA"));
        System.out.println(notGene);
        System.out.println(findSimpleGene(notGene,"ATG","TAA"));*/
        System.out.println(upperCase);
        System.out.println(findSimpleGene(upperCase, "ATG", "TAA"));
        System.out.println(lowerCase);
        System.out.println(findSimpleGene(lowerCase, "atg", "taa"));
        System.out.println(mixed);
        System.out.println(findSimpleGene(mixed, "ATG", "TAA"));
    }
}
