package security;

import java.util.Date;

import org.mongojack.Id;
import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(isGetterVisibility = Visibility.NONE)
public class LoginToken
{
	@Id
	@JsonProperty
	private final String id;

	@ObjectId
	@JsonProperty
	private final String issuedFor;

	@ObjectId
	@JsonProperty
	private final String issuedBy;

	@JsonProperty
	private final Date issuedAt;

	// default expire Time is 10 mins, if remember me option is toggled, expire
	// Time is 3 month
	// Everytime user requests with loginToken, expireTime extends.
	@JsonProperty
	private Date expireAt;

	@JsonProperty
	private final boolean remember;

	@JsonProperty
	private Date revokedAt;

	@JsonCreator
	public LoginToken(@Id @ObjectId String id,
			@JsonProperty("issuedFor") String issuedFor,
			@JsonProperty("issuedBy") String issuedBy,
			@JsonProperty("issuedAt") Date issuedAt,
			@JsonProperty("expireAt") Date expireAt,
			@JsonProperty("remember") boolean remember,
			@JsonProperty("revokedAt") Date revokedAt)
	{
		this.id = id;
		this.issuedFor = issuedFor;
		this.issuedBy = issuedBy;
		this.issuedAt = issuedAt;
		this.expireAt = expireAt;
		this.remember = remember;
		this.revokedAt = revokedAt;
	}

	public Date getExpireAt()
	{
		return expireAt;
	}

	public void setExpireAt(Date expireAt)
	{
		this.expireAt = expireAt;
	}

	public Date getRevokedAt()
	{
		return revokedAt;
	}

	public void setRevokedAt(Date revokedAt)
	{
		this.revokedAt = revokedAt;
	}

	public String getId()
	{
		return id;
	}

	public String getIssuedFor()
	{
		return issuedFor;
	}

	public String getIssuedBy()
	{
		return issuedBy;
	}

	public Date getIssuedAt()
	{
		return issuedAt;
	}

	public boolean isRemember()
	{
		return remember;
	}

	public boolean isRevoked()
	{
		return this.revokedAt != null;
	}

	public boolean isExpired()
	{
		final long cur = System.currentTimeMillis();
		final Date curDate = new Date(cur);
		return curDate.after(expireAt);
	}
}
