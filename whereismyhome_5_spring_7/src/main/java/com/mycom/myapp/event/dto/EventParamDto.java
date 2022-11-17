package com.mycom.myapp.event.dto;

public class EventParamDto {
	// Spring 에서 자동으로 파라미터 처리를 해주는 기능을 활용하기 위해
	// request.getParameter("limit")와 같은 코드를 생략하도록 별도의 dto를 만든다.

	// 게시글 목록
	private int limit;
	private int offset;
	private String searchWord;

	// 게시글 상세
	private int eventId;
	private int userSeq;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

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

	@Override
	public String toString() {
		return "EventParamDto [limit=" + limit + ", offset=" + offset + ", searchWord=" + searchWord + ", eventId="
				+ eventId + ", userSeq=" + userSeq + "]";
	}

}
