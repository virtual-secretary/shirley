package daos;

import com.google.api.services.calendar.model.Event;
import com.google.common.base.Optional;

public interface EventDAO extends DAO<String,Event>{

	public Optional <Event> getEvent(String eventID);

	public Optional <Event> updateEvent(String eventID,Event event);
}
