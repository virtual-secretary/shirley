package models;

import java.net.URI;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleEventGadget
{
	@JsonProperty private String type;
	@JsonProperty private String title;
	@JsonProperty private URI link;
	@JsonProperty private URI iconLink;
	@JsonProperty private int width = 0;
	@JsonProperty private int height = 0;
	@JsonProperty private String display;
	@JsonProperty private Map<String, String> preferences;
	
	public GoogleEventGadget()
	{
		super();
	}

	public GoogleEventGadget(String type, String title, URI link, URI iconLink,
			int width, int height, String display,
			Map<String, String> preferences)
	{
		super();
		this.type = type;
		this.title = title;
		this.link = link;
		this.iconLink = iconLink;
		this.width = width;
		this.height = height;
		this.display = display;
		this.preferences = preferences;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((display == null) ? 0 : display.hashCode());
		result = prime * result + height;
		result = prime * result
				+ ((iconLink == null) ? 0 : iconLink.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result
				+ ((preferences == null) ? 0 : preferences.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + width;
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
		GoogleEventGadget other = (GoogleEventGadget) obj;
		if (display == null)
		{
			if (other.display != null)
				return false;
		} else if (!display.equals(other.display))
			return false;
		if (height != other.height)
			return false;
		if (iconLink == null)
		{
			if (other.iconLink != null)
				return false;
		} else if (!iconLink.equals(other.iconLink))
			return false;
		if (link == null)
		{
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (preferences == null)
		{
			if (other.preferences != null)
				return false;
		} else if (!preferences.equals(other.preferences))
			return false;
		if (title == null)
		{
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null)
		{
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	
}
