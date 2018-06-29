package com.pojos;

public class NonPhysicallyChallenged extends Human{

	String Hobby;
	
	public NonPhysicallyChallenged() {}
	
	public NonPhysicallyChallenged(int id, String name, String Hobby) {
		super(id,name);
		this.Hobby = Hobby;
	}
	
	public String getHobby() {
		return Hobby;
	}

	public void setHobby(String hobby) {
		Hobby = hobby;
	}

	
	
}
