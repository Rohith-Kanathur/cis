package com.cis.bo;

public class Faculty extends CisBo {
	
	private long facultyID;
	private String name;
	private short designation;
	
	public Faculty() {
		tableNo = 3;
		
		hasDepartmentAsChild = false;
		hasFacultyAsChild = false;
		hasCourseAsChild = false;
		hasCourseInstanceAsChild = false;
		hasStudentAsChild = false;
		hasAddressAsChild = true;		
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
