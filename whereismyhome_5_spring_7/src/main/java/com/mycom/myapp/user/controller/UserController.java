package com.mycom.myapp.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.user.dto.CodeDto;
import com.mycom.myapp.user.dto.UserDto;
import com.mycom.myapp.user.dto.UserResultDto;
import com.mycom.myapp.user.service.CodeService;
import com.mycom.myapp.user.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	CodeService codeService;

	private final int SUCCESS = 1;

	@PostMapping(value = "/register")
	public ResponseEntity<Map<String, String>> register(UserDto dto) {
		System.out.println(dto);
		UserResultDto userResultDto = userService.userRegister(dto);

		Map<String, String> map = new HashMap<>();
		if (userResultDto.getResult() == SUCCESS) {
			map.put("result", "success");
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/register/getcommon/{code}")
	public ResponseEntity<Map<String, List<CodeDto>>> getCodeList(@PathVariable String code) {
		List<CodeDto> list = codeService.getCodeList(code);

		Map<String, List<CodeDto>> map = new HashMap<>();
		map.put("list", list);

		return new ResponseEntity<Map<String, List<CodeDto>>>(map, HttpStatus.OK);
	}
	
	@GetMapping("/user/{userSeq}")
	public ResponseEntity<UserDto> userProfile(@PathVariable String userSeq) {
		int userSeqInt = Integer.parseInt(userSeq);
		
		UserDto dto = userService.userProfile(userSeqInt);
		
		return new ResponseEntity<UserDto>(dto, HttpStatus.OK);
	}
	
	@PostMapping("/user/{userSeq}")
	private ResponseEntity<Map<String, String>> boardUpdate(UserDto dto) {
		System.out.println(dto);
		UserResultDto userResultDto = userService.userUpdate(dto);
	
		Map<String, String> map = new HashMap<>();
		if (userResultDto.getResult() == SUCCESS) {
			map.put("result", "success");
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/user/{userSeq}")
	private ResponseEntity<UserResultDto> userDelete(@PathVariable String userSeq) {
		int userSeqInt = Integer.parseInt(userSeq);
		UserResultDto userResultDto = userService.userDelete(userSeqInt);

		if (userResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
