package com.shirley.client.linkedin;

import java.util.List;

public interface LinkedinClient {
	List<Person> extractPerson(String url);
}