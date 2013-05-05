package com.shirley.client.linkedin;

import java.lang.reflect.Field;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
public class LinkedInClientResponse {
	
	@JsonProperty
	private int resultCount;
	
	@JsonProperty
	private List<UserInfo> results;

	public LinkedInClientRespone(){}
	
	public LinkedInClientRespone(int resultCount, List<UserInfo> results) {
		super();
		this.resultCount = resultCount;
		this.results = results;
	}

	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	public List<UserInfo> getResults() {
		return results;
	}

	public void setResults(List<UserInfo> results) {
		this.results = results;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if ( other == null ) return false;
		if ( this == other ) return true;
		if ( this.getClass() != other.getClass() ) return false;
		
		Field[] fields = LinkedInClientResponse.class.getDeclaredFields();
		
		try
		{
			for ( Field f : fields )
			{
				if ( !Objects.equal(f.get(this), f.get(other) ) )
				{
					return false;
				}
			}
		}
		catch (IllegalArgumentException e)
		{
			return false;
		}
		catch (IllegalAccessException e)
		{
			return false;
		}
		return true;
	}
}
