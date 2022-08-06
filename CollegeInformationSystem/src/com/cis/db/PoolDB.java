package com.cis.db;

import com.cis.bo.*;
import java.util.ArrayList;

public class PoolDB {
	
	public boolean loadDepartmentList(long collegeID, ArrayList<Department> departmentList) {
		// Load departmentList
		try {
			// select DepartmentID, Name, CollegeID, ParentTableNo, ParentID, CreateDateTime, LastUpdateDateTime, LastUpdateUser 
			// from department where CollegeID=collegeID Order By ParentTableNo, ParentID
		}
		catch(Exception e) {
			
			return false;
		}
		
		return true;
	}

	public boolean loadFacultyList(long collegeID, ArrayList<Faculty> facultyList) {
		// Load facultyList
		try {
			// select FacultyID, Name, Designation, CollegeID, ParentTableNo, ParentID, CreateDateTime, LastUpdateDateTime, LastUpdateUser 
			// from faculty where CollegeID=collegeID Order By ParentTableNo, ParentID
		}
		catch(Exception e) {
	
			return false;
		}
		
		return true;
		
	}
}
