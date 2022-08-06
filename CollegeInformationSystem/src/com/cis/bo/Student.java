package com.cis.bo;

public class Student extends CisBo{
	
	private long studentID;
	private String name;
	
	private Address address = null;
	
	public Student() {		
		tableNo = 6;					
	}
	
	@Override
	public void recursiveTreeBuilding(Pool pool) {
		address = pool.extractAddress(tableNo, primaryKey);
		// No need to recurse on address as address is a leaf node.	
	}
	
	@Override
	public void recursivePrintTree() {
		System.out.println("Printing Student Info");
		System.out.println(this);

		address.recursivePrintTree();
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
