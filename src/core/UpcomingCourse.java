package core;

public class UpcomingCourse {
	private int aID;
	private String aCno;
	private String aSemester;
	private int aYear;	
	
	
	public UpcomingCourse(int aID, String aCno, String aSemester, int aYear) {
		this.aID = aID;
		this.aCno = aCno;
		this.aSemester = aSemester;
		this.aYear = aYear;		
	}
	public int getaID() {
		return aID;
	}		
	public String getaCno() {
		return aCno;
	}
	public String getaSemester() {
		return aSemester;
	}	
	public int getaYear() {
		return aYear;
	}
	@Override
	public String toString() {
		return String
				.format("UpcomingCourse[aID=%d, aCno=%s, aSemester=%s, Unit=%d]",
						aID, aCno, aSemester, aYear);
	}	
}

//abc10: all of them