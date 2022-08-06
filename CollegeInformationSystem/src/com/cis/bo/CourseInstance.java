package com.cis.bo;

import java.util.ArrayList;
import java.util.Date;

public class CourseInstance extends CisBo{
	
	private long courseInstanceID;
	private Date startDate;
	private Date endDate;
	
	public CourseInstance() {
		tableNo = 5;
		
		studentList = new ArrayList<Student>();
		
		hasDepartmentAsChild = false;
		hasFacultyAsChild = false;
		hasCourseAsChild = false;
		hasCourseInstanceAsChild = false;
		hasStudentAsChild = true;
		hasAddressAsChild = false;				
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(courseInstanceID);
		sb.append("\t");	
		sb.append(startDate);
		sb.append("\t");
		sb.append(endDate);
		sb.append("\t");
		
		sb.append(super.toString());
		sb.append(System.getProperty("line.separator"));

		return sb.toString(); 
	}

	public long getCourseInstanceID() {
		return courseInstanceID;
	}

	public void setCourseInstanceID(long courseInstanceID) {
		this.courseInstanceID = courseInstanceID;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	public boolean addStudent(Student student) {
		
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getName().equalsIgnoreCase(student.getName()))
				return false; // Means student already exists, so cannot add another student with the same name.
		}
		
		studentList.add(student);
		return true;
	}
	
	public boolean removeStudent(String name) {
		
		Student student = null;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getName().equalsIgnoreCase(name)) {	// Student exists and can be removed.
				student = studentList.get(i);
				break;
			}
		}
		
		if (student != null) {
			studentList.remove(student);
			return true;
		}
		
		return false;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
		
}
