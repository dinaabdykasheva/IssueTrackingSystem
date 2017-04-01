package datareaders;
import model.Employee;
import model.Issue;

import java.sql.*;

/**
 * Created by Dina_Abdykasheva on 1/5/2017.
 */
public class ReadIssueFromDB extends AbstractReader {
    private Connection connection;

    public ReadIssueFromDB(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Issue readIssue(int id) {
        Issue issue = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        } catch (SQLException e) {
            System.out.println("SQL exception" + e.getMessage());
        }
        try {
            stmt = connection.prepareStatement("select * from issues where id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getInt("id") == id)
                    issue = new Issue(rs.getInt("id"), rs.getString("summary"), rs.getString("priority"), rs.getString("status"), rs.getString("description"), rs.getString("reporter"));
            }
        } catch (SQLException e) {
            System.out.println("SQL exception" + e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.getMessage();
            }
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return issue;
    }
}
