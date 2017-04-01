import datareaders.ReadIssueFromDB;
import datareaders.ReadIssueFromFile;
import datareaders.ReadIssueFromXML;
import model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DeleteIssue;
import service.FindIssues;
import service.IssueComparator;
import service.IssuesCollectedByStatus;
import exceptions.IssueNotFoundException;
import exceptions.WrongParameterException;
import datawriter.FileWriter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Dina_Abdykasheva on 12/12/2016.
 */
public class Runner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);
    private static final String ISSUES_TXT_FILE = "C:\\Users\\Dina_Abdykasheva\\Desktop\\Issues.txt";
    private static final String ISSUES_XML_FILE = "C:\\Users\\Dina_Abdykasheva\\Desktop\\Issues.xml";

    public static void main(String[] args) throws IOException, SQLException {

        /*Employee employee = new Employee("Dina", "Tester");

        Issue epicOne = new Epic(2, "epic one Summary", Priority.MAJOR, Status.CLOSED, "epic one Description", employee);
        Story storyOne =  new Story(3, "story one Summary", Priority.MAJOR, Status.CLOSED, "story one Description", employee);
        Issue bugOne = new Bug(4, "bug one Summary", Priority.MAJOR, Status.RESOLVED, "bug one Description", employee);
        Bug bugTwo = new Bug(7, "bug two Summary", Priority.CRITICAL, Status.RESOLVED, "bug two Description", employee);
        Bug bugThree = new Bug(8, "bug one Summary", Priority.MINOR, Status.RESOLVED, "bug one Description", employee);
        Bug bugFour = new Bug(9, "bug one Summary", Priority.MINOR, Status.READY_FOR_TEST, "bug one Description", employee);

        Set<Issue> allIssues = new HashSet<Issue>();
        allIssues.add(epicOne);
        allIssues.add(storyOne);
        allIssues.add(bugOne);
        allIssues.add(bugTwo);
        allIssues.add(bugThree);
        allIssues.add(bugFour);

        Map<String, String> issueReporterMap = new HashMap<String, String>();
        Iterator<Issue> iterator = allIssues.iterator();
        while (iterator.hasNext()) {
            Issue issue = iterator.next();
            issueReporterMap.put(issue.getSummary(), issue.getReporter().getName());
        }

        try {
            FindIssues.findIssues(allIssues, 2);
        } catch (IssueNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DeleteIssue.deleteIssue(allIssues, 444);
        } catch (WrongParameterException e) {
            System.out.println(e.getMessage());
        } catch (IssueNotFoundException e) {
            System.out.println(e.getMessage());
        }

        List<Issue> resolvedIssues = IssuesCollectedByStatus.collectIssuesByStatus(allIssues, Status.RESOLVED);

        Collections.sort(resolvedIssues, new IssueComparator());

        List<Issue> openIssues = IssuesCollectedByStatus.collectIssuesByStatus(allIssues, Status.OPEN);

        FileWriter.writeToFile("C:\\Users\\Dina_Abdykasheva\\Desktop\\open issues.txt", openIssues);

        ReadIssueFromFile readIssueFromFile = new ReadIssueFromFile(ISSUES_TXT_FILE);
        try {
            Issue issue = readIssueFromFile.readIssue(1);
            System.out.println(issue.toString());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }*/

        ReadIssueFromXML readIssueFromXML = new ReadIssueFromXML(ISSUES_XML_FILE);
        try {
            Issue issue = readIssueFromXML.readIssue(1);
            System.out.println(issue.toString());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        /*Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName = Employees; user = sa; password = Kassiopeya19");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ReadIssueFromDB readIssueFromDB = new ReadIssueFromDB(connection);
        try {
            Issue issue = readIssueFromDB.readIssue(2);
        } catch (NullPointerException e ) {
            System.out.println(e.getMessage());
        }
        try {
            if (connection != null) {
                connection.close();
        }
        } catch (SQLException e) {}*/



    }

}
