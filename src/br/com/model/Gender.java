package br.com.model;

public enum Gender {
	MALE("male"), 
	FEMALE("female"),
	EMPTY("empty");
	
	private String description;
	
	private Gender(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
