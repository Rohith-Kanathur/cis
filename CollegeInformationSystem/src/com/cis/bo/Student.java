package com.cis.bo;

public class Student extends CisBo{
	
	private long studentID;
	private String name;
	
	public Student() {		
		tableNo = 6;
		
		hasDepartmentAsChild = false;
		hasFacultyAsChild = false;
		hasCourseAsChild = false;
		hasCourseInstanceAsChild = false;
		hasStudentAsChild = false;
		hasAddressAsChild = true;				
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(studentID);
		sb.append("\t");	
		sb.append(name);
		sb.append("\t");
		
		sb.append(super.toString());
		sb.append(System.getProperty("line.separator"));

		return sb.toString(); 
	}
	
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
