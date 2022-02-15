/**
 * Reads csv files that hold records of weather on specified dates and performs calculations based on the data.
 * 
 * @Eric
 * @version 1, February 14th, 2022
 */
import edu.duke.FileResource;
import edu.duke.DirectoryResource;
import java.io.File;
import org.apache.commons.csv.*;

public class Part1 {
    public CSVRecord coldestHourInFile(CSVParser parser){
        String stringTemperature = "";
        double doubleTemperature = 0.0;
        double coldestTemperature = 0.0;
        CSVRecord coldest = null;
        for(CSVRecord record : parser){
            if(coldest == null){
                coldest = record;
                stringTemperature = record.get("TemperatureF");
                coldestTemperature = Double.parseDouble(stringTemperature);
            }
            else{
                stringTemperature = record.get("TemperatureF");
                doubleTemperature = Double.parseDouble(stringTemperature);
                if((doubleTemperature < coldestTemperature)
                && (doubleTemperature != -9999)){
                    coldest = record;
                    stringTemperature = record.get("TemperatureF");
                    coldestTemperature = Double.parseDouble(stringTemperature);
                }
            }
        }
        return coldest;
    }

    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldest = coldestHourInFile(parser);
        System.out.println("The coldest temperature was "+coldest.get("TemperatureF")+
            " at ");//+coldest.get("TimeEST"));
    }

    public String fileWithColdestTemperature(){
        CSVRecord current = null;
        CSVRecord coldest = null;
        CSVParser parser = null;
        String stringTemperature = "";
        String name = "";
        double doubleTemperature = 0.0;
        double coldestTemperature = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            parser = fr.getCSVParser();
            current = coldestHourInFile(parser);
            stringTemperature = current.get("TemperatureF");
            doubleTemperature = Double.parseDouble(stringTemperature);
            if(coldest == null){
                coldest = current;
                coldestTemperature = Double.parseDouble(stringTemperature);
            }
            else{
                if(doubleTemperature < coldestTemperature && doubleTemperature != -9999){
                    coldest = current;
                    coldestTemperature = doubleTemperature;
                    name = f.getName();
                }
            }
        }
        return name;
    }

    public void testFileWithColdestTemperature(){
        String name = fileWithColdestTemperature();
        FileResource fr = new FileResource("nc_weather/2013/"+name);
        CSVParser parser1 = fr.getCSVParser();
        CSVParser parser2 = fr.getCSVParser();
        CSVRecord coldest = coldestHourInFile(parser1);        
        System.out.println("Coldest day was in file " +
            name+"\nColdest Temperature on that day was " +
            coldest.get("TemperatureF") + "\nAll the temperatures on the coldest day were: ");
        for (CSVRecord record : parser2){
            System.out.println(record.get("DateUTC")+": "+
                record.get("TemperatureF"));
        }
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser){
        String stringHumidity = "";
        double doubleHumidity = 0.0;
        double lowestHumidity = 0.0;
        CSVRecord lowest = null;
        for(CSVRecord record : parser){
            if(lowest == null){
                lowest = record;
                stringHumidity = record.get("Humidity");
                lowestHumidity = Double.parseDouble(stringHumidity);
            }
            else{
                stringHumidity = record.get("Humidity");
                if(!stringHumidity.equals("N/A")){
                    doubleHumidity = Double.parseDouble(stringHumidity);
                    if(doubleHumidity < lowestHumidity){
                        lowest = record;
                        stringHumidity = record.get("Humidity");
                        lowestHumidity = Double.parseDouble(stringHumidity);
                    }
                }
            }
        }
        return lowest;
    }

    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was "+csv.get("Humidity")+" at "+
            csv.get("DateUTC"));
    }

    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord current = null;
        CSVRecord lowest = null;
        CSVParser parser = null;
        String stringHumidity = "";
        double doubleHumidity = 0.0;
        double lowestHumidity = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            parser = fr.getCSVParser();
            current = lowestHumidityInFile(parser);
            if(lowest == null){
                lowest = current;
                stringHumidity = current.get("Humidity");
                lowestHumidity = Double.parseDouble(stringHumidity);
            }
            else{
                stringHumidity = current.get("Humidity");
                if(!stringHumidity.equals("N/A")){
                    doubleHumidity = Double.parseDouble(stringHumidity);
                    if(doubleHumidity < lowestHumidity){
                        lowest = current;
                        lowestHumidity = doubleHumidity;
                    }
                }
            }
        }
        return lowest;
    }

    public void testLowestHumidityInManyFiles(){
        CSVRecord lowest = lowestHumidityInManyFiles();
        String stringHumidity = "";
        double doubleHumidity = 0.0;
        System.out.println("Lowest Humidity was "+lowest.get("Humidity")+" at "+
            lowest.get("DateUTC"));
    }

    public double averageTemperatureInFile(CSVParser parser){
        double total = 0.0;
        int count = 0;
        String stringTemperature = "";
        double doubleTemperature = 0.0;
        for (CSVRecord record : parser){
            count++;
            stringTemperature = record.get("TemperatureF");
            doubleTemperature = Double.parseDouble(stringTemperature);
            if(doubleTemperature != -9999){
                total += doubleTemperature;
            }
        }
        return (total/count);
    }

    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is "+average);
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double total = 0.0;
        double average = 0.0;
        int count = 0;
        String stringHumidity ="";
        double doubleHumidity = 0.0;
        String stringTemperature = "";
        double doubleTemperature = 0.0;
        for (CSVRecord record : parser){
            stringHumidity = record.get("Humidity");
            if(!stringHumidity.equals("N/A")){
                doubleHumidity = Double.parseDouble(stringHumidity);
                if(doubleHumidity >= value){
                    count++;
                    stringTemperature = record.get("TemperatureF");
                    doubleTemperature = Double.parseDouble(stringTemperature);
                    if(doubleTemperature != -9999){
                        total += doubleTemperature;
                    }
                }
            }
        }
        if(count == 0){
            return 0.0;
        }
        else{
            average = total / count;
            return average;
        }
    }

    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr1 = new FileResource();
        FileResource fr2 = new FileResource();
        CSVParser parser1 = fr1.getCSVParser();
        CSVParser parser2 = fr2.getCSVParser();
        double average = averageTemperatureWithHighHumidityInFile(parser1, 80);
        if(average == 0.0){
            System.out.println("No temperatures with that humidity");
        }
        else{
            System.out.println("Average Temp when high Humitidy is "+average);
        }
        average = averageTemperatureWithHighHumidityInFile(parser2, 80);
        if(average == 0.0){
            System.out.println("No temperatures with that humidity");
        }
        else{
            System.out.println("Average Temp when high Humitidy is "+average);
        }
    }
}
