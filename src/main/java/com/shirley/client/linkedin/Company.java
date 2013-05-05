package com.shirley.client.linkedin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {
	@JsonProperty
	private String name;
	
	public Company() {}

	public Company(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
}
