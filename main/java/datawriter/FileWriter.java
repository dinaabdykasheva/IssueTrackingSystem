package datawriter;

import model.Issue;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Dina_Abdykasheva on 12/12/2016.
 */
public class FileWriter {
    public static void writeToFile (String filename, List<Issue> content) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int i = 0; i < content.size(); i++) {
                writer.println(content + "\n");
            }
            writer.close();
            LOGGER.info("Issues were written to file " + filename);
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(FileWriter.class);
}
