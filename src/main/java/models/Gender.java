package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonIgnoreProperties(ignoreUnknown=true)
public enum Gender
{
	ALL,
	MALE,
	FEMALE;
	
	@JsonCreator
	public static Gender forValue(final String value)
	{
		final String enumName = value.toUpperCase();
		return Gender.valueOf(enumName);
	}
	
	@JsonValue public String value() { return name(); }
}