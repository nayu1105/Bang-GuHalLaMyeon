package com.mycom.myapp.admin.event.service;

import com.mycom.myapp.admin.event.dto.EventDto;
import com.mycom.myapp.admin.event.dto.EventParamDto;
import com.mycom.myapp.admin.event.dto.EventParticipateDto;
import com.mycom.myapp.admin.event.dto.EventResultDto;

public interface AdminEventService {
	EventResultDto eventInsert(EventDto dto);
	EventResultDto eventUpdate(EventDto dto);
	EventResultDto eventDelete(int eventId);
	
	EventResultDto eventList(EventParamDto eventParamDto);
	EventResultDto eventListSearchWord(EventParamDto eventParamDto);

	int eventListTotalCnt();
	int eventListSearchWordTotalCnt(String searchWord);
	
	EventResultDto eventDetail(EventParamDto eventParamDto);
	
	EventResultDto eventParticipateList(int eventId);
	EventResultDto participantDelete(EventParticipateDto eventParticipateDto);
}
