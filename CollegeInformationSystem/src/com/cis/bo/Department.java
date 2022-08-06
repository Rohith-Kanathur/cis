package com.cis.bo;

import java.util.ArrayList;

public class Department extends CisBo {
	
	private long departmentID;
	private String name;
	
	public Department() {
		this.facultyList = new ArrayList<Faculty>();
		this.courseList = new ArrayList<Course>();
		
		hasDepartmentAsChild = false;
		hasFacultyAsChild = true;
		hasCourseAsChild = true;
		hasCourseInstanceAsChild = false;
		hasStudentAsChild = false;
		hasAddressAsChild = true;		
	}
	
	public long getDepartmentID() {
		return departmentID;
	}
	
	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public ArrayList<Faculty> getFacultyList() {
		return facultyList;
	}

	public void setFacultyList(ArrayList<Faculty> facultyList) {
		this.facultyList = facultyList;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}
	
	public boolean addFaculty(Faculty faculty) {
		
		for (int i = 0; i < facultyList.size(); i++) {
			if (facultyList.get(i).getName().equalsIgnoreCase(faculty.getName()))
				return false; // Means faculty already exists, so cannot add another faculty with the same name.
		}
		
		facultyList.add(faculty);
		return true;
	}
	
	
	public boolean removeFaculty(String name) {

		Faculty faculty = null;
		for (int i = 0; i < facultyList.size(); i++) {
			if (facultyList.get(i).getName().equalsIgnoreCase(name)) {
				faculty = facultyList.get(i);
				break;
			}
		}
		
		if (faculty != null) {
			facultyList.remove(faculty);
			return true;
		}
		
		return false;
	}
	
	public boolean addCourse(Course course) {

		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getName().equalsIgnoreCase(course.getName()))
				return false; // Means course already exists, so cannot add another course with the same name.
		}
		
		courseList.add(course);
		return true;
	}
	
	public boolean removeCourse(String name) {

		Course course = null;
		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getName().equalsIgnoreCase(name)) {
				course = courseList.get(i);
				break;
			}
		}
		
		if (course != null) {
			courseList.remove(course);
			return true;
		}
		
		return false;
	}
	
}
