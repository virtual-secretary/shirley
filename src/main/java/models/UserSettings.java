package models;


public class UserSettings
{
	private boolean notify;
	private boolean linkedin;
	private boolean google;
	
	public UserSettings(){}
	
	public UserSettings(boolean notify, boolean linkedin, boolean google)
	{
		super();
		this.notify = notify;
		this.linkedin = linkedin;
		this.google = google;
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (google ? 1231 : 1237);
		result = prime * result + (linkedin ? 1231 : 1237);
		result = prime * result + (notify ? 1231 : 1237);
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
		return true;
	}
	
	
	
}
