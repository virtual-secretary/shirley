package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleReminder
{
	@JsonProperty
	private String method;
	
	@JsonProperty
	private int minutes;

	public GoogleReminder(){}
	
	public GoogleReminder(String method, int minutes)
	{
		super();
		this.method = method;
		this.minutes = minutes;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public int getMinutes()
	{
		return minutes;
	}

	public void setMinutes(int minutes)
	{
		this.minutes = minutes;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + minutes;
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
		GoogleReminder other = (GoogleReminder) obj;
		if (method == null)
		{
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (minutes != other.minutes)
			return false;
		return true;
	}
}
