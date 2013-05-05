package com.shirley.client.linkedin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
	@JsonProperty
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Country(String code) {
		super();
		this.code = code;
	}
	
}
