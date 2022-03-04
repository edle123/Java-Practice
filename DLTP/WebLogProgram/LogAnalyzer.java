
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

    public HashMap <String, Integer> countVisitsPerIP(){
        HashMap <String, Integer> addresses = new HashMap <String,Integer>();
        for (LogEntry le : records){
            if (addresses.containsKey(le.getIpAddress())){
                int value = addresses.get(le.getIpAddress());
                addresses.put(le.getIpAddress(), value + 1);
            }
            else{
                addresses.put(le.getIpAddress(), 1);
            }
        }
        return addresses;
    }

    public int mostNumberVisitsByIP(HashMap<String, Integer> addresses){
        int max = 0;
        for(Integer count : addresses.values()){
            if(max < count){
                max = count;
            }
        }
        return max;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> addresses){
        ArrayList<String> mostVisits = new ArrayList<String>();
        int max = mostNumberVisitsByIP(addresses);
        for(Map.Entry<String,Integer> entry : addresses.entrySet()){
            if(max == entry.getValue()){
                mostVisits.add(entry.getKey());
            }
        }
        return mostVisits;
    }

    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> days = new HashMap<String, ArrayList<String>>();
        for (LogEntry entry : records){
            String date = entry.getAccessTime().toString().substring(4,10);
            ArrayList<String> addresses = days.get(date);
            if(days.containsKey(date)){
                addresses.add(entry.getIpAddress());
                days.put(date, addresses);
            }
            else{
                addresses = new ArrayList<String>();
                addresses.add(entry.getIpAddress());
                days.put(date, addresses);
            }
        }
        return days;
    }

    public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> days){
        String date = "";
        int count = 0;
        for(Map.Entry<String, ArrayList<String>> entry : days.entrySet()){
            if(count < entry.getValue().size()){
                count = entry.getValue().size();
                date = entry.getKey();
            }
        }
        return date;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> days,
    String date){
        HashMap <String, Integer> addresses = new HashMap <String, Integer>();
        for(Map.Entry<String,ArrayList<String>> entry : days.entrySet()){
            if(date.equals(entry.getKey())){
                ArrayList<String> IPs = entry.getValue();
                for(int i = 0; i < IPs.size(); i++){
                    String IP = IPs.get(i);
                    if(addresses.containsKey(IP)){
                        int value = addresses.get(IP);
                        addresses.put(IP, value + 1);
                    }
                    else{
                        addresses.put(IP, 1);
                    }
                }
            }
        }
        return iPsMostVisits(addresses);
    }
}
