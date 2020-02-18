package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import core.Course;


public class CourseDAO {

	private Connection myConn;
	
	public CourseDAO() throws Exception {
		
		// get db properties
		Properties props = new Properties();
		props.load(getClass()
				.getClassLoader().getResourceAsStream("anydb.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
		
		//System.out.println("DB connection successful to: " + dburl);
	}
	public List<Course> getAllCourses() throws Exception {
		List<Course> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from COURSES");
			
			while (myRs.next()) {
				Course tempCourse = convertRowToCourse(myRs);
				list.add(tempCourse);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}	

	public Map<String, Course> getAllCoursesAsMap() throws Exception {
        Map<String, Course> list = new HashMap<String, Course>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from COURSES");

            while (myRs.next()) {
                Course tempCourse = convertRowToCourse(myRs);
                list.put(tempCourse.getCno(), tempCourse);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }
    
	private Course convertRowToCourse(ResultSet myRs) throws SQLException {		
		String cno = myRs.getString("cno");
		String ctitle = myRs.getString("ctitle");		
		int units = myRs.getInt("units");
		String dept_name = myRs.getString("dept_name");	
				
		Course tempCourse = new Course(cno, ctitle, units, dept_name);
		
		return tempCourse;
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