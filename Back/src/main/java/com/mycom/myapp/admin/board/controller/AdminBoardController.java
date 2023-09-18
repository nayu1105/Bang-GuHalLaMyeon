package com.mycom.myapp.admin.board.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myapp.admin.board.dto.BoardDto;
import com.mycom.myapp.admin.board.dto.BoardParamDto;
import com.mycom.myapp.admin.board.dto.BoardResultDto;
import com.mycom.myapp.admin.board.service.AdminBoardService;
import com.mycom.myapp.user.dto.UserDto;


@RestController
@CrossOrigin(
	    // localhost:5500 과 127.0.0.1 구분
	    origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
	    allowCredentials = "true", 
	    allowedHeaders = "*", 
	    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
public class AdminBoardController {
	@Autowired
	AdminBoardService service;
	
	private final int SUCCESS = 1;
	
	// boardList
	@GetMapping(value= "/admin/boards")
	public ResponseEntity<BoardResultDto> boardList(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto;
		System.out.println(boardParamDto);
		// servcie 호출할때, searchWord 유무에 따라 분리해서 처리
		if (boardParamDto.getSearchWord() == null || boardParamDto.getSearchWord().isEmpty()) {
			boardResultDto = service.boardList(boardParamDto);
		} else {
			boardResultDto = service.boardListSearchWord(boardParamDto);
		}

		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	// boardDetail
	@GetMapping(value= "/admin/boards/{boardId}")
	public ResponseEntity<BoardResultDto> boardDetail(@PathVariable int boardId, HttpSession session) {
		
		BoardParamDto boardParamDto = new BoardParamDto();
		boardParamDto.setBoardId(boardId);
		
		UserDto userDto = (UserDto) session.getAttribute("userDto"); // 현재 로그인되어서 상세 요청을 한 사용자 정보
		boardParamDto.setUserSeq(userDto.getUserSeq()); // 사용자 seq
		
		BoardResultDto boardResultDto;
		boardResultDto = service.boardDetail(boardParamDto);
		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// boardInsert
	@PostMapping(value="/admin/boards")
	public ResponseEntity<BoardResultDto> boardInsert(@RequestBody BoardDto boardDto, HttpSession session) {
		System.out.println("boardInsert");
		System.out.println(boardDto);
		UserDto userDto = (UserDto) session.getAttribute("userDto"); 
		boardDto.setUserSeq(userDto.getUserSeq());
		
		System.out.println(boardDto);
		BoardResultDto boardResultDto = service.boardInsert(boardDto);

		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//boardDelete
	@DeleteMapping(value="/admin/boards/{boardId}")
	public ResponseEntity<BoardResultDto> boardDelete(@PathVariable int boardId) {
		
		BoardResultDto boardResultDto = service.boardDelete(boardId);
		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//boardUpdate
	@PutMapping(value="/admin/boards")
	public  ResponseEntity<BoardResultDto> boardUpdate(@RequestBody BoardDto boardDto) {
				
		BoardResultDto boardResultDto = service.boardUpdate(boardDto);

		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}