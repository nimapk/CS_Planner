package ui;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.Course;

public class NewCoursesTableModel extends AbstractTableModel {

	//private static final int CNO = 0;
	private static final int CTITLE = 0;
	private static final int UNITS = 1;
	private static final int DEPT_NAME = 2;

	private String[] columnNames = {"TITLE", "SEMESTER",
			"YEAR" };
	private List<Course> courses;	//change later

	public NewCoursesTableModel(List<Course> theCourses) {
		courses = theCourses;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return courses.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Course tempCourse = courses.get(row);

		switch (col) {
//		case CNO:
//			return tempCourse.getCno();
		case CTITLE:
			return tempCourse.getCtitle();
		case UNITS:
			return tempCourse.getUnits();
		case DEPT_NAME:
			return tempCourse.getDept_name();
		default:
			return tempCourse.getCno();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
