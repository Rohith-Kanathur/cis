package com.cis.bo;

public class Faculty extends CisBo {
	
	private long facultyID;
	private String name;
	private short designation;
	private Address address;
	
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
