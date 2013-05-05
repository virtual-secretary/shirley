package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YammerIM {
	@JsonProperty
	private String provider;
	@JsonProperty
	private String username;
	public YammerIM(){}
	public YammerIM(String provider, String username) {
		super();
		this.provider = provider;
		this.username = username;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YammerIM other = (YammerIM) obj;
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
