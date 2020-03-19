package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import core.User;

public class UserDAO {

    private Connection myConn;

    public UserDAO() throws Exception {
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

    public List<User> searchUsers(String username) throws Exception {
        if (!CheckConnection()) {
            ConnectionDB();
        }    	
        List<User> list = new ArrayList<>();

        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            //username += "%";
            myStmt = myConn.prepareStatement("select * from user where username like ?");

            myStmt.setString(1, username);

            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                User tempUser = convertRowToUser(myRs);
                list.add(tempUser);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    public void addUser(User theUser) throws Exception {
        if (!CheckConnection()) {
            ConnectionDB();
        }     	
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = myConn.prepareStatement("insert into user"
                    + " (first_name, last_name, email, major, username, password, security_questionID, security_answer)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)");

            // set params
            myStmt.setString(1, theUser.getFirstName());
            myStmt.setString(2, theUser.getLastName());
            myStmt.setString(3, theUser.getEmail());
            myStmt.setString(4, theUser.getMajor());
            myStmt.setString(5, theUser.getUsername());
            myStmt.setString(6, theUser.getPassword());
            myStmt.setInt(7, theUser.getQuestionID());
            myStmt.setString(8, theUser.getQuestion());

            // execute SQL
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }

    }

    // add to ENROLLMENT table, not USER table
    public void addCourseToUser(int userid, String cnum, String grade) throws Exception {
        if (!CheckConnection()) {
            ConnectionDB();
        }
        PreparedStatement myStmt = null;

        try {
            // prepare statement			
            myStmt = myConn.prepareStatement("insert into ENROLLMENT"
                    + " (userID, C_num, Grade)"
                    + " values (?, ?, ?)");;

            // set params		
            myStmt.setInt(1, userid);
            myStmt.setString(2, cnum);
            myStmt.setString(3, grade);

            // execute SQL
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }
    // calculate total units for a user

    public int calculateTotalUnits(int user_id) throws Exception {
        if (!CheckConnection()) {
            ConnectionDB();
        }    	
        int total_units = 0;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.prepareStatement("SELECT SUM(Units) as userTotalUnits FROM ENROLLMENT, COURSES, user WHERE C_num = CNO AND userID = id AND id = ?");
            myStmt.setString(1, Integer.toString(user_id));
            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                total_units = myRs.getInt("userTotalUnits");
            }
            return total_units;
        } finally {
            close(myStmt, myRs);
        }
    }

    // find a list of courses a user passed
    public List<String> searchCoursesUserPassed(int userid) throws Exception {
        if (!CheckConnection()) {
            ConnectionDB();
        }     	
        List<String> list = new ArrayList<>();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            //prepare statement
            myStmt = myConn.prepareStatement("select C_num from ENROLLMENT where userID like ?");
            myStmt.setString(1, Integer.toString(userid));
            myRs = myStmt.executeQuery();
            while (myRs.next()) {
                list.add(myRs.getString("C_num"));
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }

    }

    public List<String> searchGradeUserPassed(int userid) throws Exception {
        if (!CheckConnection()) {
            ConnectionDB();
        } 
        List<String> list = new ArrayList<>();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            //prepare statement
            myStmt = myConn.prepareStatement("select Grade from ENROLLMENT where userID like ?");
            myStmt.setString(1, Integer.toString(userid));
            myRs = myStmt.executeQuery();
            while (myRs.next()) {
                list.add(myRs.getString("Grade"));
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }

    }

    public double getScoreFromGrade(String grade) {
        double scale = 0.0;
        switch (grade) {
            case "A+":
                scale = 4.0;
                break;
            case "A":
                scale = 4.0;
                break;
            case "A-":
                scale = 3.7;
                break;
            case "B+":
                scale = 3.3;
                break;
            case "B":
                scale = 3.0;
                break;
            case "B-":
                scale = 2.7;
                break;
            case "C+":
                scale = 2.3;
                break;
            case "C":
                scale = 2.0;
                break;
            case "C-":
                scale = 1.7;
                break;
            case "D+":
                scale = 1.3;
                break;
            case "D":
                scale = 1.0;
                break;
            case "D-":
                scale = 0.7;
                break;
            case "F":
                scale = 0.0;
                break;
            default:
                scale = 4.0;
                break;
        }
        return scale;
    }

    private User convertRowToUser(ResultSet myRs) throws SQLException {

        int id = myRs.getInt("id");
        String firstName = myRs.getString("first_name");
        String lastName = myRs.getString("last_name");
        String email = myRs.getString("email");
        String major = myRs.getString("major");
        String username = myRs.getString("username");
        String password = myRs.getString("password");
        int security_ID = myRs.getInt("security_questionID");
        String question = myRs.getString("security_answer");

        User tempUser = new User(id, firstName, lastName, email, major, username, password, security_ID, question);

        return tempUser;
    }

    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
            throws SQLException {

        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {
            myStmt.close();
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
