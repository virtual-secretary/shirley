package helpers;

import org.junit.Test;

import security.BCrypt;

public class PasswordHelper
{
	@Test
	public void generateMockPassword() throws Exception
	{
		String salt = BCrypt.gensalt();
		String password = "somepass";
		String hashpw = BCrypt.hashpw(password, salt);
		System.out.println(hashpw);
	}
}
