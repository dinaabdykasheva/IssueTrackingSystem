package service;

import model.Issue;
import exceptions.IssueNotFoundException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Dina_Abdykasheva on 12/12/2016.
 */
public class FindIssues {
    public static void findIssues(Set<Issue> list, Object o) throws IssueNotFoundException {
        boolean flag = false;
        Set<Issue> is = new HashSet<Issue>();
        Iterator<Issue> it = list.iterator();
        while (it.hasNext()) {
            Issue issue = it.next();
            if (issue.getId() == o) {
                is.add(issue);
                flag = true;
                LOGGER.info("Next issues found", issue);

            } else if (issue.getPriority().equals(o)) {
                is.add(issue);
                flag = true;
                LOGGER.info("Next issues found", issue);
            } else if (issue.getStatus().equals(o)) {
                is.add(issue);
                flag = true;
                LOGGER.info("Next issues found", issue);
            } else if (issue.getReporter().equals(o)) {
                is.add(issue);
                flag = true;
                LOGGER.info("Next issues found", issue);
            }
        }
        if (flag) {
            for (Issue issue : is) {
                System.out.println(issue);
            }
        } else {
            LOGGER.info("Issue not found");
            throw new IssueNotFoundException("Issue not found!");
        }

    }

    private static final Logger LOGGER = LoggerFactory.getLogger(FindIssues.class);
}
