package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YammerSettings {

	@JsonProperty
	private String xdr_proxy;


	public YammerSettings(String xdr_proxy) {
		super();
		this.xdr_proxy = xdr_proxy;
	}
public YammerSettings(){}

	public String getXdr_proxy() {
		return xdr_proxy;
	}


	public void setXdr_proxy(String xdr_proxy) {
		this.xdr_proxy = xdr_proxy;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YammerSettings other = (YammerSettings) obj;
		if (xdr_proxy == null) {
			if (other.xdr_proxy != null)
				return false;
		} else if (!xdr_proxy.equals(other.xdr_proxy))
			return false;
		return true;
	}

}
