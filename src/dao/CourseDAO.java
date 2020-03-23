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
		if (!CheckConnection())
		{
			ConnectionDB();
		}
		//ConnectionDB();//abc10		
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
        if (!CheckConnection()) {
            ConnectionDB();
        } 
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
        if (!CheckConnection()) {
            ConnectionDB();
        } 
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
	//public List<String> searchCoursesUserAdded(int userid) throws Exception{ //cut a part of aCNO
	public List<String> searchUpcomingCoursesOfUser(int userid) throws Exception{ //cut a part of aCNO
        if (!CheckConnection()) {
            ConnectionDB();
        } 
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
	public List<String> searchUpcomingCoursesInYear(int userid, int tYear) throws Exception{ 
        if (!CheckConnection()) {
            ConnectionDB();
        }		
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
				//String[] aCnum = myRs.getString("aCNO").split(" - ");
				//list.add(aCnum[0] + " - " + myRs.getString("aSemester"));
				String aCnum = myRs.getString("aCNO");
				list.add(aCnum + " = " + myRs.getString("aSemester"));
			}	
			
			return list;
		}
		finally {			
			close(myStmt, myRs);
		}
		
	}		
    
    // add to ENROLLMENT table
    public void addPassedCourseToUser(int userid, String cnum, String grade) throws Exception {
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
    
    // calculate total units of upcoming courses for a user
//    public int calculateTotalUnitsOfUpcomingCourse(int user_id) throws Exception {
//        if (!CheckConnection()) {
//            ConnectionDB();
//        }    	
//        int total_units = 0;
//        PreparedStatement myStmt = null;
//        ResultSet myRs = null;
//
//        try {
//            myStmt = myConn.prepareStatement("SELECT SUM(Units) as userTotalUnits FROM ENROLLMENT, COURSES, user WHERE C_num = CNO AND userID = id AND id = ?");
//            myStmt.setString(1, Integer.toString(user_id));
//            myRs = myStmt.executeQuery();
//
//            while (myRs.next()) {
//                total_units = myRs.getInt("userTotalUnits");
//            }
//            return total_units;
//        } finally {
//            close(myStmt, myRs);
//        }
//    }    
    
	
    // calculate total units for a user
    public int calculateTotalUnitsOfUser(int user_id) throws Exception {
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
    public List<String> searchPassedCourseOfUser(int userid) throws Exception {
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
    
    public Map<String, Course> getAllCoursesAsMap() throws Exception {
        if (!CheckConnection()) {
            ConnectionDB();
        }     	
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
