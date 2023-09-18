package com.mycom.myapp.house.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.house.dto.HouseResultDto;
import com.mycom.myapp.house.service.HouseService;

@RestController
@CrossOrigin(
	    // localhost:5500 과 127.0.0.1 구분
	    origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
	    allowCredentials = "true", 
	    allowedHeaders = "*", 
	    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
//@Api("Map 컨트롤러")
public class HouseController {

	@Autowired
	HouseService service;

	private final int SUCCESS = 1;

	
//	private final String SERVICE_URL = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
//	private final String SERVICE_KEY = "s%2BgxQEYCcJodyCSOlob44s%2Fgj61vZR9gXEcFlYBdCHQfFaGKVwlH1k9usrKhkLQ9Gd3V%2FC1LtNheA3vnW02SGQ%3D%3D";
	
	@GetMapping(value = "/houses/{aptCode}")
	public ResponseEntity<HouseResultDto> houseDetail(@PathVariable long aptCode) {
		System.out.println("aptCode");
		System.out.println(aptCode);
		HouseResultDto houseResultDto = service.houseDetail(aptCode);
		
		System.out.println(houseResultDto);
		
		if(houseResultDto.getResult()==SUCCESS) {
			return new ResponseEntity<HouseResultDto>(houseResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<HouseResultDto>(houseResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	// lawdcd 에 맞는 list 
	@GetMapping(value="/houses")
	public ResponseEntity<HouseResultDto> houseList(String lawdcd) {
		System.out.println("lawdcd");
		System.out.println(lawdcd);
		HouseResultDto houseResultDto = service.houseList(lawdcd);
		if(houseResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<HouseResultDto>(houseResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<HouseResultDto>(houseResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
