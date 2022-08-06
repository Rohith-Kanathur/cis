package com.cis.bo;

import java.util.ArrayList;

public class Faculty extends CisBo {
	
	private long facultyID;
	private String name;
	private short designation;
	
	private Address address = null;
	
	public Faculty() {
		tableNo = 3;
	}
	
	@Override
	public void recursiveTreeBuilding(Pool pool) {
		address = pool.extractAddress(tableNo, primaryKey);
		// No need to recurse on address as address is a leaf node.	
	}
	
	@Override
	public void recursivePrintTree() {
		System.out.println("Printing Faculty Info");
		System.out.println(this);

		address.recursivePrintTree();		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(facultyID);
		sb.append("\t");	
		sb.append(name);
		sb.append("\t");
		sb.append(designation);
		sb.append("\t");
		
		sb.append(super.toString());
		sb.append(System.getProperty("line.separator"));

		return sb.toString(); 
	}
	
	public long getFacultyID() {
		return facultyID;
	}
	
	public void setFacultyID(long facultyID) {
		this.facultyID = facultyID;
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

	public short getDesignation() {
		return designation;
	}

	public void setDesignation(short designation) {
		this.designation = designation;
	}
	
}
