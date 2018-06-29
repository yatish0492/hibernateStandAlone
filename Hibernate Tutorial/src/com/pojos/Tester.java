package com.pojos;

public class Tester extends SoftwareEmployees{

	String testingTechnology;
	
	public Tester() {}
	
	public Tester(int id, String name, String testingTechnology) {
		super(id,name);
		this.testingTechnology = testingTechnology;
	}

	public String getTestingTechnology() {
		return testingTechnology;
	}

	public void setTestingTechnology(String testingTechnology) {
		this.testingTechnology = testingTechnology;
	}
	
	
}
