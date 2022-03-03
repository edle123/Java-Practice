
/**
 * Code modified from DLTP course
 * Runs test cases for other classes
 * 
 * @Eric
 * @version 1, March 2nd, 2022
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
        //Tests printAllHigherThanNum method
        //Quiz Finding Unique IP Addresses Q2
        System.out.println("Log entries with status code > 400:");
        LogAnalyzer la2 = new LogAnalyzer();
        la2.readFile("weblog1_log");
        la2.printAllHigherThanNum(400);
    }
    
    public void testUniqueIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println("Number of unique IPs: "+la.countUniqueIPs());
    }
    
    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog-short_log");
        System.out.println(la.uniqueIPVisitsOnDay("Sep 14"));
        //Quiz Finding Unique IP Addresses Q3
        LogAnalyzer la2 = new LogAnalyzer();
        la2.readFile("weblog1_log");
        System.out.println(la2.uniqueIPVisitsOnDay("Mar 24").size());
    }
    
    public void testCountUniqueIPsInRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countUniqueIPsInRange(200,299));
        System.out.println(la.countUniqueIPsInRange(300,399));
        //Quiz Finding Unique IP Addresses Q4
        LogAnalyzer la2 = new LogAnalyzer();
        la2.readFile("weblog1_log");
        System.out.println(la2.countUniqueIPsInRange(200,299));
    }
}
