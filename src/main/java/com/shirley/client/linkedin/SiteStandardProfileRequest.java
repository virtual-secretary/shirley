package com.shirley.client.linkedin;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonProperty;


public class SiteStandardProfileRequest {
	@JsonProperty
	private URI url;
	
	public SiteStandardProfileRequest() {}

	public URI getUrl() {
		return url;
	}

	public void setUrl(URI url) {
		this.url = url;
	}

	public SiteStandardProfileRequest(URI url) {
		super();
		this.url = url;
	}
}
