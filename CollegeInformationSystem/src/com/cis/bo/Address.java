package com.cis.bo;

public class Address extends CisBo{
	
	private long addressID;
	private String streetAddress;
	private String area;
	private String city;
	private String state;
	private String pinCode;
	private String country;
	
	public Address() {
		tableNo = 7;			
	}
	
	@Override
	public void recursiveTreeBuilding(Pool pool) {
		return;
	}
	
	@Override
	public void recursivePrintTree() {
		System.out.println("Printing Address Info");
		System.out.println(this);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(addressID);
		sb.append("\t");	
		sb.append(streetAddress);
		sb.append("\t");
		sb.append(area);
		sb.append("\t");
		sb.append(city);
		sb.append("\t");
		sb.append(state);
		sb.append("\t");
		sb.append(pinCode);
		sb.append("\t");
		sb.append(country);
		sb.append("\t");
		
		sb.append(super.toString());
		sb.append(System.getProperty("line.separator"));

		return sb.toString(); 
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
	
	public String getPinCode() {
		return pinCode;
	}
	
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
}
