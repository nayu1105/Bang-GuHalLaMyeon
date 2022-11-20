package com.mycom.myapp.admin.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.admin.user.dto.AdminUserParamDto;
import com.mycom.myapp.admin.user.dto.AdminUserResultDto;
import com.mycom.myapp.admin.user.service.AdminUserService;

@RestController
@CrossOrigin(
	    // localhost:5500 과 127.0.0.1 구분
	    origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
	    allowCredentials = "true", 
	    allowedHeaders = "*", 
	    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
public class AdminUserController {
	@Autowired
	AdminUserService service;
	
	private final int SUCCESS = 1;
	
	@GetMapping(value="/admin/users")
	public ResponseEntity<AdminUserResultDto> userList(AdminUserParamDto adminUserParamDto){
		AdminUserResultDto adminUserResultDto;
		adminUserResultDto = service.userList(adminUserParamDto);
		
		if(adminUserResultDto.getResult()==SUCCESS)	{
			return new ResponseEntity<AdminUserResultDto>(adminUserResultDto, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<AdminUserResultDto>(adminUserResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
