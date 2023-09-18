package com.mycom.myapp.login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.login.service.LoginService;
import com.mycom.myapp.user.dto.UserDto;

@RestController
@CrossOrigin(
	    // localhost:5500 과 127.0.0.1 구분
	    origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
	    allowCredentials = "true", 
	    allowedHeaders = "*", 
	    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
public class LoginController {

	@Autowired
	LoginService service;

	@PostMapping(value = "/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody  UserDto dto, HttpSession session) {
		System.out.println(dto);
		UserDto userDto = service.login(dto);
		Map<String, String> map = new HashMap<>();
		if (userDto != null) { // login 성공
			session.setAttribute("userDto", userDto);
			
			System.out.println("로그인 성공");
			
			map.put("result", "success");
			map.put("userName", userDto.getUserName());
			map.put("userProfileImageUrl", userDto.getUserProfileImageUrl());
			map.put("userCode", userDto.getUserClsf());
			map.put("userSeq", Integer.toString(userDto.getUserSeq()));

			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		}

		map.put("result", "fail");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.NOT_FOUND);
	}
}
