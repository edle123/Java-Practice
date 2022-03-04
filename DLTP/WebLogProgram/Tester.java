
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
        //Quiz Web Server Logs Q4
        LogAnalyzer q4 = new LogAnalyzer();
        q4.readFile("weblog2_log");
        System.out.println("Question 4: "+q4.countUniqueIPs());
    }

    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog-short_log");
        System.out.println(la.uniqueIPVisitsOnDay("Sep 14"));
        //Quiz Finding Unique IP Addresses Q3
        LogAnalyzer la2 = new LogAnalyzer();
        la2.readFile("weblog1_log");
        System.out.println(la2.uniqueIPVisitsOnDay("Mar 24").size());
        //Quiz Web Server Logs Q5
        LogAnalyzer q5 = new LogAnalyzer();
        q5.readFile("weblog2_log");
        System.out.println("Question 5: "+q5.uniqueIPVisitsOnDay("Sep 24").size());
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
        //Quiz Web Server Logs Q6
        LogAnalyzer q6 = new LogAnalyzer();
        q6.readFile("weblog2_log");
        System.out.println("Question 6: "+q6.countUniqueIPsInRange(200,299));
    }

    public void testCountVisitsPerIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        System.out.println("Visits per IP:\n"+la.countVisitsPerIP());
        //Tests mostNumberVisitsByIP
        System.out.println("Most visits by an IP: "
            +la.mostNumberVisitsByIP(la.countVisitsPerIP()));
        //Tests iPsMostVisits
        System.out.println("IPs with most visits:\n"
            +la.iPsMostVisits(la.countVisitsPerIP()));
        //Tests iPsForDays
        System.out.println("IPs by days:\n"
            +la.iPsForDays());
        //Tests dayWithMostIPVisits
        System.out.println("Day with most IP visits: "
            +la.dayWithMostIPVisits(la.iPsForDays()));
        //Tests iPsWithMostVisitsOnDay
        System.out.println("IP with most visits on Sep 30: "
            +la.iPsWithMostVisitsOnDay(la.iPsForDays(), "Sep 30"));
        //Quiz Counting Website Visits Q1
        LogAnalyzer q1 = new LogAnalyzer();
        q1.readFile("weblog1_log");
        System.out.println("Question 1: "+q1.mostNumberVisitsByIP(q1.countVisitsPerIP()));
        //Quiz Counting Website Visits Q2
        System.out.println("Question 2: "+q1.iPsMostVisits(q1.countVisitsPerIP()));
        //Quiz Counting Website Visits Q3
        System.out.println("Question 3: "+q1.dayWithMostIPVisits(q1.iPsForDays()));
        //Quiz Counting Website Visits Q4
        System.out.println("Question 4: "+q1.iPsWithMostVisitsOnDay(q1.iPsForDays(),"Mar 17"));
        //Quiz Web Server Logs Q7
        LogAnalyzer q7 = new LogAnalyzer();
        q7.readFile("weblog2_log");
        System.out.println("Web Server Logs Question 7: "
            +q7.mostNumberVisitsByIP(q7.countVisitsPerIP()));
        //Quiz Web Server Logs Q8
        System.out.println("Web Server Logs Question 8: "
            +q7.iPsMostVisits(q7.countVisitsPerIP()));
        //Quiz Web Server Logs Q9
        System.out.println("Web Server Logs Question 9: "
            +q7.dayWithMostIPVisits(q7.iPsForDays()));
        //Quiz Web Server Logs Q10
        System.out.println("Web Server Logs Question 10: "
            +q7.iPsWithMostVisitsOnDay(q7.iPsForDays(), "Sep 30"));
    }
}
