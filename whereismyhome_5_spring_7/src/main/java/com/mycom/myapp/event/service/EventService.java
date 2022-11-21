package com.mycom.myapp.event.service;

import com.mycom.myapp.event.dto.EventParamDto;
import com.mycom.myapp.event.dto.EventParticipateDto;
import com.mycom.myapp.event.dto.EventResultDto;

public interface EventService {
	EventResultDto eventList(EventParamDto eventParamDto);

	EventResultDto eventListSearchWord(EventParamDto eventParamDto);

	int eventListTotalCnt();

	int eventListSearchWordTotalCnt(String searchWord);

	EventResultDto eventDetail(EventParamDto eventParamDto);
	
	EventResultDto eventParticipate(EventParticipateDto eventParticipateDto);
	Integer eventParticipateState(EventParticipateDto eventParticipateDto);
}
