
package dao;

import core.Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class QuestionDao {
    private Connection myConn;

    public QuestionDao() throws Exception {
		if (!CheckConnection())
		{
			ConnectionDB();
		}
        //ConnectionDB();
    }

    public void ConnectionDB() throws Exception {
        // get db properties
        Properties props = new Properties();
        props.load(getClass().getClassLoader().getResourceAsStream("anydb.properties"));

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String dburl = props.getProperty("dburl");

        // connect to database
        myConn = DriverManager.getConnection(dburl, user, password);

        //System.out.println("DB connection successful to: " + dburl);
    }
    public boolean CheckConnection() throws Exception {
        try {
            Statement myStmt = myConn.createStatement();
            myStmt.executeQuery("select 1 from user");
            close(myStmt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }    
    public List<Question> getAllQuestions() throws Exception {
        if (!CheckConnection()) {
            ConnectionDB();
        } 
        List<Question> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from SECURITY_QUESTION");

            while (myRs.next()) {
                int id = myRs.getInt("questionID");
                String question_content = myRs.getString("questionContent");
                Question question = new Question(id, question_content);
                list.add(question);
            }
            return list;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
            throws SQLException {

        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {

        }

        if (myConn != null) {
            myConn.close();
        }
    }

    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

    private void close(Statement myStmt) throws SQLException {
        close(null, myStmt, null);
    }
}
