package com.mycom.myapp.event.dto;

import java.util.List;

public class EventResultDto {
	private int result;
	private EventDto dto;
	private List<EventDto> list;
	private int count;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public EventDto getDto() {
		return dto;
	}

	public void setDto(EventDto dto) {
		this.dto = dto;
	}

	public List<EventDto> getList() {
		return list;
	}

	public void setList(List<EventDto> list) {
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
