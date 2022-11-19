package com.mycom.myapp.admin.event.dto;

import java.time.LocalDateTime;

public class EventDto {

	private int eventId;
	private String title;
	private String content;
	private String startDate;
	private String endDate;
	private String htmlUrl;
	private int statusCode;
	private int userSeq;
	private LocalDateTime regDt;

	public EventDto() {

	}

	public EventDto(int eventId, String title, String content, String startDate, String endDate, String htmlUrl,
			int statusCode, int userSeq, LocalDateTime regDt) {
		super();
		this.eventId = eventId;
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.htmlUrl = htmlUrl;
		this.statusCode = statusCode;
		this.userSeq = userSeq;
		this.regDt = regDt;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public LocalDateTime getRegDt() {
		return regDt;
	}

	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "EventDto [eventId=" + eventId + ", title=" + title + ", content=" + content + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", htmlUrl=" + htmlUrl + ", statusCode=" + statusCode + ", userSeq="
				+ userSeq + ", regDt=" + regDt + "]";
	}

}
