package com.mycom.myapp.bookmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.bookmark.dto.BookmarkDto;
import com.mycom.myapp.bookmark.dto.BookmarkResultDto;
import com.mycom.myapp.bookmark.service.BookmarkService;

@RestController
@CrossOrigin(
		// localhost:5500 과 127.0.0.1 구분
		origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
		allowCredentials = "true", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
				RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.HEAD, RequestMethod.OPTIONS })
public class BookmarkController {

	@Autowired
	BookmarkService service;

	private final int SUCCESS = 1;
	private final int FAIL = -1;

	@GetMapping(value = "/bookmarks/{userSeq}")
	public ResponseEntity<BookmarkResultDto> bookmarkList(@PathVariable int userSeq) {
		System.out.println(userSeq);
		BookmarkResultDto bookmarkResultDto;
		bookmarkResultDto = service.bookmarkList(userSeq);

		System.out.println(bookmarkResultDto);

		if (bookmarkResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BookmarkResultDto>(bookmarkResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BookmarkResultDto>(bookmarkResultDto, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@DeleteMapping(value = "/bookmarks")
	public ResponseEntity<BookmarkResultDto> bookmarkDelete(BookmarkDto bookmarkDto) {
		BookmarkResultDto bookmarkResultDto;
		bookmarkResultDto = service.bookmarkDelete(bookmarkDto);
		if (bookmarkResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BookmarkResultDto>(bookmarkResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BookmarkResultDto>(bookmarkResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/bookmarks")
	public ResponseEntity<BookmarkResultDto> bookmarkInsert(BookmarkDto bookmarkDto) {
		System.out.println(bookmarkDto);
		BookmarkResultDto bookmarkResultDto;
		bookmarkResultDto = service.bookmarkInsert(bookmarkDto);
		if (bookmarkResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BookmarkResultDto>(bookmarkResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BookmarkResultDto>(bookmarkResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
