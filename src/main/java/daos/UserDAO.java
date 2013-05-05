package daos;

import security.User;

public interface UserDAO extends DAO<String, User>
{
	boolean updateSetting(User user);
}
