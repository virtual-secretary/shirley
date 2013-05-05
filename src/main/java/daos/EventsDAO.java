package daos;

import java.util.Date;
import java.util.List;

import com.google.api.services.calendar.model.Event;
import com.google.common.base.Optional;

public interface EventsDAO extends DAO<Date,Event>{
	public Optional<List<Event>> getEventsForDay(Date date);
	public Optional<List<Event>> getEventsForDateRange(Date from, Date to);

	

}
