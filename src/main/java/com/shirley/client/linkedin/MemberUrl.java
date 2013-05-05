package com.shirley.client.linkedin;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberUrl {
	@JsonProperty
	private URI url;
	
	@JsonProperty
	private String name;
	
	public MemberUrl() {}

	public MemberUrl(URI url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	public URI getUrl() {
		return url;
	}

	public void setUrl(URI url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
