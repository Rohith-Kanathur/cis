package com.cis.bo;

import java.util.ArrayList;
import java.util.Date;

public abstract class CisBo {
	
	protected short tableNo;
	protected long primaryKey;
	
	protected long collegeID;	
	protected short parentTableNo;
	protected long parentID;
	protected Date createDateTime;
	protected Date lastUpdateDateTime;
	protected String lastUpdateUser;
	
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
		
	public void recursiveTreeBuilding(Pool pool) {
		// Below Two Steps are required for every type of child based on ChildExistFlags.
		// 1. Extract your children based on ChildExistFlags.
		// 2. For each and every child in every child collection, call this method recursively on the child.
		
		if (hasDepartmentAsChild) {
			departmentList = pool.extractDepartmentList(tableNo, primaryKey);
			
			for (int i=0; i<departmentList.size(); i++)
				departmentList.get(i).recursiveTreeBuilding(pool);
		}
		
		if (hasFacultyAsChild) {
			
		}
		
		if (hasCourseAsChild) {
			
		}
		
		if (hasCourseInstanceAsChild) {
			
		}
		
		if (hasStudentAsChild) {
		
		}
		
		if (hasAddressAsChild) {
			address = pool.extractAddress(tableNo, primaryKey);
			// No need to recurse on address as address is a leaf node.
		}
		
		return;
	}
	
	public void setPrimaryKey(long pk) {
	   primaryKey = pk;	
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(collegeID);
		sb.append("\t");
		sb.append(parentTableNo);
		sb.append("\t");
		sb.append(parentID);
		sb.append("\t");
		sb.append(createDateTime.toString());
		sb.append("\t");
		sb.append(lastUpdateDateTime.toString());
		sb.append("\t");
		sb.append(lastUpdateUser);
		sb.append("\t");

		return sb.toString(); 
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
