package models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleEventExtendedProperty
{
	@JsonProperty("private") private Map<String, String> propertyPrivate;
	@JsonProperty private Map<String, String> shared;
	
	public GoogleEventExtendedProperty(){}
	
	public GoogleEventExtendedProperty(Map<String, String> propertyPrivate,
			Map<String, String> shared)
	{
		super();
		this.propertyPrivate = propertyPrivate;
		this.shared = shared;
	}

	public Map<String, String> getPrivate()
	{
		return propertyPrivate;
	}

	public void setPrivate(Map<String, String> propertyPrivate)
	{
		this.propertyPrivate = propertyPrivate;
	}

	public Map<String, String> getShared()
	{
		return shared;
	}

	public void setShared(Map<String, String> shared)
	{
		this.shared = shared;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((propertyPrivate == null) ? 0 : propertyPrivate.hashCode());
		result = prime * result + ((shared == null) ? 0 : shared.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoogleEventExtendedProperty other = (GoogleEventExtendedProperty) obj;
		if (propertyPrivate == null)
		{
			if (other.propertyPrivate != null)
				return false;
		} else if (!propertyPrivate.equals(other.propertyPrivate))
			return false;
		if (shared == null)
		{
			if (other.shared != null)
				return false;
		} else if (!shared.equals(other.shared))
			return false;
		return true;
	}
	
	
}
