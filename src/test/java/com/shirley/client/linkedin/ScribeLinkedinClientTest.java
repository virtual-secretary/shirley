package com.shirley.client.linkedin;

import static com.yammer.dropwizard.testing.JsonHelpers.asJson;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;

public class ScribeLinkedinClientTest {

	private Client client;
	private ScribeLinkedinClient scribClient;
	
	@Before
	public void setUp() throws Exception
	{
		client = Client.create();
		scribClient = new ScribeLinkedinClient(client);
	}
	
	@Test
	public void testJSON() throws Exception
	{
		//Mock
		//Person expected = fromJson()
	
		//Execute
		List<Person> actual = scribClient.extractPerson("~");
		//verify
		
		System.out.println(asJson(actual));
		
	}
}

/*
	
	@Test
	public void testJSON() throws Exception
	{
		// Mock
		AppInfo expected = fromJson(jsonFixture("fixtures/appinfo.json"), AppInfo.class);
		
		// Execute
		AppInfo actual = jasClient.extractAppInfo("420009108");
		
		// Verify
		assertThat(actual).isEqualTo(expected);
	}
}
*/