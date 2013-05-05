package daos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 
 * Java Enum Representation of sort order
 *
 * Copyright adConnect Inc. All rights reserved.
 * 
 * @version v0.0.1
 * @since Oct 9, 2012
 * @author rex
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public enum SortOrder
{
	ASC (1),
	DESC (-1);
	
	private final int value;
	
	private SortOrder(int value)
	{
		this.value = value;
	}
	
	@JsonCreator
	public static SortOrder fromValue(final int value)
	{
		switch ( value )
		{
			case 1:
				return ASC;
			case -1:
				return DESC;
		}
		return null;
	}
	
	@JsonIgnore
	public SortOrder revert()
	{
		switch ( this )
		{
			case ASC:
				return DESC;
			case DESC:
				return ASC;
		}
		
		return null;
	}
	
	@JsonValue
	public int value()
	{
		return value;
	}
}