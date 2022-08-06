package com.cis.bo;

import java.util.ArrayList;

import com.cis.db.PoolDB;

public class Pool {
	private ArrayList<Department> departmentList;
	private ArrayList<Faculty> facultyList;
	private ArrayList<Course> courseList;
	private ArrayList<CourseInstance> courseInstanceList;
	private ArrayList<Student> studentList;
	private ArrayList<Address> addressList;
	private PoolDB poolDB;
	
	public Pool() {
		departmentList = new ArrayList<Department>();
		facultyList = new ArrayList<Faculty>();
		courseList = new ArrayList<Course>();
		courseInstanceList = new ArrayList<CourseInstance>();
		studentList = new ArrayList<Student>();
		addressList = new ArrayList<Address>();
		
		poolDB = new PoolDB();
	}
	
	public void addDepartment(Department department) {
		departmentList.add(department);
	}
	
	public ArrayList<Department> extractDepartmentList() {
		return departmentList;
	}
	
	
	public void addFaculty(Faculty faculty) {
		facultyList.add(faculty);
	}
	
	public ArrayList<Faculty> extractFacultyList(short parentTableNo, long parentID) {
		ArrayList<Faculty> extractList = new ArrayList<Faculty>();
	
		// Loop through facultyList, match the object by ParentTableNo + ParentID.
		// If found add it to extractList.
		boolean bFound = false;
		for (int i = 0; i < facultyList.size(); i++) {
			Faculty obj = facultyList.get(i);
			
			short pTableNo = obj.getParentTableNo();
			long pID = obj.getParentID();
			
			if ((parentTableNo == pTableNo) && (pID == parentID)) {
				extractList.add(obj);
				bFound = true;
			}
			else {
				if (bFound)
					break;
			}
		}
		
		return extractList;
	}
	
	public void addCourse(Course course) {
		courseList.add(course);
	}
	
	public ArrayList<Course> extractCourseList(short parentTableNo, long parentID) {
		ArrayList<Course> extractList = new ArrayList<Course>();
	
		// Loop through courseList, match the object by ParentTableNo + ParentID.
		// If found add it to extractList.
		boolean bFound = false;
		for (int i = 0; i < courseList.size(); i++) {
			Course obj = courseList.get(i);
			
			short pTableNo = obj.getParentTableNo();
			long pID = obj.getParentID();
			
			if ((parentTableNo == pTableNo) && (pID == parentID)) {
				extractList.add(obj);
				bFound = true;
			}
			else {
				if (bFound)
					break;
			}
		}
		
		return extractList;
	}
	
	public void addCourseInstance(CourseInstance courseInstance) {
		courseInstanceList.add(courseInstance);
	}
	
	public ArrayList<CourseInstance> extractCourseInstanceList(short parentTableNo, long parentID) {
		ArrayList<CourseInstance> extractList = new ArrayList<CourseInstance>();
	
		// Loop through courseInstanceList, match the object by ParentTableNo + ParentID.
		// If found add it to extractList.
		boolean bFound = false;
		for (int i = 0; i < courseInstanceList.size(); i++) {
			CourseInstance obj = courseInstanceList.get(i);
			
			short pTableNo = obj.getParentTableNo();
			long pID = obj.getParentID();
			
			if ((parentTableNo == pTableNo) && (pID == parentID)) {
				extractList.add(obj);
				bFound = true;
			}
			else {
				if (bFound)
					break;
			}
		}
		
		return extractList;
	}
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	public ArrayList<Student> extractStudentList(short parentTableNo, long parentID) {
		ArrayList<Student> extractList = new ArrayList<Student>();
	
		// Loop through studentList, match the object by ParentTableNo + ParentID.
		// If found add it to extractList.
		boolean bFound = false;
		for (int i = 0; i < studentList.size(); i++) {
			Student obj = studentList.get(i);
			
			short pTableNo = obj.getParentTableNo();
			long pID = obj.getParentID();
			
			if ((parentTableNo == pTableNo) && (pID == parentID)) {
				extractList.add(obj);
				bFound = true;
			}
			else {
				if (bFound)
					break;
			}
		}
		
		return extractList;
	}
	
	public void addAddress(Address address) {
		addressList.add(address);
	}
	
	public ArrayList<Address> extractAddressList(short parentTableNo, long parentID) {
		ArrayList<Address> extractList = new ArrayList<Address>();
	
		// Loop through addressList, match the object by ParentTableNo + ParentID.
		// If found add it to extractList.
		boolean bFound = false;
		for (int i = 0; i < addressList.size(); i++) {
			Address obj = addressList.get(i);
			
			short pTableNo = obj.getParentTableNo();
			long pID = obj.getParentID();
			
			if ((parentTableNo == pTableNo) && (pID == parentID)) {
				extractList.add(obj);
				bFound = true;
			}
			else {
				if (bFound)
					break;
			}
		}
		
		return extractList;
	}
	
	public boolean loadPool(long collegeID) {
		if (! poolDB.loadDepartmentList(collegeID, departmentList) )
			return false;
			
		if (! poolDB.loadFacultyList(collegeID, facultyList) )
			return false;
				
		return true;
	}
}
