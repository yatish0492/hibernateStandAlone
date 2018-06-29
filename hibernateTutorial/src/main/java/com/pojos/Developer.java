package com.pojos;

public class Developer extends SoftwareEmployees {

	String DeveloperTechnology;
	
	public Developer() {}
	
	public Developer(int id, String name, String DeveloperTechnology) {
		super(id,name);
		this.DeveloperTechnology = DeveloperTechnology;
	}

	public String getDeveloperTechnology() {
		return DeveloperTechnology;
	}

	public void setDeveloperTechnology(String developerTechnology) {
		DeveloperTechnology = developerTechnology;
	}
	
}
