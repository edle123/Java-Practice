
/**
 * Code modified from DLTP course
 * Reads a Web Log File line by line, creating a LogEntry object,
 * then adds each LogEntry object into an ArrayList
 * 
 * @Eric
 * @version 1, March 2nd, 2022
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        // complete constructor
        records = new ArrayList<LogEntry>();
    }

    public void readFile(String filename) {
        // complete method
        FileResource fr = new FileResource(filename);
        for (String line : fr.lines()){
            LogEntry le = WebLogParser.parseEntry(line);
            records.add(le);
        }
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }

    public int countUniqueIPs(){
        int count = 0;
        ArrayList <String> addresses = new ArrayList<String>();
        for (LogEntry le : records){
            if(! addresses.contains(le.getIpAddress())){
                addresses.add(le.getIpAddress());
            }
        }
        count = addresses.size();
        return count;
    }
    
    public void printAllHigherThanNum(int num){
        for (LogEntry le : records){
            if(le.getStatusCode() > num){
                System.out.println(le);
            }
        }
    }
    
    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        ArrayList<String> addresses = new ArrayList<String>();
        for (LogEntry le : records){
            String entry = le.getAccessTime().toString();
            int index = entry.indexOf(someday);
            if(index != -1 && (! addresses.contains(le.getIpAddress()))){
                addresses.add(le.getIpAddress());
            }
        }
        return addresses;
    }
    
    public int countUniqueIPsInRange(int low, int high){
        int count = 0;
        ArrayList <String> addresses = new ArrayList<String>();
        for (LogEntry le : records){
            if (le.getStatusCode() >= low && le.getStatusCode() <= high
            && (! addresses.contains(le.getIpAddress()))){
                addresses.add(le.getIpAddress());
                count++;
            }
        }
        return count;
    }
}
