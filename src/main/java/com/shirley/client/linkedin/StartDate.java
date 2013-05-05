package com.shirley.client.linkedin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StartDate {
	@JsonProperty
	private String year;
	
	@JsonProperty
	private String month;
	
	public StartDate(){}

	public StartDate(String year, String month) {
		super();
		this.year = year;
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
}
