package com.cis.bo;

import java.util.ArrayList;
import java.util.Date;

public abstract class CisBo {
	
	private long collegeID;	
	private short parentTableNo;
	private long parentID;
	private Date createDateTime;
	private Date lastUpdateDateTime;
	private String lastUpdateUser;
	
	// Based on user actions in the UI, this will be set to either insert or update or delete.
	// Based on this, we either generate an insert SQL or update SQL or delete SQL or Nothing.
	private UserOperations userOperation; 
	
	// This flag is set when user updates existing data in the UI and this implies the operation will be update.
    // If the flag is not set (meaning its not update) and operation is None, then we need NOT save it to database 
	// as user has not changed the data that is provided from the database.	
	private boolean dirtyFlag; 
	
	// ChildObjects and ChildLists: 
	// ChildLists are Required in base class for Recursive Traversals.
	// ChildLists will be null if the child is not applicable for a given derived class.
	// Get and Set methods are available only in derived class if a given child is applicable.
	protected ArrayList<Department> departmentList = null;
	protected ArrayList<Faculty> facultyList = null;
	protected ArrayList<Course> courseList = null;
	protected ArrayList<CourseInstance> courseInstanceList;
	protected ArrayList<Student> studentList;
	protected Address address = null;	

	// ChildExistFlags: Flags that tell if children exists or not.
	protected boolean hasDepartmentAsChild = false;
	protected boolean hasFacultyAsChild = false;
	protected boolean hasCourseAsChild = false;
	protected boolean hasCourseInstanceAsChild = false;
	protected boolean hasStudentAsChild = false;
	protected boolean hasAddressAsChild = false;
		
	public boolean recursiveTreeBuilding(Pool pool) {
		// Below Two Steps are required for every type of child based on ChildExistFlags.
		   // 1. extract your children based on ChildExistFlags
		   // 2. For each and every child in every child collection, call this method recursively on the child.
		
		
		return true;
	}
	
	public long getCollegeID() {
		return collegeID;
	}
	
	public void setCollegeID(long collegeID) {
		this.collegeID = collegeID;
	}
	
	public Date getCreateDateTime() {
		return createDateTime;
	}
	
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	
	public Date getLastUpdateDateTime() {
		return lastUpdateDateTime;
	}
	
	public void setLastUpdateDateTime(Date lastUpdateDateTime) {
		this.lastUpdateDateTime = lastUpdateDateTime;
	}
	
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}
	
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}
	
	public short getParentTableNo() {
		return parentTableNo;
	}
	
	public void setParentTableNo(short parentTableNo) {
		this.parentTableNo = parentTableNo;
	}
	
	public long getParentID() {
		return parentID;
	}
	
	public void setParentID(long parentID) {
		this.parentID = parentID;
	}

	public UserOperations getUserOperation() {
		return userOperation;
	}

	public void setUserOperation(UserOperations userOperation) {
		this.userOperation = userOperation;
	}

	public boolean isDirtyFlag() {
		return dirtyFlag;
	}

	public void setDirtyFlag(boolean dirtyFlag) {
		this.dirtyFlag = dirtyFlag;
	}
	
}
