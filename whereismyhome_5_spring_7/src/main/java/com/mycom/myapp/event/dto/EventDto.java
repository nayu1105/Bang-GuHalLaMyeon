package com.mycom.myapp.event.dto;

import java.time.LocalDateTime;

public class EventDto {

	private int eventKey;
	private String eventName;
	private String startDate;
	private String endDate;
	private String htmlUrl;
	private int statusCode;
	private int userSeq;
	private LocalDateTime regDt;
	private boolean adminUser;
	private String userName;
	private boolean sameUser;

	public EventDto() {

	}

	public EventDto(int eventKey, String eventName, String startDate, String endDate, String htmlUrl, int statusCode,
			int userSeq, LocalDateTime regDt, boolean adminUser, String userName, boolean sameUser) {
		super();
		this.eventKey = eventKey;
		this.eventName = eventName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.htmlUrl = htmlUrl;
		this.statusCode = statusCode;
		this.userSeq = userSeq;
		this.regDt = regDt;
		this.adminUser = adminUser;
		this.userName = userName;
		this.sameUser = sameUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getEventKey() {
		return eventKey;
	}

	public void setEventKey(int eventKey) {
		this.eventKey = eventKey;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
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

	public boolean isAdminUser() {
		return adminUser;
	}

	public void setAdminUser(boolean adminUser) {
		this.adminUser = adminUser;
	}

	public boolean isSameUser() {
		return sameUser;
	}

	public void setSameUser(boolean sameUser) {
		this.sameUser = sameUser;
	}

	@Override
	public String toString() {
		return "EventDto [eventKey=" + eventKey + ", eventName=" + eventName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", htmlUrl=" + htmlUrl + ", statusCode=" + statusCode + ", userSeq=" + userSeq + ", regDt="
				+ regDt + ", adminUser=" + adminUser + "]";
	}

}
