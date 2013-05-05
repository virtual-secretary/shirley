package com.shirley.client.linkedin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HttpHeader {
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String value;
	
	public HttpHeader() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public HttpHeader(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
}
