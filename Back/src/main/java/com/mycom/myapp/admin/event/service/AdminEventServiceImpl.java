package com.mycom.myapp.admin.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.admin.board.dto.BoardDto;
import com.mycom.myapp.admin.board.dto.BoardResultDto;
import com.mycom.myapp.admin.event.dao.AdminEventDao;
import com.mycom.myapp.admin.event.dto.EventDto;
import com.mycom.myapp.admin.event.dto.EventParamDto;
import com.mycom.myapp.admin.event.dto.EventParticipateDto;
import com.mycom.myapp.admin.event.dto.EventResultDto;

@Service
public class AdminEventServiceImpl implements AdminEventService {

	@Autowired
	AdminEventDao dao;

	private final int SUCCESS = 1;
	private final int FAIL = -1;

	@Override
	public EventResultDto eventInsert(EventDto dto) {
		EventResultDto eventResultDto = new EventResultDto();
		eventResultDto.setResult(dao.eventInsert(dto));
		return eventResultDto;
	}

	@Override
	public EventResultDto eventUpdate(EventDto dto) {
		EventResultDto eventResultDto = new EventResultDto();
		eventResultDto.setResult(dao.eventUpdate(dto));
		return eventResultDto;
	}

	@Override
	public EventResultDto eventDelete(int eventId) {
		EventResultDto eventResultDto = new EventResultDto();
		eventResultDto.setResult(dao.eventDelete(eventId));
		return eventResultDto;
	}

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
		EventResultDto boardResultDto = new EventResultDto();

		try {
			EventDto eventDto = dao.eventDetail(eventParamDto.getEventId());
			boardResultDto.setDto(eventDto);
			return boardResultDto;
		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}
	
	@Override
	public EventResultDto eventParticipateList(int eventId) {
		EventResultDto eventResultDto = new EventResultDto();
		try {
			List<EventDto> list = dao.eventParticipateList(eventId);
			eventResultDto.setList(list);
			eventResultDto.setResult(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			eventResultDto.setResult(FAIL);
		}
		return eventResultDto;
	}

	@Override
	public EventResultDto participantDelete(EventParticipateDto eventParticipateDto) {
		EventResultDto eventResultDto = new EventResultDto();
		eventResultDto.setResult(dao.participantDelete(eventParticipateDto));
		return eventResultDto;
	}

}
