package com.mycom.myapp.admin.event.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myapp.admin.event.dto.EventDto;
import com.mycom.myapp.admin.event.dto.EventParamDto;
import com.mycom.myapp.admin.event.dto.EventResultDto;
import com.mycom.myapp.admin.event.service.AdminEventService;
import com.mycom.myapp.user.dto.UserDto;

@RestController
@CrossOrigin(
	    // localhost:5500 과 127.0.0.1 구분
	    origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
	    allowCredentials = "true", 
	    allowedHeaders = "*", 
	    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
public class AdminEventController {
	@Autowired
	AdminEventService service;

	private final int SUCCESS = 1;

	// eventList
	@GetMapping(value = "/admin/events")
	public ResponseEntity<EventResultDto> eventList(EventParamDto eventParamDto) {
		EventResultDto eventResultDto;

		if (eventParamDto.getSearchWord() == null || eventParamDto.getSearchWord().isEmpty()) {
			eventResultDto = service.eventList(eventParamDto);
		} else {
			eventResultDto = service.eventListSearchWord(eventParamDto);
		}
		
		System.out.println(eventResultDto.toString());

		if (eventResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// eventDetail
	@GetMapping(value = "/admin/events/{eventId}")
	public ResponseEntity<EventResultDto> eventDetail(@PathVariable int eventId, HttpSession session) {

		EventParamDto eventParamDto = new EventParamDto();
		eventParamDto.setEventId(eventId);

		UserDto userDto = (UserDto) session.getAttribute("userDto"); // 현재 로그인되어서 상세 요청을 한 사용자 정보
		eventParamDto.setUserSeq(userDto.getUserSeq()); // 사용자 seq

		EventResultDto eventResultDto;
		eventResultDto = service.eventDetail(eventParamDto);
		if (eventResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// eventInsert
	@PostMapping(value = "/admin/events")
	public ResponseEntity<EventResultDto> eventInsert(EventDto eventDto, MultipartHttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		eventDto.setUserSeq(userDto.getUserSeq());

		EventResultDto eventResultDto = service.eventInsert(eventDto);

		if (eventResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// eventDelete
	@DeleteMapping(value = "/admin/events/{eventId}")
	public ResponseEntity<EventResultDto> eventDelete(@PathVariable int eventId) {
		EventResultDto eventResultDto = service.eventDelete(eventId);
		
		if (eventResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// eventUpdate
	@PutMapping(value = "/admin/events/{eventId}")
	public ResponseEntity<EventResultDto> eventUpdate(EventDto eventDto) {
		EventResultDto eventResultDto = service.eventUpdate(eventDto);

		if (eventResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<EventResultDto>(eventResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
