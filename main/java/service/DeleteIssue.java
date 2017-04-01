package service;

import model.Issue;
import model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exceptions.IssueNotFoundException;
import exceptions.WrongParameterException;

import java.util.Iterator;
import java.util.Set;


/**
 * Created by Dina_Abdykasheva on 12/12/2016.
 */
public class DeleteIssue {
    public static void deleteIssue(Set<Issue> set, int id) throws WrongParameterException, IssueNotFoundException {
        boolean flag = false;
        Iterator<Issue> iterator = set.iterator();
        while (iterator.hasNext()) {
            Issue issue = iterator.next();
            if (issue.getId() == id) {
                if (issue.getStatus() != Status.CLOSED) {
                    LOGGER.error("Issue with status != CLOSED cannot be deleted");
                    throw new WrongParameterException("Issue with status != CLOSED cannot be deleted");
                } else {
                    set.remove(issue);
                    flag = true;
                    LOGGER.info("Issue " + issue.getId() + " was deleted");
                }
            }
        }
        if (flag) {
            System.out.println("Issue was deleted");
        }
        else {
            LOGGER.info("Issue not found");
            throw new IssueNotFoundException("Issue not found");
        }
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteIssue.class);
}
