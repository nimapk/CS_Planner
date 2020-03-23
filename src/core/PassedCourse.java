package core;

public class PassedCourse {
	private int userID;
	private String C_num;
	private String Grade;
	
	public PassedCourse(int userID, String C_num, String Grade) {
		this.userID = userID;
		this.C_num = C_num;
		this.Grade = Grade;	
	}
	public int getuserID() {
		return userID;
	}		
	public String getC_num() {
		return C_num;
	}
	public String getGrade() {
		return Grade;
	}	
	@Override
	public String toString() {
		return String
				.format("PassedCourse[userID=%d, C_num=%s, Grade=%s]",
						userID, C_num, Grade);
	}	
}
