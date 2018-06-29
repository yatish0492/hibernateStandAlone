package com.pojos;

public class BlackDog extends Dogs{

	private String weight;
	
	public BlackDog(){}
	
	public BlackDog(int id, String name, String weight) {
		super(id,name);
		this.weight = weight;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	

}