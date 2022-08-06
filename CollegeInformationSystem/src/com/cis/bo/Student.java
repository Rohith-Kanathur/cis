package com.cis.bo;

public class Student extends CisBo{
	
	private long studentID;
	private String name;
	private Address address;
	
	public long getStudentID() {
		return studentID;
	}
	
	public void setStudentID(long studentID) {
		this.studentID = studentID;
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

}
