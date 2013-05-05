package com.shirley.client.linkedin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiStandardProfileRequest {
	@JsonProperty
	private String url;
	
	@JsonProperty
	private Headers headers;

	public ApiStandardProfileRequest() {}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Headers getHeaders() {
		return headers;
	}

	public void setHeaders(Headers headers) {
		this.headers = headers;
	}

	public ApiStandardProfileRequest(String url, Headers headers) {
		super();
		this.url = url;
		this.headers = headers;
	}
}
