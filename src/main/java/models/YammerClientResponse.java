package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class YammerClientResponse {
	public YammerClientResponse(){};

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YammerClientResponse other = (YammerClientResponse) obj;
		if (access_token == null) {
			if (other.access_token != null)
				return false;
		} else if (!access_token.equals(other.access_token))
			return false;
		if (network == null) {
			if (other.network != null)
				return false;
		} else if (!network.equals(other.network))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public YammerClientResponse(YammerUser user,
			YammerAccessToken access_token, YammerNetwork network) {
		super();
		this.user = user;
		this.access_token = access_token;
		this.network = network;
	}
	public YammerUser getUser() {
		return user;
	}
	public void setUser(YammerUser user) {
		this.user = user;
	}
	public YammerAccessToken getAccess_token() {
		return access_token;
	}
	public void setAccess_token(YammerAccessToken access_token) {
		this.access_token = access_token;
	}
	public YammerNetwork getNetwork() {
		return network;
	}
	public void setNetwork(YammerNetwork network) {
		this.network = network;
	}
	@JsonProperty
	private YammerUser user;
	@JsonProperty
	private YammerAccessToken access_token;
	@JsonProperty
	private YammerNetwork network;

}
