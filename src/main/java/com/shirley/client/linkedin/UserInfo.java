package com.shirley.client.linkedin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserInfo {
	
	@JsonProperty
	private String firstName;
	
	@JsonProperty
	private String lastName;
	
	@JsonProperty
	private int connections;
	
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
	private int _total;
	
	@JsonProperty
	private String summary;
	
	@JsonProperty
	private 
	
	
	
	
	
	
	
	public UserInfo() {}
}
