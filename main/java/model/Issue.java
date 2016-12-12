package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Created by Dina_Abdykasheva on 12/12/2016.
 */
public class Issue {
    private int id;
    private String summary;
    private Priority priority;
    private Status status;
    private String description;
    private  Employee reporter;

    public Issue(int id, String summary, Priority priority, Status status, String description, Employee reporter) {
        this.id = id;
        this.summary = summary;
        this.priority = priority;
        this.status = status;
        this.description = description;
        this.reporter = reporter;
    }

    public Issue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getReporter() {
        return reporter;
    }

    public void setReporter(Employee reporter) {
        this.reporter = reporter;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Issue.class);

    public void create() {
        setStatus(Status.OPEN);
        LOGGER.info("Issue was created. Status of issue is OPEN");
    }

    public void assign(Employee employee) {
        setStatus(Status.ASSIGNED);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", summary='" + summary + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", reporter=" + reporter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return id == issue.id &&
                summary == issue.summary &&
                priority == issue.priority &&
                status == issue.status &&
                description == issue.description &&
                reporter == issue.reporter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, summary, priority, status, description, reporter);
    }
}
