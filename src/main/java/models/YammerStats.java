package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YammerStats {
	@JsonProperty
	private String updates;
	@JsonProperty
	private String followers;
	@JsonProperty
	private String following;
	public YammerStats(){}
	public YammerStats(String updates, String followers, String following) {
		super();
		this.updates = updates;
		this.followers = followers;
		this.following = following;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YammerStats other = (YammerStats) obj;
		if (followers == null) {
			if (other.followers != null)
				return false;
		} else if (!followers.equals(other.followers))
			return false;
		if (following == null) {
			if (other.following != null)
				return false;
		} else if (!following.equals(other.following))
			return false;
		if (updates == null) {
			if (other.updates != null)
				return false;
		} else if (!updates.equals(other.updates))
			return false;
		return true;
	}
	public String getUpdates() {
		return updates;
	}
	public void setUpdates(String updates) {
		this.updates = updates;
	}
	public String getFollowers() {
		return followers;
	}
	public void setFollowers(String followers) {
		this.followers = followers;
	}
	public String getFollowing() {
		return following;
	}
	public void setFollowing(String following) {
		this.following = following;
	}

}
