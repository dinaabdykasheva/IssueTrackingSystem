package datareaders;

import model.Employee;
import model.Issue;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;

/**
 * Created by Dina_Abdykasheva on 3/31/2017.
 */
public class ReadIssueFromFile extends AbstractReader {
    private String filePath;

    public ReadIssueFromFile(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Issue readIssue(int id) {
        Issue issue = null;
        File file = new File(getFilePath());
        BufferedReader bufferedReader = null;
        String s = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while ((s = bufferedReader.readLine()) != null) {
                String[] info = s.split("|");
                if (Integer.parseInt(info[1]) == id) {
                    issue = new Issue(Integer.parseInt(info[0]), info[1], info[2], info[3],info[4], info[5]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return issue;
    }
}
