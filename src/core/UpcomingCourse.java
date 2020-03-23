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
	public int getIntOfAsmester(){//Spring: 0, Summer: 1, Fall: 2, Winter: 3
		if (aSemester.equals("Spring"))
			return 0;
		else if (aSemester.equals("Summer"))
			return 1;
		else if (aSemester.equals("Fall"))
			return 2;
		else
			return 3;
	}
	@Override
	public String toString() {
		return String
				.format("UpcomingCourse[aID=%d, aCno=%s, aSemester=%s, Unit=%d]",
						aID, aCno, aSemester, aYear);
	}	
}

//abc10: all of them