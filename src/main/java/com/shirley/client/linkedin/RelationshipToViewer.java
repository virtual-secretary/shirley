package com.shirley.client.linkedin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RelationshipToViewer {
	@JsonProperty
	private int distance;
	
	public RelationshipToViewer(){}

	public RelationshipToViewer(int distance) {
		super();
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
