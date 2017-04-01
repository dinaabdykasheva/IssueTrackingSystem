package parser;

import model.Issue;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;

/**
 * Created by Dina_Abdykasheva on 4/1/2017.
 */
public class IssueSAXParser extends DefaultHandler {
    private Issue issue;
    private StringBuilder thisElement;
    private LinkedList<Issue> issues = new LinkedList<Issue>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML document with Issues...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = new StringBuilder();
        if (qName.equals("issue")) {
            issue = new Issue();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("issue")) {
            issues.add(issue);
        } else {
            String element = thisElement.toString();
            if (qName.equals("id")) {
                issue.setId(Integer.parseInt(element));
            } else if (qName.equals("summary")) {
                issue.setSummary(element);
            } else if (qName.equals("priority")) {
                issue.setPriority(element);
            } else if (qName.equals("status")) {
                issue.setStatus(element);
            } else if (qName.equals("description")) {
                issue.setDescription(element);
            } else if (qName.equals("reporter")) {
                issue.setReporter(element);
            }
        }
        thisElement = new StringBuilder();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Start parse XML document with Issues...");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        thisElement.append(ch, start, length);
    }

    public Issue getIssuebyID (int id) {
        Issue result = null;
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                result = issue;
            }
        }
        return result;
    }
}
