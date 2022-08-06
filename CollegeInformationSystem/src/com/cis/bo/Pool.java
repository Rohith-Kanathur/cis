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
	
	// loadCollegeObject() method is called from main. User provides college name as input.
	public boolean loadCollegeObject(String name, College college) {
		return poolDB.loadCollege(name, college);
	}
	
	// loadPool() method is called from main after calling loadCollegeObject().
	public boolean loadPool(long collegeID) {
		
		if (! poolDB.loadDepartmentList(collegeID, departmentList) )
			return false;
		
		// Debug Code
		/*
		System.out.println("Printing Department Objects");
		for (int i = 0; i < departmentList.size(); i++)
			System.out.print(departmentList.get(i));
		System.out.println();
		*/
		
		if (! poolDB.loadFacultyList(collegeID, facultyList) )
			return false;
		
		// Debug Code
		/*
		System.out.println("Printing Faculty Objects");
		for (int i = 0; i < facultyList.size(); i++)
				System.out.print(facultyList.get(i));
		System.out.println();		
		*/
			
		if (! poolDB.loadCourseList(collegeID, courseList) )
			return false;
		
		// Debug Code
		/*
		System.out.println("Printing Course Objects");
		for (int i = 0; i < courseList.size(); i++)
			System.out.print(courseList.get(i));
		System.out.println();	
		*/
		
		if (! poolDB.loadCourseInstanceList(collegeID, courseInstanceList) )
			return false;
		
		// Debug Code
		/*
		System.out.println("Printing Course Instance Objects");
		for (int i = 0; i < courseInstanceList.size(); i++)
			System.out.print(courseInstanceList.get(i));
		System.out.println();	
		*/
		
		if (! poolDB.loadStudentList(collegeID, studentList) )
			return false;
		
		// Debug Code
		/*
		System.out.println("Printing Student Objects");
		for (int i = 0; i < studentList.size(); i++)
			System.out.print(studentList.get(i));
		System.out.println();	
		*/
		
		if (! poolDB.loadAddressList(collegeID, addressList) )
			return false;
		
		// Debug Code
		/*
		System.out.println("Printing Address Objects");
		for (int i = 0; i < addressList.size(); i++)
				System.out.print(addressList.get(i));
		System.out.println();
		*/
		
		return true;
	}

	public ArrayList<Department> extractDepartmentList(short parentTableNo, long parentID) {
		ArrayList<Department> extractList = new ArrayList<Department>();
		
		// Loop through departmentList, match the object by ParentTableNo + ParentID.
		// If found add it to extractList.
		boolean bFound = false;
		for (int i = 0; i < departmentList.size(); i++) {
			Department obj = departmentList.get(i);
			
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
	
	public Address extractAddress(short parentTableNo, long parentID) {
		Address address = null;
	
		// Loop through addressList, match the object by ParentTableNo + ParentID.
		// If found, return the address object.
		for (int i = 0; i < addressList.size(); i++) {
			Address obj = addressList.get(i);
			
			short pTableNo = obj.getParentTableNo();
			long pID = obj.getParentID();
			
			if ((parentTableNo == pTableNo) && (pID == parentID)) {
				address = obj;
				break; // Only one address exists as a child to any given entity.
			}
		}
		
		return address;
	}

}
