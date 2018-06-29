package com.pojos;

public class WhiteDog extends Dogs{

	private String breed;
	
	public WhiteDog(){}
	
	public WhiteDog(int id, String name, String breed) {
		super(id,name);
		this.breed = breed;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	

}
