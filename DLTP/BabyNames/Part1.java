
/**
 * Reads CSV files containing data on baby names and performs calculations based on the data.
 * 
 * @Eric
 * @version 1, February 15th, 2022
 */
import edu.duke.FileResource;
import edu.duke.DirectoryResource;
import org.apache.commons.csv.*;
import java.io.File;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Part1 {
    public void totalBirths(){
        //Initializing varibales to keep tally of births and number of names
        int girlsBirths = 0;
        int boysBirths = 0;
        int totalBirths = 0;
        int numGirlsNames = 0;
        int numBoysNames = 0;
        int totalNames = 0;
        //Reads data from file
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser){
            totalNames++;
            if(record.get(1).equals("F")){
                numGirlsNames++;
                girlsBirths += Integer.parseInt(record.get(2));
                totalBirths += Integer.parseInt(record.get(2));
            }
            else{
                numBoysNames++;
                boysBirths += Integer.parseInt(record.get(2));
                totalBirths += Integer.parseInt(record.get(2));
            }
        }
        System.out.println("There are "+numGirlsNames+" girls names\nThere are "+
            numBoysNames+ " boys names\nThere are "+totalNames+" total names\nThere are "+
            girlsBirths+" girls births\nThere are "+boysBirths+" boys births\nThere are "+
            totalBirths+" total births");
    }

    public int getRank(int year, String name, String gender){
        int rank = 0;
        int numGirls = 0;
        String stringYear = String.valueOf(year);
        FileResource fr = new 
            FileResource("us_babynames/us_babynames_by_year/yob"+stringYear+".csv");
        CSVParser parser1 = fr.getCSVParser(false);
        CSVParser parser2 = fr.getCSVParser(false);

        for(CSVRecord record : parser1){
            if(record.get(1).equals("F")){
                numGirls++;
            }
        }              

        for(CSVRecord record : parser2){
            if(record.get(1).equals(gender)){
                if(gender.equals("M")){
                    if(record.get(0).equals(name)){
                        rank = (int) record.getRecordNumber() - numGirls;
                        break;
                    }
                    else{
                        rank = -1;
                    }
                }
                else{
                    if(record.get(0).equals(name)){
                        rank = (int) record.getRecordNumber();
                        break;
                    }
                    else{
                        rank = -1;
                    }
                }
            }
        }        
        return rank;
    }

    public void testGetRank(){
        int rank1 = getRank(2012, "Emily", "F");
        int rank2 = getRank(2012, "Mason", "F");
        System.out.println(rank1+"\n"+rank2);
    }

    public String getName(int year, int rank, String gender){
        String name = "";
        int numGirls = 0;
        String stringYear = String.valueOf(year);
        FileResource fr = new 
            FileResource("us_babynames/us_babynames_by_year/yob"+stringYear+".csv");
        CSVParser parser1 = fr.getCSVParser(false);
        CSVParser parser2 = fr.getCSVParser(false);
        for(CSVRecord record : parser1){
            if(record.get(1).equals("F")){
                numGirls++;
            }
        }

        for(CSVRecord record :parser2){
            if(record.get(1).equals(gender)){
                if(gender.equals("M")){
                    if(record.getRecordNumber() == (numGirls + rank)){
                        name = record.get(0);
                        break;
                    }
                    else{
                        name = "NO NAME";
                    }
                }
                else{
                    if(record.getRecordNumber() == rank){
                        name = record.get(0);
                        break;
                    }
                    else{
                        name = "NO NAME";
                    }
                }
            }
        }
        return name;
    }

    public void testGetName(){
        System.out.println(getName(2014, 16, "M")+" "+getName(2014, 11, "F"));
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        System.out.println(name+" born in "+year+" would be "+newName+
            " if she was born in "+newYear);
    }

    public void testWhatIsNameInYear(){
        whatIsNameInYear("Susan", 1972, 2014, "F");
        whatIsNameInYear("Mason", 2012, 2014, "M");
    }

    public int yearOfHighestRank(String name, String gender){
        int highest = 0;
        int current = 0;
        int highestYear = 0;
        String stringYear = "";
        int intYear = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            stringYear = f.getName().substring(3,7);
            intYear = Integer.parseInt(stringYear);
            current = getRank(intYear, name, gender);
            if (highest == 0 && current != -1){
                highest = current;
                highestYear = intYear;
            }
            else if(current < highest && current !=-1){
                highest = current;
                highestYear = intYear;
            }
        }
        if(highestYear == 0){
            return -1;
        }
        else{
            return highestYear;
        }
    }

    public void testYearOfHighestRank(){        
        System.out.println("The year with the highest rank is "+yearOfHighestRank("Genevieve","F"));
    }

    public double getAverageRank(String name, String gender){
        double averageRank = 0.0;
        int currentRank = 0;
        int count = 0;
        String stringYear = "";
        int intYear = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            stringYear = f.getName().substring(3,7);
            intYear = Integer.parseInt(stringYear);
            currentRank = getRank(intYear, name, gender);
            if(currentRank != -1){
                averageRank += currentRank;
                count++;
            }
        }
        if (count == 0){
            return -1;
        }
        else{
            NumberFormat formatter = new DecimalFormat("#0.00");     
            averageRank = (averageRank / count);
            String stringRank = formatter.format(averageRank);
            averageRank = Double.parseDouble(stringRank);
            return averageRank;
        }
    }

    public void testGetAverageRank(){
        System.out.println("The average rank is "+getAverageRank("Mason","M"));
        System.out.println("The average rank is "+getAverageRank("Eric","M"));
        System.out.println("The average rank is "+getAverageRank("Isabella","F"));
        System.out.println("The average rank is "+getAverageRank("Sophia","F"));
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int totalBirths = 0;
        int currentRank = getRank(year, name, gender);
        int intBirths = 0;
        int numGirls = 0;
        String stringBirths = "";
        String stringYear = String.valueOf(year);
        FileResource fr = new 
            FileResource("us_babynames/us_babynames_by_year/yob"+stringYear+".csv");
        CSVParser parser1 = fr.getCSVParser(false);
        CSVParser parser2 = fr.getCSVParser(false);
        for (CSVRecord record : parser1){
            if(record.get(1).equals("F")){
                numGirls++;
            }
        }
        for (CSVRecord record : parser2){
            if(currentRank == -1){
                if(record.get(1).equals(gender)){
                    stringBirths = record.get(2);
                    intBirths = Integer.parseInt(stringBirths);
                    totalBirths+=intBirths;
                }
            }
            else{
                if(record.get(1).equals(gender)){
                    if(gender.equals("F")){
                        if (record.getRecordNumber()<currentRank){
                            stringBirths = record.get(2);
                            intBirths = Integer.parseInt(stringBirths);
                            totalBirths+=intBirths;
                        }
                    }
                    else{
                        if(record.getRecordNumber()<(currentRank+numGirls)){
                            stringBirths = record.get(2);
                            intBirths = Integer.parseInt(stringBirths);
                            totalBirths+=intBirths;
                        }
                    }
                }
            }
        }
        return totalBirths;
    }

    public void testGetTotalBirthsRankedHigher(){
        /*System.out.println("Total births ranked higher is "+
        getTotalBirthsRankedHigher(2012, "Eric", "M"));
        System.out.println("Total births ranked higher is "+
        getTotalBirthsRankedHigher(2012, "Ethan", "M"));*/
        System.out.println("Total births ranked higher is "+
            getTotalBirthsRankedHigher(1990, "Drew", "M"));
    }
}
