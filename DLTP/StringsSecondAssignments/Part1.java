
/**
 * Methods to find stop codons, find genes, and print all genes in a given DNA sequence
 * 
 * @Eric
 * @version 1, February 12th, 2022
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int length = dna.length();
        int index = dna.indexOf(stopCodon, startIndex);
        if(index == -1){
            return length;
        }
        else{
            String isDNA = dna.substring(startIndex, index);
            int multipleOf3 = isDNA.length();
            if(multipleOf3 % 3 == 0){
                return index;
            }
            else{
                return length;
            }
        }
    }

    public void testFindStopCodon(){
        // stopCodons: TAA, TAG, TGA
        String noATG = "ACGTAA";
        String noTAA = "ATGGCA";
        String noATGTAA = "ACGTAG";
        String gene = "ATGTAA";
        String notGene = "ATGTGTAA";
        String upperCase = "ATGGGTTAAGTC";
        String lowerCase = "gatgctataaat";
        String mixed = "ATGggtTAAgtc";
        System.out.println(findStopCodon(noATG, 0, "TAA"));
        System.out.println(findStopCodon(noTAA, 0, "TAA"));
        System.out.println(findStopCodon(noATGTAA, 0, "TAA"));
        System.out.println(findStopCodon(gene, 0, "TAA"));
        System.out.println(findStopCodon(notGene, 0, "TAA"));
        System.out.println(findStopCodon(upperCase, 0, "TAA"));
        System.out.println(findStopCodon(lowerCase, 0, "TAA"));
        System.out.println(findStopCodon(mixed, 0, "TAA"));
    }

    public String findGene(String dna){
        //Find index where start codon begins
        int startIndex = dna.indexOf("ATG");
        //Length of dna string
        int length = dna.length();
        //If no start codon found
        if(startIndex == -1){
            return "No start codon found.";
        }
        //Start codon found
        else{
            //Find indices for first occurrence of end codons
            int taaIndex = findStopCodon(dna, startIndex + 3, "TAA");
            int tagIndex = findStopCodon(dna, startIndex + 3, "TAG");
            int tgaIndex = findStopCodon(dna, startIndex + 3, "TGA");
            /*Values to check for earliest indices for end codons.
            Compares taa and tag and sets the lowest to temp.
            Then compares temp to tga.*/
            int temp = Math.min(taaIndex, tagIndex);
            int minIndex = Math.min(temp, tgaIndex);
            //Outputs failure message if no valid stop codon found
            if((startIndex >= minIndex) || (minIndex == length)){
                return "No valid DNA sequence found.";
            }
            //Outputs DNA sequence
            else{
                String validDNA = dna.substring(startIndex,minIndex+3);
                return validDNA;
            }
        }
    }

    public void testFindGene(){
        String noATG = "ACGTAA";
        String oneValid ="ATGTAA";
        String multipleValid = "ATGTTTTAATAGTGA";
        String noStop = "ATGGGGTTTATT";
        String fifth = "TAAATGTAA";

        System.out.println(noATG);
        System.out.println(findGene(noATG));
        System.out.println(oneValid);
        System.out.println(findGene(oneValid));
        System.out.println(multipleValid);
        System.out.println(findGene(multipleValid));
        System.out.println(noStop);
        System.out.println(findGene(noStop));
        System.out.println(fifth);
        System.out.println(findGene(fifth));
        /*System.out.println("TAAATGTAAGGGTTTATGGGGGGGTGAATGGGGGGGGGGGGGTAGATGGGGGG");
        printAllGenes("TAAATGTAAGGGTTTATGGGGGGGTGAATGGGGGGGGGGGGGTAGATGGGGGGG");*/
    }

    public void printAllGenes(String dna){
        //Index of first start codon
        int startIndex = dna.indexOf("ATG");
        //Length of string dna
        int length = dna.length();
        //First index of stop codon
        int taaIndex = findStopCodon(dna, startIndex + 3, "TAA");
        int tagIndex = findStopCodon(dna, startIndex + 3, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex + 3, "TGA");
        /*Values to check for earliest indices for end codons.
        Compares taa and tag and sets the lowest to temp.
        Then compares temp to tga.*/
        int temp = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(temp, tgaIndex);
        if (startIndex == -1 || startIndex >= minIndex || minIndex == length){
            System.out.println("");
        }
        else{
            String validDNA = dna;
            String remainingDNA = dna;
            while (startIndex != -1 && minIndex != remainingDNA.length()){
                validDNA = remainingDNA.substring(startIndex, minIndex + 3);
                remainingDNA = remainingDNA.substring(minIndex + 3);
                System.out.println(validDNA);
                startIndex = remainingDNA.indexOf("ATG");
                taaIndex = findStopCodon(remainingDNA, startIndex + 3, "TAA");
                tagIndex = findStopCodon(remainingDNA, startIndex + 3, "TAG");
                tgaIndex = findStopCodon(remainingDNA, startIndex + 3, "TGA");
                temp = Math.min(taaIndex, tagIndex);
                minIndex = Math.min(temp, tgaIndex);
            }
        }
    }
}
