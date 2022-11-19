package com.mycom.myapp.event.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myapp.admin.event.dto.EventDto;
import com.mycom.myapp.event.dto.EventParamDto;
import com.mycom.myapp.event.dto.EventParticipateDto;
import com.mycom.myapp.event.dto.EventResultDto;
import com.mycom.myapp.event.service.EventService;
import com.mycom.myapp.user.dto.UserDto;

@RestController
@CrossOrigin(
		// localhost:5500 과 127.0.0.1 구분
		origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
		allowCredentials = "true", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
				RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.HEAD, RequestMethod.OPTIONS })
public class EventController {
	@Autowired
	EventService service;

	private final int SUCCESS = 1;

	// eventList
	@GetMapping(value = "/events")
	public ResponseEntity<EventResultDto> eventList(EventParamDto eventParamDto) {
		EventResultDto eventResultDto;
		System.out.println("list");

		// servcie 호출할때, searchWord 유무에 따라 분리해서 처리
		if (eventParamDto.getSearchWord() == null || eventParamDto.getSearchWord().isEmpty()) {
			eventResultDto = service.eventList(eventParamDto);
		} else {
			eventResultDto = service.eventListSearchWord(eventParamDto);
		}

		// System.out.println(eventParamDto);

		if (eventResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// eventDetail
	@GetMapping(value = "/events/{eventId}")
	public ResponseEntity<EventResultDto> eventDetail(@PathVariable int eventId, HttpSession session) {
		System.out.println("detail");

		EventParamDto eventParamDto = new EventParamDto();
		eventParamDto.setEventId(eventId);

//		UserDto userDto = (UserDto) session.getAttribute("userDto"); // 현재 로그인되어서 상세 요청을 한 사용자 정보
//		eventParamDto.setUserSeq(userDto.getUserSeq()); // 사용자 seq

		EventResultDto eventResultDto;
		System.out.println(eventParamDto);
		eventResultDto = service.eventDetail(eventParamDto);

		if (eventResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// eventInsert
	@PostMapping(value = "/events/participate")
	public ResponseEntity<EventResultDto> eventParticipate(EventParticipateDto eventParticipateDto,
			MultipartHttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		eventParticipateDto.setUserSeq(userDto.getUserSeq());

		EventResultDto eventResultDto = service.eventParticipate(eventParticipateDto);

		if (eventResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// eventParticipateState
	@GetMapping(value = "/eventsParticipate/{eventId}")
	public int eventParticipateState(@PathVariable int eventId, HttpSession session) {
		EventParticipateDto eventParticipateDto = new EventParticipateDto();
		eventParticipateDto.setEventId(eventId);

		UserDto userDto = (UserDto) session.getAttribute("userDto"); // 현재 로그인되어서 상세 요청을 한 사용자 정보
		eventParticipateDto.setUserSeq(userDto.getUserSeq()); // 사용자 seq

		System.out.println(eventParticipateDto);

		int result = service.eventParticipateState(eventParticipateDto);

		return result;
	}

}
