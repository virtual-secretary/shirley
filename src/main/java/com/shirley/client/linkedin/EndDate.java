package com.shirley.client.linkedin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EndDate {
	@JsonProperty 
	private String endDate;
	
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public EndDate() {}

	public EndDate(String endDate) {
		super();
		this.endDate = endDate;
	}
}
