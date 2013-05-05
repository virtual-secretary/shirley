package clients;

import models.YammerUser;

public interface YammerClient {
		YammerUser getProfile(String yammerAccountName);

}
