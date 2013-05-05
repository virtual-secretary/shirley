package clients;

import java.net.URI;

import models.EventsOptionsModel;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.Calendar.CalendarList.List;
import com.google.api.services.calendar.model.*;

public interface GoogleClient {

CalendarList listCalendars();

Events listCalEvents(String calID);
Event updateCalEvent(String calID,Event event);
Event getCalEvent(String calID,String eventID);



}
