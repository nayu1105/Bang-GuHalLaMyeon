package com.mycom.myapp.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.event.dao.EventDao;
import com.mycom.myapp.event.dto.EventDto;
import com.mycom.myapp.event.dto.EventParamDto;
import com.mycom.myapp.event.dto.EventParticipateDto;
import com.mycom.myapp.event.dto.EventResultDto;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventDao dao;

	private final int SUCCESS = 1;
	private final int FAIL = -1;

	@Override
	public EventResultDto eventList(EventParamDto eventParamDto) {
		EventResultDto eventResultDto = new EventResultDto();
		try {
			// 목록, 총건수를 가져온다.
			List<EventDto> list = dao.eventList(eventParamDto);
			int count = dao.eventListTotalCnt();
			eventResultDto.setList(list);
			eventResultDto.setCount(count);
			eventResultDto.setResult(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			eventResultDto.setResult(FAIL);
		}
		return eventResultDto;
	}

	@Override
	public EventResultDto eventListSearchWord(EventParamDto eventParamDto) {
		EventResultDto eventResultDto = new EventResultDto();
		try {
			// 목록, 총건수를 가져온다.
			List<EventDto> list = dao.eventListSearchWord(eventParamDto);
			int count = dao.eventListSearchWordTotalCnt(eventParamDto.getSearchWord());
			eventResultDto.setList(list);
			eventResultDto.setCount(count);
			eventResultDto.setResult(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			eventResultDto.setResult(FAIL);
		}
		return eventResultDto;
	}

	@Override
	public int eventListTotalCnt() {
		return dao.eventListTotalCnt();
	}

	@Override
	public int eventListSearchWordTotalCnt(String searchWord) {
		return dao.eventListSearchWordTotalCnt(searchWord);
	}

	@Override
	public EventResultDto eventDetail(EventParamDto eventParamDto) {
		EventResultDto eventResultDto = new EventResultDto();

		try {
			EventDto eventDto = dao.eventDetail(eventParamDto.getEventId());
			eventResultDto.setDto(eventDto);
			eventResultDto.setResult(SUCCESS);
			return eventResultDto;
		} catch (Exception e) {
			e.printStackTrace();
			eventResultDto.setResult(FAIL);
		}
		return eventResultDto;
	}

	@Override
	public EventResultDto eventParticipate(EventParticipateDto eventParticipateDto) {
		EventResultDto eventResultDto = new EventResultDto();
		eventResultDto.setResult(dao.eventParticipate(eventParticipateDto));
		return eventResultDto;
	}

	@Override
	public Integer eventParticipateState(EventParticipateDto eventParticipateDto) {
		return dao.eventParticipateState(eventParticipateDto);
	}

}
