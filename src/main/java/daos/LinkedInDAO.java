package daos;

import com.google.common.base.Optional;
import com.shirley.client.linkedin.Person;

public interface LinkedInDAO extends DAO<String,Person>{
	public Optional<Person> findwithURL(String url);

}
