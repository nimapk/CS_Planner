package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import core.Course;
import core.UpcomingCourse;

public class CourseDAO {

    private Connection myConn;

	public CourseDAO() throws Exception {
		ConnectionDB();//abc10		
	}
	
	//abc10
	public void ConnectionDB() throws Exception{
		// get db properties
		Properties props = new Properties();
		props.load(getClass()
				.getClassLoader().getResourceAsStream("anydb.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
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
        } finally {
            close(myStmt, myRs);
        }
    }

	//abc10
	public List<UpcomingCourse> getAllUpcomingCourses(int userid) throws Exception {
		List<UpcomingCourse> list = new ArrayList<>();
		
		//Statement myStmt = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery("select * from ADDED_COURSES");

			//prepare statement
			myStmt = myConn.prepareStatement("select * from ADDED_COURSES where aID like ?");
			myStmt.setString(1, Integer.toString(userid));
			myRs = myStmt.executeQuery();			
			
			while (myRs.next()) {
				UpcomingCourse tempCourse = convertRowToUpcomingCourse(myRs);
				list.add(tempCourse);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}   
	
	

	//abc10
	public void addUpcomingCourseToUser(int aID, String aCNO, String aSemester, int aYear) throws Exception {
		if (!CheckConnection())
		{
			ConnectionDB();
		}
		PreparedStatement myStmt = null;

		try {
			// prepare statement			
			myStmt = myConn.prepareStatement("insert into ADDED_COURSES"
					+ " (aID, aCNO, aSemester, aYear)"
					+ " values (?, ?, ?, ?)");;
			
			// set params					
			myStmt.setInt(1, aID);
			myStmt.setString(2, aCNO);
			myStmt.setString(3, aSemester);
			myStmt.setInt(4, aYear);
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}				
	}	
	
	//abc10
	public List<String> searchCoursesUserAdded(int userid) throws Exception{ //cut a part of aCNO
		List<String> list = new ArrayList<>();		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//prepare statement
			myStmt = myConn.prepareStatement("select aCNO from ADDED_COURSES where aID like ?");
			myStmt.setString(1, Integer.toString(userid));
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				String[] aCnum = myRs.getString("aCNO").split(" - ");
				list.add(aCnum[0]);
			}	
			
			return list;
		}
		finally {			
			close(myStmt, myRs);
		}
		
	}	
	
	//abc11
	public List<String> searchCoursesInSemester(int userid, int tYear) throws Exception{ 
		List<String> list = new ArrayList<>();		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//prepare statement
			myStmt = myConn.prepareStatement("select * from ADDED_COURSES where aID like ? AND aYear like ?");
			myStmt.setString(1, Integer.toString(userid));
			myStmt.setString(2, Integer.toString(tYear));
			
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				String[] aCnum = myRs.getString("aCNO").split(" - ");
				list.add(aCnum[0] + " - " + myRs.getString("aSemester"));
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

	//abc10
	private UpcomingCourse convertRowToUpcomingCourse(ResultSet myRs) throws SQLException {		
		int aID = myRs.getInt("aID");	
		String aCNO = myRs.getString("aCNO");
		String aSemester = myRs.getString("aSemester");		
		int aYear = myRs.getInt("aYear");
		
				
		UpcomingCourse tempCourse = new UpcomingCourse(aID, aCNO, aSemester, aYear);
		
		return tempCourse;
	}
	
	//abc10
	public boolean CheckConnection() throws Exception{
		try
		{
			Statement myStmt = myConn.createStatement();
			myStmt.executeQuery("select 1 from user");
			close(myStmt);
			return true;
		}
		catch (Exception e)
		{
			return false;
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
