package daos;

import java.sql.Date;
import java.util.List;

import com.google.api.services.calendar.model.Event;
import com.google.common.base.Optional;

public interface EventsDao extends DAO<Date,Event>{
	public Optional<List<Event>> getEventsForDay(Date date);
	public Optional <Event> updateEvent(Event event);
	

}
