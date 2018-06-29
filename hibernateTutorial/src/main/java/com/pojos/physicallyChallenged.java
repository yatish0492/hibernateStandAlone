package com.pojos;

public class physicallyChallenged extends Human{

	String challenge;
	
	public physicallyChallenged() {}
	
	public physicallyChallenged(int id, String name, String challenge) {
		super(id,name);
		this.challenge = challenge;
	}

	public String getChallenge() {
		return challenge;
	}

	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}
}
