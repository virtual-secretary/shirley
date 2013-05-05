package com.shirley.client.linkedin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Connections {
	@JsonProperty
	private int _total;
	
	public Connections() {}

	public Connections(int _total) {
		super();
		this._total = _total;
	}

	public int get_total() {
		return _total;
	}

	public void set_total(int _total) {
		this._total = _total;
	}	
}
