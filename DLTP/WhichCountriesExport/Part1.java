
/**
 * Reads data from a CSV file and outputs data from the file that matches
 * specified criteria.
 * 
 * @Eric
 * @version 1, February 14th, 2022
 */
import edu.duke.FileResource;
import org.apache.commons.csv.*;

public class Part1 {
    public void tester(){
        FileResource fr = new FileResource("exportdata.csv");
        CSVParser parser1 = fr.getCSVParser();
        CSVParser parser2 = fr.getCSVParser();
        CSVParser parser3 = fr.getCSVParser();
        CSVParser parser4 = fr.getCSVParser();
        System.out.println(countryInfo(parser1, "Nauru"));
        listExportersTwoProducts(parser2, "cotton", "flowers");
        System.out.println(numberOfExporters(parser3, "cocoa"));
        bigExporters(parser4, "$999,999,999,999");
    }
    
    public String countryInfo(CSVParser parser, String country){
        String countryInfo = "";
        for (CSVRecord record : parser){
            String countryName = record.get("Country");
            if(countryName.equals(country)){
                String export = record.get("Exports");
                String value = record.get("Value (dollars)");
                countryInfo = countryName + ": " + export + ": " + value;                
                break;
            }
            else{
                countryInfo ="NOT FOUND";
            }
        }
        return countryInfo;
    }
    
    public void listExportersTwoProducts(CSVParser parser, 
    String exportItem1, String exportItem2){
        for (CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportItem)){
                count++;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        for (CSVRecord record : parser){
            String value = record.get("Value (dollars)");
            int length = value.length();
            if(length > amount.length()){
                System.out.println(record.get("Country") +" "+value);
            }
        }
    }
}
