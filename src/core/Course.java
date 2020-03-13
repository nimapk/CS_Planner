package core;

public class Course {	
	private String cno;
	private String ctitle;
	private int units;	
	private String dept_name;
	
	
	public Course( String cno, String ctitle, int units, String dept_name) {
		//super();
		this.cno = cno;
		this.ctitle = ctitle;
		this.units = units;		
		this.dept_name = dept_name;
	}
	public String getCno() {
		return cno;
	}
	public String getCtitle() {
		return ctitle;
	}	
	public int getUnits() {
		return units;
	}
	public String getDept_name() {
		return dept_name;
	}	
		
	
	@Override
	public String toString() {
		return String
				.format("Courses [Cno=%s, Ctitle=%s, Unit=%d, Dept_name=%s]",
						cno, ctitle, units, dept_name);
	}	
}