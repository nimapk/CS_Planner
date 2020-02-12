package dao;

import java.util.*;
import java.sql.*;
import java.io.*;

import core.User;
 
public class UserDAO {

	private Connection myConn;
	
	public UserDAO() throws Exception {
		
		// get db properties
		Properties props = new Properties();
		props.load(new FileInputStream("anydb.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
		
		//System.out.println("DB connection successful to: " + dburl);
	}
	public List<User> searchUsers(String username) throws Exception {
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
		}
		finally {
			close(myStmt, myRs);
		}
	}	
	public void addUser(User theUser) throws Exception {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into user"
					+ " (first_name, last_name, email, major, username, password)"
					+ " values (?, ?, ?, ?, ?, ?)");
			
			// set params
			myStmt.setString(1, theUser.getFirstName());
			myStmt.setString(2, theUser.getLastName());
			myStmt.setString(3, theUser.getEmail());
			myStmt.setString(4, theUser.getMajor());
			myStmt.setString(5, theUser.getUsername());
			myStmt.setString(6, theUser.getPassword());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
	
	// add to ENROLLMENT table, not USER table
	public void addCourseToUser(int userid, String cnum, String grade) throws Exception {
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
		}
		finally {
			close(myStmt);
		}				
	}
	// find a list of courses a user passed
	public List<String> searchCoursesUserPassed(int userid) throws Exception{
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
		}
		finally {			
			close(myStmt);
		}
		
	}
	
	
	
	private User convertRowToUser(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("id");
		String firstName = myRs.getString("first_name");
		String lastName = myRs.getString("last_name");		
		String email = myRs.getString("email");
		String major = myRs.getString("major");
		String username = myRs.getString("username");		
		String password = myRs.getString("password");	
				
		User tempUser = new User(id, firstName, lastName, email, major, username, password);
		
		return tempUser;
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