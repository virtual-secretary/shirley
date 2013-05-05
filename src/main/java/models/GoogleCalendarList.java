package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleCalendarList
{
	private String kind;
	private String etag;
	private String nextPageToken;
	private List<GoogleCalendarEntity> items;
	
	public GoogleCalendarList(){}
	
	public GoogleCalendarList(String kind, String etag, String nextPageToken,
			List<GoogleCalendarEntity> items)
	{
		super();
		this.kind = kind;
		this.etag = etag;
		this.nextPageToken = nextPageToken;
		this.items = items;
	}

	public String getKind()
	{
		return kind;
	}

	public void setKind(String kind)
	{
		this.kind = kind;
	}

	public String getEtag()
	{
		return etag;
	}

	public void setEtag(String etag)
	{
		this.etag = etag;
	}

	public String getNextPageToken()
	{
		return nextPageToken;
	}

	public void setNextPageToken(String nextPageToken)
	{
		this.nextPageToken = nextPageToken;
	}

	public List<GoogleCalendarEntity> getItems()
	{
		return items;
	}

	public void setItems(List<GoogleCalendarEntity> items)
	{
		this.items = items;
	}
	
	
	
	
}
