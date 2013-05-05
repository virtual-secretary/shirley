package com.shirley.client.linkedin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Position {
	@JsonProperty
	private int id;
	
	@JsonProperty
	private String title;
	
	@JsonProperty
	private String summary;
	
	@JsonProperty
	private StartDate startDate;
	
	@JsonProperty
	private String isCurrent;
	
	@JsonProperty
	private Company company;
	
	public Position() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public StartDate getStartDate() {
		return startDate;
	}

	public void setStartDate(StartDate startDate) {
		this.startDate = startDate;
	}

	public String getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(String isCurrent) {
		this.isCurrent = isCurrent;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Position(int id, String title, String summary, StartDate startDate,
			String isCurrent, Company company) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.startDate = startDate;
		this.isCurrent = isCurrent;
		this.company = company;
	}
}
