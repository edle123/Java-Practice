
/**
 * Able to store genes in a StorageResource object and print out the results.
 * Method to evaluate ratio of "C" and "G" appearances in a DNA string.
 * Method to count the amount of times "CTG" appears in a DNA string.
 * Method to process a gene from a StorageResource input and output some details of it.
 * 
 * @Eric
 * @version 1, February 13th, 2022
 */

import edu.duke.StorageResource;
import edu.duke.FileResource;
import edu.duke.URLResource;

public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int length = dna.length();
        int beginningIndex = startIndex;
        int endIndex = dna.indexOf(stopCodon, beginningIndex);
        if(endIndex == -1){
            return length;
        }
        else{
            String isDNA = dna.substring(startIndex,endIndex);
            int multipleOf3 = isDNA.length();
            while(endIndex != -1) {
                if(multipleOf3 % 3 == 0){
                    return endIndex;
                }
                else{
                    beginningIndex = endIndex+1;
                    endIndex = dna.indexOf(stopCodon, beginningIndex);
                    if(endIndex == -1){
                        break;
                    }
                    isDNA = dna.substring(startIndex,endIndex);
                    multipleOf3 = isDNA.length();
                }
            }
            if(endIndex != -1){
                return endIndex;
            }
            else{
                return length;
            }
        }
    }

    public void testFindStopCodon(){
        // stopCodons: TAA, TAG, TGA
        /*String noATG = "ACGTAA";
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
        System.out.println(findStopCodon(mixed, 0, "TAA"));*/
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
        /*String noATG = "ACGTAA";
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
        System.out.println(findGene(fifth));*/
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

    public StorageResource getAllGenes(String dna){
        //Creates a StorageResource
        StorageResource resource = new StorageResource();
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
            return resource;
        }
        else{
            String validDNA = dna;
            String remainingDNA = dna;
            while (startIndex != -1 && minIndex != remainingDNA.length()){
                validDNA = remainingDNA.substring(startIndex, minIndex + 3);
                remainingDNA = remainingDNA.substring(minIndex + 3);
                resource.add(validDNA);
                startIndex = remainingDNA.indexOf("ATG");
                taaIndex = findStopCodon(remainingDNA, startIndex + 3, "TAA");
                tagIndex = findStopCodon(remainingDNA, startIndex + 3, "TAG");
                tgaIndex = findStopCodon(remainingDNA, startIndex + 3, "TGA");
                temp = Math.min(taaIndex, tagIndex);
                minIndex = Math.min(temp, tgaIndex);
            }
        }
        return resource;
    }

    public void testGetAllGenes(){
        StorageResource resource =
            getAllGenes("TAAATGTAAGGGTTTATGGGGGGGTGAATGGGGGGGGGGGGGTAGATGGGGGGG");
        for (String gene : resource.data()){
            System.out.println(gene);
        }
    }

    public double cgRatio(String dna){
        //Length of dna string
        int length = dna.length();
        //Amount of times either C or G appear
        int count = 0;
        //First indices of appears of C and G
        int cIndex = dna.indexOf("C");
        int gIndex = dna.indexOf("G");
        int minIndex = 0;
        //Remaining DNA string
        String remainingDNA = dna;
        while (minIndex != -1){
            if(cIndex == -1 && gIndex == -1){
                minIndex = -1;
            }
            else if(cIndex == -1 && gIndex != -1){
                minIndex = gIndex;
            }
            else if(cIndex != -1 && gIndex == -1){
                minIndex = cIndex;
            }
            else{
                minIndex = Math.min(cIndex,gIndex);
            }
            if(minIndex != -1){
                count++;
                remainingDNA = remainingDNA.substring(minIndex+1);
                cIndex = remainingDNA.indexOf("C");
                gIndex = remainingDNA.indexOf("G");
            }
        }
        double ratio = (double) count;
        return (ratio/length);
    }

    public int countCTG(String dna){
        int count = 0;
        int startIndex = dna.indexOf("CTG", 0);
        if( startIndex == -1){
            return count;
        }
        else{
            String remainingDNA = dna;
            while (startIndex != -1){
                count++;
                remainingDNA = remainingDNA.substring(startIndex+3);
                startIndex = remainingDNA.indexOf("CTG",0);
            }
            return count;
        }
    }

    public void processGenes(StorageResource sr){
        //print all the Strings in sr that are longer than 9 characters
        //print the number of Strings in sr that are longer than 9 characters
        int count = 0;
        int count9 = 0;
        int countCG = 0;
        int count60 = 0;
        String longest = "";
        for(String gene : sr.data()){
            count++;
        }
        System.out.println("There are "+count+" genes.");
        System.out.println("Strings with at least 9 characters:");
        for(String gene : sr.data()){
            if (gene.length() > 9){
                System.out.println(gene);
                count9++;
            }
        }
        System.out.println("Strings with 9+ characters: "+count9);
        //print the Strings in sr whose C-G-ratio is higher than 0.35
        //print the number of strings in sr whose C-G-ratio is higher than 0.35
        System.out.println("Strings with a CGRatio of 0.35:");
        for (String gene : sr.data()){
            if(cgRatio(gene) > 0.35){
                System.out.println(gene);
                countCG++;
            }
        }
        System.out.println("Strings with a CG ratio > 0.35: "+countCG);
        //print the length of the longest gene in sr
        for (String gene : sr.data()){
            if(gene.length() > longest.length()){
                longest = gene;
            }
        }
        System.out.println("The longest string has "+longest.length()+" characters.");
        for(String gene :sr.data()){
            if(gene.length() > 60){
                System.out.println(gene);
                count60++;
            }
        }
        System.out.println("Strings with 60+ characters: "+count60+"\n");
    }

    public void testProcessGenes(){
        //one DNA string that has some genes longer than 9 characters
        /*StorageResource resource1 =
        getAllGenes("TAAATGTTTTTTTAAATGTTTTGAATGTTTTTTTAG");
        processGenes(resource1);*/
        //one DNA string that has no genes longer than 9 characters
        /*StorageResource resource2 =
        getAllGenes("TAAATGGGGTAAATGGGGTGAATGGGGTAG");
        processGenes(resource2);*/
        //one DNA string that has some genes whose C-G-ratio is higher than 0.35
        /*StorageResource resource3 =
        getAllGenes("TAAATGGGGGGGTAAATGGGGTGAATGGGGGGGTAG");
        processGenes(resource3);*/
        //one DNA string that has some genes whose C-G-ratio is lower than 0.35. 
        /*StorageResource resource4 =
        getAllGenes("ATGTAGATGTAAATGTGA");
        processGenes(resource4);*/
        /*StorageResource resource5 =
        getAllGenes("ATGTAA");
        processGenes(resource5);*/
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        String newDNA = dna.toUpperCase();
        StorageResource resource6 = getAllGenes(newDNA);
        processGenes(resource6);
    }

    public void test(){
        URLResource ur = 
            new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
        String dna = ur.asString();
        String newDNA = dna.toUpperCase();
        StorageResource resource = getAllGenes(newDNA);
        processGenes(resource);

        int test = countCTG(newDNA);
        System.out.println(test);
        System.out.println(newDNA);
        //System.out.println(newDNA);
        // int findStopCodon(String dna, int startIndex, String stopCodon)
        //String findGene(String dna)
        //void printAllGenes(String dna)
        //StorageResource getAllGenes(String dna)
        //double cgRatio(String dna)
        //int countCTG(String dna)
        //void processGenes(StorageResource sr)
    }
}
