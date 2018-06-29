package com.pojos;

public class Human {

	int adharNo;
	String name;
	
	public Human() {}
	
	public Human(int adharNo, String name) {
		this.adharNo = adharNo;
		this.name = name;
	}
	
	public int getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(int adharNo) {
		this.adharNo = adharNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
