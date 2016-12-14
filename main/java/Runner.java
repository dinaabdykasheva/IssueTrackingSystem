import model.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DeleteIssue;
import service.FindIssues;
import service.IssueComparator;
import service.IssuesCollectedByStatus;
import service.exceptions.IssueNotFoundException;
import service.exceptions.WrongParameterException;
import service.file.FileWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by Dina_Abdykasheva on 12/12/2016.
 */
public class Runner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\Dina_Abdykasheva\\Desktop\\Employee.xls");
        Workbook workBook = new HSSFWorkbook(file);
        String firstTesterName = workBook.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
        String firstTesterTitle = workBook.getSheetAt(0).getRow(0).getCell(1).getStringCellValue();
        String secondTesterName = workBook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
        String secondTesterTitle = workBook.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
        String firstDevName = workBook.getSheetAt(0).getRow(2).getCell(0).getStringCellValue();
        String firstDevTitle = workBook.getSheetAt(0).getRow(2).getCell(1).getStringCellValue();
        String secondDevName = workBook.getSheetAt(0).getRow(3).getCell(0).getStringCellValue();
        String secondDevTitle = workBook.getSheetAt(0).getRow(3).getCell(1).getStringCellValue();
        String thirdDevName = workBook.getSheetAt(0).getRow(4).getCell(0).getStringCellValue();
        String thirdDevTitle = workBook.getSheetAt(0).getRow(4).getCell(1).getStringCellValue();
        String coordinatorName = workBook.getSheetAt(0).getRow(5).getCell(0).getStringCellValue();
        String coordinatorTitle = workBook.getSheetAt(0).getRow(5).getCell(1).getStringCellValue();
        file.close();

        Employee firstTester = new Employee(firstTesterName, firstTesterTitle);
        Employee secondTester = new Employee(secondTesterName, secondTesterTitle);
        Employee firstDeveloper = new Employee(firstDevName, firstDevTitle);
        Employee secondDeveloper = new Employee(secondDevName, secondDevTitle);
        Employee thirdDeveloper = new Employee(thirdDevName, thirdDevTitle);
        Employee coordinator = new Employee(coordinatorName, coordinatorTitle);


        Issue epicOne = new Epic(2, "epic one Summary", Priority.MAJOR, Status.CLOSED, "epic one Description", coordinator);
        Story storyOne =  new Story(3, "story one Summary", Priority.MAJOR, Status.CLOSED, "story one Description", firstTester);
        Issue bugOne = new Bug(4, "bug one Summary", Priority.MAJOR, Status.RESOLVED, "bug one Description", secondTester);
        Bug bugTwo = new Bug(7, "bug two Summary", Priority.CRITICAL, Status.RESOLVED, "bug two Description", firstTester);
        Bug bugThree = new Bug(8, "bug one Summary", Priority.MINOR, Status.RESOLVED, "bug one Description", secondTester);
        Bug bugFour = new Bug(9, "bug one Summary", Priority.MINOR, Status.READY_FOR_TEST, "bug one Description", secondTester);
        Bug bugFive = new Bug(10, "bug one Summary", Priority.TRIVIAL, Status.READY_FOR_TEST, "bug one Description", secondTester);
        Bug bugSix = new Bug(11, "bug one Summary", Priority.MAJOR, Status.REOPENED, "bug one Description", secondTester);
        Bug bugSeven = new Bug(12, "bug one Summary", Priority.MAJOR, Status.RESOLVED, "bug one Description", secondTester);
        Bug majorBug = new Bug(13, "Major Bug Summary", Priority.MAJOR, Status.NEW, "Major Bug Description", firstTester);
        Bug minorBug = new Bug(14, "Minor Bug Summary", Priority.MINOR, Status.NEW, "Minor Bug Description", firstTester);
        Issue epicTwo = new Issue(5, "Major Epic Summary", Priority.MAJOR, Status.NEW, "Major Epic Description", firstDeveloper);
        Issue storyTwo = new Issue(6,"Major Story Summary", Priority.MAJOR, Status.NEW, "Major Story Description", firstDeveloper);

        Set<Issue> allIssues = new HashSet<Issue>();
        allIssues.add(epicOne);
        allIssues.add(storyOne);
        allIssues.add(bugOne);
        allIssues.add(bugTwo);
        allIssues.add(bugThree);
        allIssues.add(bugFour);
        allIssues.add(bugFive);
        allIssues.add(bugSix);
        allIssues.add(bugSeven);
        allIssues.add(majorBug);
        allIssues.add(minorBug);
        allIssues.add(epicTwo);
        allIssues.add(storyTwo);

        majorBug.create();
        minorBug.create();
        epicTwo.create();
        storyTwo.create();

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

        System.out.println("for git testing");

        System.out.println("for git testing2");
    }

}
