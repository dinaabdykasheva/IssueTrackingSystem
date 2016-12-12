package service;

import model.Issue;
import model.Status;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Dina_Abdykasheva on 12/12/2016.
 */
public class IssuesCollectedByStatus {
    public static List<Issue> collectIssuesByStatus (Set<Issue> issuesSet, Status status) {
        List<Issue> collectedIssuesList = new ArrayList<Issue>();
        Iterator<Issue> iterator = issuesSet.iterator();
        while (iterator.hasNext()) {
            Issue issue = iterator.next();
            if (issue.getStatus().equals(status)) {
                collectedIssuesList.add(issue);
            }
        }
        return collectedIssuesList;
    }
}
