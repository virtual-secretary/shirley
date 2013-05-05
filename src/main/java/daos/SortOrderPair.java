package daos;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * 
 * SortOrderPair is tuple of name of field to be sorted and its sorting direction
 *
 * Copyright adConnect Inc. All rights reserved.
 * 
 * @version v0.0.0
 * @since Oct 9, 2012
 * @author rex
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class SortOrderPair
{
	@NotNull
	@JsonIgnore
	private volatile int hashcode = -1;
	
	@NotNull
	@JsonIgnore
	private transient volatile int hashCodeValue = 0;
	 
	@JsonProperty
	private final String field;
	
	@JsonProperty
	private final SortOrder order;

	@JsonCreator
	public SortOrderPair(
			@JsonProperty("field") String field, 
			@JsonProperty("order") SortOrder order)
	{
		checkNotNull(field);
		checkNotNull(order);
		this.field = field;
		this.order = order;
	}

	public String getField()
	{
		return field;
	}

	public SortOrder getOrder()
	{
		return order;
	}
	
	@Override
	public int hashCode()
	{
		int hc = hashCodeValue;
		if (hc == 0) 
		{
			hc = (field.hashCode() << 4) ^ order.hashCode();
			hashCodeValue = hc;
		}
		return hc;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if ( other == null ) return false;
		if ( this == other ) return true;
		if ( this.getClass() != other.getClass() ) return false;
		
		SortOrderPair o = (SortOrderPair) other;
		return Objects.equal(this.field, o.field)
				&& Objects.equal(this.order, o.order);
	}
}
