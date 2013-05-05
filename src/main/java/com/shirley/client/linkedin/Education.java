package com.shirley.client.linkedin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Education {
	@JsonProperty
	private int id;
	
	@JsonProperty
	private String schoolName;
	
	@JsonProperty
	private String degree;
	
	@JsonProperty
	private StartDate startDate;
	
	@JsonProperty
	private EndDate endDate;

	public Education() {}
	
	public Education(int id, String schoolName, String degree,
			StartDate startDate, EndDate endDate) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.degree = degree;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public StartDate getStartDate() {
		return startDate;
	}

	public void setStartDate(StartDate startDate) {
		this.startDate = startDate;
	}

	public EndDate getEndDate() {
		return endDate;
	}

	public void setEndDate(EndDate endDate) {
		this.endDate = endDate;
	}
	
}
