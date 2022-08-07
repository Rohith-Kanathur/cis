package com.cis.bo;

import java.util.ArrayList;
import java.util.HashMap;

import com.cis.db.PoolDB;

public class Pool {
	private HashMap<Short, HashMap<Long, ArrayList<Faculty>>> facultyMaps;
	private HashMap<Short, HashMap<Long, ArrayList<Course>>> courseMaps;
	private HashMap<Short, HashMap<Long, ArrayList<CourseInstance>>> courseInstanceMaps;
	private HashMap<Short, HashMap<Long, ArrayList<Student>>> studentMaps;
	private HashMap<Short, HashMap<Long, Address>> addressMaps;
	
	private ArrayList<Department> departmentList; 

	private PoolDB poolDB;
	
	public Pool() {
		departmentList = new ArrayList<Department>();

		facultyMaps = new HashMap<Short, HashMap<Long, ArrayList<Faculty>>>();
		courseMaps = new HashMap<Short, HashMap<Long, ArrayList<Course>>>();
		courseInstanceMaps = new HashMap<Short, HashMap<Long, ArrayList<CourseInstance>>>();
		studentMaps = new HashMap<Short, HashMap<Long, ArrayList<Student>>>();
		addressMaps = new HashMap<Short, HashMap<Long, Address>>();
				
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
		
		if (! poolDB.loadFacultyList(collegeID, facultyMaps) )
			return false;
		
		// Debug Code
		/*
		System.out.println("Printing Faculty Objects");
		for (int i = 0; i < facultyList.size(); i++)
				System.out.print(facultyList.get(i));
		System.out.println();		
		*/
			
		if (! poolDB.loadCourseList(collegeID, courseMaps) )
			return false;
		
		// Debug Code
		/*
		System.out.println("Printing Course Objects");
		for (int i = 0; i < courseList.size(); i++)
			System.out.print(courseList.get(i));
		System.out.println();	
		*/
		
		if (! poolDB.loadCourseInstanceList(collegeID, courseInstanceMaps) )
			return false;
		
		// Debug Code
		/*
		System.out.println("Printing Course Instance Objects");
		for (int i = 0; i < courseInstanceList.size(); i++)
			System.out.print(courseInstanceList.get(i));
		System.out.println();	
		*/
		
		if (! poolDB.loadStudentList(collegeID, studentMaps) )
			return false;
		
		// Debug Code
		/*
		System.out.println("Printing Student Objects");
		for (int i = 0; i < studentList.size(); i++)
			System.out.print(studentList.get(i));
		System.out.println();	
		*/
		
		if (! poolDB.loadAddressList(collegeID, addressMaps) )
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
		return departmentList;
	}
	
	public ArrayList<Faculty> extractFacultyList(short parentTableNo, long parentID) {
		return facultyMaps.get(parentTableNo).get(parentID);
	}
	
	public ArrayList<Course> extractCourseList(short parentTableNo, long parentID) {
		return courseMaps.get(parentTableNo).get(parentID);
	}
	
	public ArrayList<CourseInstance> extractCourseInstanceList(short parentTableNo, long parentID) {
		return courseInstanceMaps.get(parentTableNo).get(parentID);
	}
	
	public ArrayList<Student> extractStudentList(short parentTableNo, long parentID) {
		return studentMaps.get(parentTableNo).get(parentID);
	}
	
	public Address extractAddress(short parentTableNo, long parentID) {
		return addressMaps.get(parentTableNo).get(parentID);
	}

}
