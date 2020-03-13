package ui;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.UpcomingCourse;

public class NewCoursesTableModel extends AbstractTableModel {

	//private static final int CNO = 0;
	private static final int CCOURSE = 0;
	private static final int SEMESTER = 1;
	private static final int YEAR = 2;

	private String[] columnNames = {"COURSE", "SEMESTER",
			"YEAR" };
	private List<UpcomingCourse> upcourses;	//change later

	public NewCoursesTableModel(List<UpcomingCourse> theCourses) {
		upcourses = theCourses;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return upcourses.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		UpcomingCourse tempCourse = upcourses.get(row);

		switch (col) {
//		case CNO:
//			return tempCourse.getCno();
		case CCOURSE:			
			return tempCourse.getaCno();
		case SEMESTER:
			return tempCourse.getaSemester();
		case YEAR:
			return tempCourse.getaYear();
		default:
			return tempCourse.getaCno();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}

//abc10 : all of them