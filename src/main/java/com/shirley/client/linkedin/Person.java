package com.shirley.client.linkedin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Person {
	
	@JsonProperty
	private String firstName;
	
	@JsonProperty
	private String lastName;
	
	@JsonProperty
	private int _key;
	
	@JsonProperty
	private Location location;
	
	@JsonProperty
	private String headline;
	
	@JsonProperty
	private String industry;
	
	@JsonProperty
	private int distance;
	
	@JsonProperty
	private RelationshipToViewer relationshipToView;
	
	@JsonProperty
	private int numRecommeders;
	
	@JsonProperty
	private String currentStatus;
	
	@JsonProperty
	private String currentStatusTimestamp;
	
	@JsonProperty 
	private Connections connections;
	
	@JsonProperty
	private String summary;
	
	@JsonProperty
	private List<Position> positions;
	
	@JsonProperty
	private List<Education> educations;
	
	@JsonProperty
	private String memberUrlResources;
	
	@JsonProperty
	private MemberUrl memberUrl;
	
	@JsonProperty
	private ApiStandardProfileRequest apiStandardProfileRequest;
	
	@JsonProperty
	private SiteStandardProfileRequest siteStandardProfileRequest;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int get_key() {
		return _key;
	}

	public void set_key(int _key) {
		this._key = _key;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public RelationshipToViewer getRelationshipToView() {
		return relationshipToView;
	}

	public void setRelationshipToView(RelationshipToViewer relationshipToView) {
		this.relationshipToView = relationshipToView;
	}

	public int getNumRecommeders() {
		return numRecommeders;
	}

	public void setNumRecommeders(int numRecommeders) {
		this.numRecommeders = numRecommeders;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getCurrentStatusTimestamp() {
		return currentStatusTimestamp;
	}

	public void setCurrentStatusTimestamp(String currentStatusTimestamp) {
		this.currentStatusTimestamp = currentStatusTimestamp;
	}

	public Connections getConnections() {
		return connections;
	}

	public void setConnections(Connections connections) {
		this.connections = connections;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public String getMemberUrlResources() {
		return memberUrlResources;
	}

	public void setMemberUrlResources(String memberUrlResources) {
		this.memberUrlResources = memberUrlResources;
	}

	public MemberUrl getMemberUrl() {
		return memberUrl;
	}

	public void setMemberUrl(MemberUrl memberUrl) {
		this.memberUrl = memberUrl;
	}

	public ApiStandardProfileRequest getApiStandardProfileRequest() {
		return apiStandardProfileRequest;
	}

	public void setApiStandardProfileRequest(
			ApiStandardProfileRequest apiStandardProfileRequest) {
		this.apiStandardProfileRequest = apiStandardProfileRequest;
	}

	public SiteStandardProfileRequest getSiteStandardProfileRequest() {
		return siteStandardProfileRequest;
	}

	public void setSiteStandardProfileRequest(
			SiteStandardProfileRequest siteStandardProfileRequest) {
		this.siteStandardProfileRequest = siteStandardProfileRequest;
	}

	public Person(String firstName, String lastName, int _key,
			Location location, String headline, String industry, int distance,
			RelationshipToViewer relationshipToView, int numRecommeders,
			String currentStatus, String currentStatusTimestamp,
			Connections connections, String summary, List<Position> positions,
			List<Education> educations, String memberUrlResources,
			MemberUrl memberUrl,
			ApiStandardProfileRequest apiStandardProfileRequest,
			SiteStandardProfileRequest siteStandardProfileRequest) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this._key = _key;
		this.location = location;
		this.headline = headline;
		this.industry = industry;
		this.distance = distance;
		this.relationshipToView = relationshipToView;
		this.numRecommeders = numRecommeders;
		this.currentStatus = currentStatus;
		this.currentStatusTimestamp = currentStatusTimestamp;
		this.connections = connections;
		this.summary = summary;
		this.positions = positions;
		this.educations = educations;
		this.memberUrlResources = memberUrlResources;
		this.memberUrl = memberUrl;
		this.apiStandardProfileRequest = apiStandardProfileRequest;
		this.siteStandardProfileRequest = siteStandardProfileRequest;
	}

	public Person() {}
}
