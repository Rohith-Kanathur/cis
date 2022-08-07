package com.cis.bo;

import java.util.ArrayList;

import com.cis.db.CollegeDB;

public class College extends CisBo {
	
	private long collegeID;
	private String name;
	
	private Pool pool;

	private ArrayList<Department> departmentList = null;
	private Address address = null;	
	
	public College() {
		tableNo = 1;
		
		parentTableNo = 0;
		parentID = 0;
		
		pool = new Pool();
	}

	public void buildTreeUsingPool() {
		recursiveTreeBuilding(pool);
		return;
	}

	@Override
	public void recursiveTreeBuilding(Pool pool) {
		departmentList = pool.extractDepartmentList(tableNo, primaryKey);			
		for (int i = 0; i < departmentList.size(); i++)
			departmentList.get(i).recursiveTreeBuilding(pool);
		
		address = pool.extractAddress(tableNo, primaryKey);
		// No need to recurse on address as address is a leaf node.	
	}
	
	public void printTree() {
		System.out.println();
		System.out.println("Printing the Tree after Extraction: ");
		
		recursivePrintTree();
	}
	
	@Override
	public void recursivePrintTree() {
		System.out.println();
		System.out.println("Printing College Info");
		System.out.println(this);

		for (int i = 0; i < departmentList.size(); i++)
			departmentList.get(i).recursivePrintTree();
		
		address.recursivePrintTree();		
	}
	
	public boolean loadCollegeTreeUsingBruteForce() {
		// Load from Database where children are read for each parent in a loop.
		CollegeDB collegeDB = new CollegeDB();
		
		return collegeDB.loadCollegeTreeUsingBruteForce(this);
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
	
}
