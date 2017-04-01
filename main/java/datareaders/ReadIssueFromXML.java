package datareaders;

import model.Issue;
import org.xml.sax.SAXException;
import parser.IssueSAXParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dina_Abdykasheva on 4/1/2017.
 */
public class ReadIssueFromXML extends AbstractReader{
    private String XMLfilePath;

    public ReadIssueFromXML(String XMLfilePath) {
        this.XMLfilePath = XMLfilePath;
    }

    public String getXMLfilePath() {
        return XMLfilePath;
    }

    public void setXMLfilePath(String XMLfilePath) {
        this.XMLfilePath = XMLfilePath;
    }

    @Override
    public Issue readIssue(int id) {
        Issue issue = null;
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        IssueSAXParser handler = null;
        try {
            saxParser = saxParserFactory.newSAXParser();
            handler = new IssueSAXParser();
            saxParser.parse(new File(XMLfilePath), handler);
            issue = handler.getIssuebyID(id);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return issue;
    }
}
