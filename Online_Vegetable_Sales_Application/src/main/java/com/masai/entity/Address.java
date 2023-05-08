package com.masai.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String flatNo;
	private String buildingName;
	private String area; 
	private String city;
	private String state;
	private String pincode;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String flatNo, String buildingName, String area, String city, String state, String pincode) {
		super();
		this.flatNo = flatNo;
		this.buildingName = buildingName;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
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

	@Override
	public String toString() {
		return "flatNo=" + flatNo + ", buildingName=" + buildingName + ", area=" + area + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode;
	}
	
	
}
