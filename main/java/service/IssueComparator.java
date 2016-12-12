package service;

import model.Issue;

import java.util.Comparator;

/**
 * Created by Dina_Abdykasheva on 12/12/2016.
 */
public class IssueComparator implements Comparator<Issue>{

    @Override
    public int compare(Issue o1, Issue o2) {
        int result;
        if (o1.getId() > o2.getId()) {
            result = 1;
        } else if (o1.getId() < o2.getId()) {
            result = -1;
        } else {
            result = 0;
        }
        return result;
    }
}
