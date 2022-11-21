package com.mycom.myapp.admin.event.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.admin.event.dto.EventDto;
import com.mycom.myapp.admin.event.dto.EventParamDto;
import com.mycom.myapp.admin.event.dto.EventParticipateDto;

@Mapper
public interface AdminEventDao {
	int eventInsert(EventDto dto);

	int eventUpdate(EventDto dto);

	int eventDelete(int eventId);

	EventDto eventDetail(int eventId);

	List<EventDto> eventList(EventParamDto eventParamDto);

	List<EventDto> eventListSearchWord(EventParamDto eventParamDto);
	
	int eventListTotalCnt();
	
	int eventListSearchWordTotalCnt(String searchWord);
	
	List<EventDto> eventParticipateList(int eventId);
	int participantDelete(EventParticipateDto eventParticipateDto);
}
