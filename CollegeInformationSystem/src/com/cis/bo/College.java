package com.cis.bo;

import java.util.ArrayList;

public class College extends CisBo {
	
	private long collegeID;
	private String name;
	private Address address;
	
	private Pool pool;
	
	public College() {
		tableNo = 1;
		
		departmentList = new ArrayList<Department>();
		
		parentTableNo = 0;
		parentID = 0;
		
		hasDepartmentAsChild = true;
		hasFacultyAsChild = false;
		hasCourseAsChild = false;
		hasCourseInstanceAsChild = false;
		hasStudentAsChild = false;
		hasAddressAsChild = true;		
		
		pool = new Pool();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(collegeID);
		sb.append("\t");	
		sb.append(name);
		sb.append("\t");	
		
		sb.append(super.toString());
		sb.append(System.getProperty("line.separator"));

		return sb.toString(); 
	}
	
	public long getCollegeID() {
		return collegeID;
	}

	public void setCollegeID(long collegeID) {
		this.collegeID = collegeID;
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

	public ArrayList<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(ArrayList<Department> departmentList) {
		this.departmentList = departmentList;
	}
	
	public boolean addDepartment(Department department) {

		for (int i = 0; i < departmentList.size(); i++) {
			if (departmentList.get(i).getName().equalsIgnoreCase(department.getName()))
				return false; // Means department already exists, so cannot add another department with the same name.
		}
		
		departmentList.add(department);
		return true;
	}
	
	public boolean removeDepartment(String name) {

		Department department = null;
		for (int i = 0; i < departmentList.size(); i++) {
			if (departmentList.get(i).getName().equalsIgnoreCase(name)) {	// Student exists and can be removed.
				department = departmentList.get(i);
				break;
			}
		}
		
		if (department != null) {
			departmentList.remove(department);
			return true;
		}
		
		return false;
	}

	public Pool getPool() {
		return pool;
	}

	public void setPool(Pool pool) {
		this.pool = pool;
	}
	
	public void buildTreeUsingPool() {
		recursiveTreeBuilding(pool);
		return;
	}
}
