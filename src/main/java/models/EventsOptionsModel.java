package models;

import java.util.Date;

import com.google.api.client.util.DateTime;

public class EventsOptionsModel {
	public enum ReminderMethod{EMAIL,SMS,DEFAULT};
	private DateTime start;
	private DateTime end;
	private ReminderMethod reminderMethod;
	private int reminderMinutes;
	public enum ResponseStatus{NEEDSACTION,DECLINED,TENTATIVE,ACCEPTED};
	private ResponseStatus responseStatus;
	
	public EventsOptionsModel(){

	}

	public EventsOptionsModel(DateTime start, DateTime end,
			ReminderMethod reminderMethod, int reminderMinutes,
			ResponseStatus responseStatus) {
		super();
		this.start = start;
		this.end = end;
		this.reminderMethod = reminderMethod;
		this.reminderMinutes = reminderMinutes;
		this.responseStatus = responseStatus;
	}
	public DateTime getStart() {
		return start;
	}
	public void setStart(DateTime start) {
		this.start = start;
	}
	public void setStart(Date start) {
		this.start = new DateTime(start);
	}
	public DateTime getEnd() {
		return end;
	}
	public void setEnd(DateTime end) {
		this.end = end;
	}
	public void setEnd(Date end) {
		this.end = new DateTime(end);
	}
	public ReminderMethod getReminderMethod() {
		return reminderMethod;
	}
	public void setReminderMethod(ReminderMethod reminderMethod) {
		this.reminderMethod = reminderMethod;
	}
	public int getReminderMinutes() {
		return reminderMinutes;
	}
	public void setReminderMinutes(int reminderMinutes) {
		this.reminderMinutes = reminderMinutes;
	}
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
}
