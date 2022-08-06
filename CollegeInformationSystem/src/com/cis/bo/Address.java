package com.cis.bo;

public class Address extends CisBo{
	
	private long addressID;
	private String streetAddress;
	private String area;
	private String city;
	private String state;
	private String pincode;
	private String country;
	
	public Address() {
		hasDepartmentAsChild = false;
		hasFacultyAsChild = false;
		hasCourseAsChild = false;
		hasCourseInstanceAsChild = false;
		hasStudentAsChild = false;
		hasAddressAsChild = false;				
	}
	
	public long getAddressID() {
		return addressID;
	}
	
	public void setAddressID(long addressID) {
		this.addressID = addressID;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getPincode() {
		return pincode;
	}
	
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
}
