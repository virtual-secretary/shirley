package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YammerNetwork {
	@JsonProperty
	private String type;
	@JsonProperty
	private String header_background_color;
	@JsonProperty
	private boolean community;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YammerNetwork other = (YammerNetwork) obj;
		if (community != other.community)
			return false;
		if (header_background_color == null) {
			if (other.header_background_color != null)
				return false;
		} else if (!header_background_color
				.equals(other.header_background_color))
			return false;
		if (header_text_color == null) {
			if (other.header_text_color != null)
				return false;
		} else if (!header_text_color.equals(other.header_text_color))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (is_org_chart_enabled != other.is_org_chart_enabled)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (navigation_background_color == null) {
			if (other.navigation_background_color != null)
				return false;
		} else if (!navigation_background_color
				.equals(other.navigation_background_color))
			return false;
		if (navigation_text_color == null) {
			if (other.navigation_text_color != null)
				return false;
		} else if (!navigation_text_color.equals(other.navigation_text_color))
			return false;
		if (paid != other.paid)
			return false;
		if (permalink == null) {
			if (other.permalink != null)
				return false;
		} else if (!permalink.equals(other.permalink))
			return false;
		if (show_upgrade_banner != other.show_upgrade_banner)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (web_url == null) {
			if (other.web_url != null)
				return false;
		} else if (!web_url.equals(other.web_url))
			return false;
		return true;
	}
	public YammerNetwork(){}
	public YammerNetwork(String type, String header_background_color,
			boolean community, String navigation_background_color,
			String navigation_text_color, String permalink, boolean paid,
			boolean show_upgrade_banner, String name,
			boolean is_org_chart_enabled, String id, String header_text_color,
			String web_url) {
		super();
		this.type = type;
		this.header_background_color = header_background_color;
		this.community = community;
		this.navigation_background_color = navigation_background_color;
		this.navigation_text_color = navigation_text_color;
		this.permalink = permalink;
		this.paid = paid;
		this.show_upgrade_banner = show_upgrade_banner;
		this.name = name;
		this.is_org_chart_enabled = is_org_chart_enabled;
		this.id = id;
		this.header_text_color = header_text_color;
		this.web_url = web_url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHeader_background_color() {
		return header_background_color;
	}
	public void setHeader_background_color(String header_background_color) {
		this.header_background_color = header_background_color;
	}
	public boolean isCommunity() {
		return community;
	}
	public void setCommunity(boolean community) {
		this.community = community;
	}
	public String getNavigation_background_color() {
		return navigation_background_color;
	}
	public void setNavigation_background_color(String navigation_background_color) {
		this.navigation_background_color = navigation_background_color;
	}
	public String getNavigation_text_color() {
		return navigation_text_color;
	}
	public void setNavigation_text_color(String navigation_text_color) {
		this.navigation_text_color = navigation_text_color;
	}
	public String getPermalink() {
		return permalink;
	}
	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public boolean isShow_upgrade_banner() {
		return show_upgrade_banner;
	}
	public void setShow_upgrade_banner(boolean show_upgrade_banner) {
		this.show_upgrade_banner = show_upgrade_banner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isIs_org_chart_enabled() {
		return is_org_chart_enabled;
	}
	public void setIs_org_chart_enabled(boolean is_org_chart_enabled) {
		this.is_org_chart_enabled = is_org_chart_enabled;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHeader_text_color() {
		return header_text_color;
	}
	public void setHeader_text_color(String header_text_color) {
		this.header_text_color = header_text_color;
	}
	public String getWeb_url() {
		return web_url;
	}
	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}
	@JsonProperty
	private String navigation_background_color;
	@JsonProperty
	private String navigation_text_color;
	@JsonProperty
	private String permalink;
	@JsonProperty
	private boolean paid;
	@JsonProperty
	private boolean show_upgrade_banner;
	@JsonProperty
	private String name;
	@JsonProperty
	private boolean is_org_chart_enabled;
	@JsonProperty
	private String id;
	@JsonProperty
	private String header_text_color;
	@JsonProperty
	private String web_url;

}
