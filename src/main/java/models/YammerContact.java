package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YammerContact {
	@JsonProperty
	private List<String> phone_numbers;
	@JsonProperty
	private YammerIM im;
	@JsonProperty
	private List<YammerEmail> email_addresses;
	public YammerContact(){};
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YammerContact other = (YammerContact) obj;
		if (email_addresses == null) {
			if (other.email_addresses != null)
				return false;
		} else if (!email_addresses.equals(other.email_addresses))
			return false;
		if (im == null) {
			if (other.im != null)
				return false;
		} else if (!im.equals(other.im))
			return false;
		if (phone_numbers == null) {
			if (other.phone_numbers != null)
				return false;
		} else if (!phone_numbers.equals(other.phone_numbers))
			return false;
		return true;
	}
	public YammerContact(List<String> phone_numbers, YammerIM im,
			List<YammerEmail> email_addresses) {
		super();
		this.phone_numbers = phone_numbers;
		this.im = im;
		this.email_addresses = email_addresses;
	}
	public List<String> getPhone_numbers() {
		return phone_numbers;
	}
	public void setPhone_numbers(List<String> phone_numbers) {
		this.phone_numbers = phone_numbers;
	}
	public YammerIM getIm() {
		return im;
	}
	public void setIm(YammerIM im) {
		this.im = im;
	}
	public List<YammerEmail> getEmail_addresses() {
		return email_addresses;
	}
	public void setEmail_addresses(List<YammerEmail> email_addresses) {
		this.email_addresses = email_addresses;
	}

}
