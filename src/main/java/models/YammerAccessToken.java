package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YammerAccessToken {
	@JsonProperty
	private boolean view_subscriptions;
	@JsonProperty
	private String expires_at;
	@JsonProperty
	private String authorized_at;
	@JsonProperty
	private boolean modify_subscriptions;
	@JsonProperty
	private boolean modify_messages;
	@JsonProperty
	private String network_permalink;
	@JsonProperty
	private boolean view_members;
	@JsonProperty
	private boolean view_tags;
	public YammerAccessToken(){}
	public boolean isView_subscriptions() {
		return view_subscriptions;
	}
	public void setView_subscriptions(boolean view_subscriptions) {
		this.view_subscriptions = view_subscriptions;
	}
	public String getExpires_at() {
		return expires_at;
	}
	public void setExpires_at(String expires_at) {
		this.expires_at = expires_at;
	}
	public String getAuthorized_at() {
		return authorized_at;
	}
	public void setAuthorized_at(String authorized_at) {
		this.authorized_at = authorized_at;
	}
	public boolean isModify_subscriptions() {
		return modify_subscriptions;
	}
	public void setModify_subscriptions(boolean modify_subscriptions) {
		this.modify_subscriptions = modify_subscriptions;
	}
	public boolean isModify_messages() {
		return modify_messages;
	}
	public void setModify_messages(boolean modify_messages) {
		this.modify_messages = modify_messages;
	}
	public String getNetwork_permalink() {
		return network_permalink;
	}
	public void setNetwork_permalink(String network_permalink) {
		this.network_permalink = network_permalink;
	}
	public boolean isView_members() {
		return view_members;
	}
	public void setView_members(boolean view_members) {
		this.view_members = view_members;
	}
	public boolean isView_tags() {
		return view_tags;
	}
	public void setView_tags(boolean view_tags) {
		this.view_tags = view_tags;
	}
	public String getNetwork_id() {
		return network_id;
	}
	public void setNetwork_id(String network_id) {
		this.network_id = network_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public boolean isView_groups() {
		return view_groups;
	}
	public void setView_groups(boolean view_groups) {
		this.view_groups = view_groups;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getNetwork_name() {
		return network_name;
	}
	public void setNetwork_name(String network_name) {
		this.network_name = network_name;
	}
	public boolean isView_messages() {
		return view_messages;
	}
	public void setView_messages(boolean view_messages) {
		this.view_messages = view_messages;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public YammerAccessToken(boolean view_subscriptions, String expires_at,
			String authorized_at, boolean modify_subscriptions,
			boolean modify_messages, String network_permalink,
			boolean view_members, boolean view_tags, String network_id,
			String user_id, boolean view_groups, String token,
			String network_name, boolean view_messages, String created_at) {
		super();
		this.view_subscriptions = view_subscriptions;
		this.expires_at = expires_at;
		this.authorized_at = authorized_at;
		this.modify_subscriptions = modify_subscriptions;
		this.modify_messages = modify_messages;
		this.network_permalink = network_permalink;
		this.view_members = view_members;
		this.view_tags = view_tags;
		this.network_id = network_id;
		this.user_id = user_id;
		this.view_groups = view_groups;
		this.token = token;
		this.network_name = network_name;
		this.view_messages = view_messages;
		this.created_at = created_at;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YammerAccessToken other = (YammerAccessToken) obj;
		if (authorized_at == null) {
			if (other.authorized_at != null)
				return false;
		} else if (!authorized_at.equals(other.authorized_at))
			return false;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (expires_at == null) {
			if (other.expires_at != null)
				return false;
		} else if (!expires_at.equals(other.expires_at))
			return false;
		if (modify_messages != other.modify_messages)
			return false;
		if (modify_subscriptions != other.modify_subscriptions)
			return false;
		if (network_id == null) {
			if (other.network_id != null)
				return false;
		} else if (!network_id.equals(other.network_id))
			return false;
		if (network_name == null) {
			if (other.network_name != null)
				return false;
		} else if (!network_name.equals(other.network_name))
			return false;
		if (network_permalink == null) {
			if (other.network_permalink != null)
				return false;
		} else if (!network_permalink.equals(other.network_permalink))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (view_groups != other.view_groups)
			return false;
		if (view_members != other.view_members)
			return false;
		if (view_messages != other.view_messages)
			return false;
		if (view_subscriptions != other.view_subscriptions)
			return false;
		if (view_tags != other.view_tags)
			return false;
		return true;
	}
	@JsonProperty
	private String network_id;
	@JsonProperty
	private String user_id;
	@JsonProperty
	private boolean view_groups;
	@JsonProperty
	private String token;
	@JsonProperty
	private String network_name;
	@JsonProperty
	private boolean view_messages;
	@JsonProperty
	private String created_at;

}
