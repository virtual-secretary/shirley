package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YammerEmail {
	@JsonProperty
	private String type;
	@JsonProperty
	private String address;
	public YammerEmail(String type, String address) {
		super();
		this.type = type;
		this.address = address;
	}
	public YammerEmail(){}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YammerEmail other = (YammerEmail) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
