package com.shirley.client.linkedin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Headers {
	@JsonProperty
	private HttpHeader httpHeader;
	
	public Headers() {}

	public Headers(HttpHeader httpHeader) {
		super();
		this.httpHeader = httpHeader;
	}

	public HttpHeader getHttpHeader() {
		return httpHeader;
	}

	public void setHttpHeader(HttpHeader httpHeader) {
		this.httpHeader = httpHeader;
	}

}
