package com.mycom.myapp.event.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.event.dto.EventDto;
import com.mycom.myapp.event.dto.EventParamDto;
import com.mycom.myapp.event.dto.EventParticipateDto;

@Mapper
public interface EventDao {
	List<EventDto> eventList(EventParamDto eventParamDto);
	List<EventDto> eventListSearchWord(EventParamDto eventParamDto);
	
	int eventListTotalCnt();
	int eventListSearchWordTotalCnt(String searchWord);
	
	EventDto eventDetail(int eventId);
	
	// 이벤트 참가 관련
	int eventParticipate(EventParticipateDto eventParticipateDto);
	Integer eventParticipateState(EventParticipateDto eventParticipateDto);
}