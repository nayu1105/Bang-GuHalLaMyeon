package com.mycom.myapp.event.dto;

public class EventParticipateDto {

	private int eventId;
	private int userSeq;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public EventParticipateDto() {
		
	}
	
	public EventParticipateDto(int eventId, int userSeq) {
		super();
		this.eventId = eventId;
		this.userSeq = userSeq;
	}

	@Override
	public String toString() {
		return "EventParticipateDto [eventId=" + eventId + ", userSeq=" + userSeq + "]";
	}

}
