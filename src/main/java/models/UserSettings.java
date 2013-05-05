package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserSettings
{
	@JsonProperty private boolean notify;
	@JsonProperty private boolean linkedin;
	@JsonProperty private boolean google;
	@JsonProperty private boolean twiiter;
	@JsonProperty private boolean yammer;
	
	public UserSettings(){}

	public UserSettings(boolean notify, boolean linkedin, boolean google,
			boolean twiiter, boolean yammer)
	{
		super();
		this.notify = notify;
		this.linkedin = linkedin;
		this.google = google;
		this.twiiter = twiiter;
		this.yammer = yammer;
	}

	public boolean isNotify()
	{
		return notify;
	}

	public void setNotify(boolean notify)
	{
		this.notify = notify;
	}

	public boolean isLinkedin()
	{
		return linkedin;
	}

	public void setLinkedin(boolean linkedin)
	{
		this.linkedin = linkedin;
	}

	public boolean isGoogle()
	{
		return google;
	}

	public void setGoogle(boolean google)
	{
		this.google = google;
	}

	public boolean isTwiiter()
	{
		return twiiter;
	}

	public void setTwiiter(boolean twiiter)
	{
		this.twiiter = twiiter;
	}

	public boolean isYammer()
	{
		return yammer;
	}

	public void setYammer(boolean yammer)
	{
		this.yammer = yammer;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (google ? 1231 : 1237);
		result = prime * result + (linkedin ? 1231 : 1237);
		result = prime * result + (notify ? 1231 : 1237);
		result = prime * result + (twiiter ? 1231 : 1237);
		result = prime * result + (yammer ? 1231 : 1237);
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
		UserSettings other = (UserSettings) obj;
		if (google != other.google)
			return false;
		if (linkedin != other.linkedin)
			return false;
		if (notify != other.notify)
			return false;
		if (twiiter != other.twiiter)
			return false;
		if (yammer != other.yammer)
			return false;
		return true;
	}
	
}
