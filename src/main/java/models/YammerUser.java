package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YammerUser {
	@JsonProperty
	private String timezone;
	@JsonProperty
	private String interest;
	@JsonProperty
	private String user;
	@JsonProperty
	private String mugshot_url;
	@JsonProperty
	private String kids_names;
	@JsonProperty
	private YammerSettings settings;
	@JsonProperty
	private List<String> schools;
	@JsonProperty
	private boolean verified_admin;
	@JsonProperty
	private String birth_date;
	@JsonProperty
	private String expertise;
	@JsonProperty
	private String job_title;
	@JsonProperty
	private String state;
	@JsonProperty
	private YammerContact contact;
	@JsonProperty
	private String location;
	@JsonProperty
	private List<String> previous_companies;
	@JsonProperty
	private String hire_date;
	@JsonProperty
	private String admin;
	@JsonProperty
	private String full_name;
	@JsonProperty
	private String network_id;
	@JsonProperty
	private YammerStats stats;
	@JsonProperty
	private boolean can_broadcast;
	@JsonProperty
	private String summary;
	@JsonProperty
	private List<String> external_urls;
	@JsonProperty
	private String name;
	@JsonProperty
	private List<String> network_domains;
	@JsonProperty
	private String network_name;
	@JsonProperty
	private String significant_other;
	@JsonProperty
	private String id;
	@JsonProperty
	private String web_url;
	@JsonProperty
	private String url;
	public YammerUser(){}
	@Override

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YammerUser other = (YammerUser) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (birth_date == null) {
			if (other.birth_date != null)
				return false;
		} else if (!birth_date.equals(other.birth_date))
			return false;
		if (can_broadcast != other.can_broadcast)
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (expertise == null) {
			if (other.expertise != null)
				return false;
		} else if (!expertise.equals(other.expertise))
			return false;
		if (external_urls == null) {
			if (other.external_urls != null)
				return false;
		} else if (!external_urls.equals(other.external_urls))
			return false;
		if (full_name == null) {
			if (other.full_name != null)
				return false;
		} else if (!full_name.equals(other.full_name))
			return false;
		if (guid == null) {
			if (other.guid != null)
				return false;
		} else if (!guid.equals(other.guid))
			return false;
		if (hire_date == null) {
			if (other.hire_date != null)
				return false;
		} else if (!hire_date.equals(other.hire_date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (interest == null) {
			if (other.interest != null)
				return false;
		} else if (!interest.equals(other.interest))
			return false;
		if (job_title == null) {
			if (other.job_title != null)
				return false;
		} else if (!job_title.equals(other.job_title))
			return false;
		if (kids_names == null) {
			if (other.kids_names != null)
				return false;
		} else if (!kids_names.equals(other.kids_names))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (mugshot_url == null) {
			if (other.mugshot_url != null)
				return false;
		} else if (!mugshot_url.equals(other.mugshot_url))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (network_domains == null) {
			if (other.network_domains != null)
				return false;
		} else if (!network_domains.equals(other.network_domains))
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
		if (previous_companies == null) {
			if (other.previous_companies != null)
				return false;
		} else if (!previous_companies.equals(other.previous_companies))
			return false;
		if (schools == null) {
			if (other.schools != null)
				return false;
		} else if (!schools.equals(other.schools))
			return false;
		if (settings == null) {
			if (other.settings != null)
				return false;
		} else if (!settings.equals(other.settings))
			return false;
		if (significant_other == null) {
			if (other.significant_other != null)
				return false;
		} else if (!significant_other.equals(other.significant_other))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (stats == null) {
			if (other.stats != null)
				return false;
		} else if (!stats.equals(other.stats))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (timezone == null) {
			if (other.timezone != null)
				return false;
		} else if (!timezone.equals(other.timezone))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (verified_admin != other.verified_admin)
			return false;
		if (web_url == null) {
			if (other.web_url != null)
				return false;
		} else if (!web_url.equals(other.web_url))
			return false;
		return true;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMugshot_url() {
		return mugshot_url;
	}
	public void setMugshot_url(String mugshot_url) {
		this.mugshot_url = mugshot_url;
	}
	public String getKids_names() {
		return kids_names;
	}
	public void setKids_names(String kids_names) {
		this.kids_names = kids_names;
	}
	public YammerSettings getSettings() {
		return settings;
	}
	public void setSettings(YammerSettings settings) {
		this.settings = settings;
	}
	public List<String> getSchools() {
		return schools;
	}
	public void setSchools(List<String> schools) {
		this.schools = schools;
	}
	public boolean isVerified_admin() {
		return verified_admin;
	}
	public void setVerified_admin(boolean verified_admin) {
		this.verified_admin = verified_admin;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public YammerContact getContact() {
		return contact;
	}
	public void setContact(YammerContact contact) {
		this.contact = contact;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<String> getPrevious_companies() {
		return previous_companies;
	}
	public void setPrevious_companies(List<String> previous_companies) {
		this.previous_companies = previous_companies;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getNetwork_id() {
		return network_id;
	}
	public void setNetwork_id(String network_id) {
		this.network_id = network_id;
	}
	public YammerStats getStats() {
		return stats;
	}
	public void setStats(YammerStats stats) {
		this.stats = stats;
	}
	public boolean isCan_broadcast() {
		return can_broadcast;
	}
	public void setCan_broadcast(boolean can_broadcast) {
		this.can_broadcast = can_broadcast;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public List<String> getExternal_urls() {
		return external_urls;
	}
	public void setExternal_urls(List<String> external_urls) {
		this.external_urls = external_urls;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getNetwork_domains() {
		return network_domains;
	}
	public void setNetwork_domains(List<String> network_domains) {
		this.network_domains = network_domains;
	}
	public String getNetwork_name() {
		return network_name;
	}
	public void setNetwork_name(String network_name) {
		this.network_name = network_name;
	}
	public String getSignificant_other() {
		return significant_other;
	}
	public void setSignificant_other(String significant_other) {
		this.significant_other = significant_other;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWeb_url() {
		return web_url;
	}
	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public YammerUser(String timezone, String interest, String user,
			String mugshot_url, String kids_names, YammerSettings settings,
			List<String> schools, boolean verified_admin, String birth_date,
			String expertise, String job_title, String state,
			YammerContact contact, String location,
			List<String> previous_companies, String hire_date, String admin,
			String full_name, String network_id, YammerStats stats,
			boolean can_broadcast, String summary, List<String> external_urls,
			String name, List<String> network_domains, String network_name,
			String significant_other, String id, String web_url, String url,
			String guid) {
		super();
		this.timezone = timezone;
		this.interest = interest;
		this.user = user;
		this.mugshot_url = mugshot_url;
		this.kids_names = kids_names;
		this.settings = settings;
		this.schools = schools;
		this.verified_admin = verified_admin;
		this.birth_date = birth_date;
		this.expertise = expertise;
		this.job_title = job_title;
		this.state = state;
		this.contact = contact;
		this.location = location;
		this.previous_companies = previous_companies;
		this.hire_date = hire_date;
		this.admin = admin;
		this.full_name = full_name;
		this.network_id = network_id;
		this.stats = stats;
		this.can_broadcast = can_broadcast;
		this.summary = summary;
		this.external_urls = external_urls;
		this.name = name;
		this.network_domains = network_domains;
		this.network_name = network_name;
		this.significant_other = significant_other;
		this.id = id;
		this.web_url = web_url;
		this.url = url;
		this.guid = guid;
	}
	@JsonProperty
	private String guid;

}
