package datareaders;

import model.Employee;
import model.Issue;

/**
 * Created by Dina_Abdykasheva on 3/31/2017.
 */
public abstract class AbstractReader {
    public abstract Issue readIssue (int id);
}
