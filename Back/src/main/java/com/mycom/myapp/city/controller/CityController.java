package com.mycom.myapp.city.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.city.dto.CityCodeDto;
import com.mycom.myapp.city.dto.CityResultDto;
import com.mycom.myapp.city.service.CityService;

@RestController
@CrossOrigin(
	    // localhost:5500 과 127.0.0.1 구분
	    origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
	    allowCredentials = "true", 
	    allowedHeaders = "*", 
	    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
public class CityController {

	final int SUCCESS = 1;

	@Autowired
	CityService service;

	@GetMapping(value = "/city") // city_name 가져오기
	ResponseEntity<CityResultDto> houseList(CityCodeDto cityCodeDto) {
		CityResultDto cityResultDto = new CityResultDto();
		if (cityCodeDto.getOption().equals("sido")) { // get city
			cityResultDto = service.cityList();
			System.out.println(cityResultDto);

			if (cityResultDto.getResult() == SUCCESS) {
				return new ResponseEntity<CityResultDto>(cityResultDto, HttpStatus.OK);
			} else {
				return new ResponseEntity<CityResultDto>(cityResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else if (cityCodeDto.getOption().equals("gugun")) { // get gugun
			
			cityResultDto = service.gugunList(cityCodeDto);
			System.out.println(cityResultDto);
			if (cityResultDto.getResult() == SUCCESS) {
				return new ResponseEntity<CityResultDto>(cityResultDto, HttpStatus.OK);
			} else {
				return new ResponseEntity<CityResultDto>(cityResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else if (cityCodeDto.getOption().equals("dong")) { // get dong
			cityResultDto = service.dongList(cityCodeDto);
			
			System.out.println(cityCodeDto);

			if (cityResultDto.getResult() == SUCCESS) {
				return new ResponseEntity<CityResultDto>(cityResultDto, HttpStatus.OK);
			} else {
				return new ResponseEntity<CityResultDto>(cityResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else { // 다른 변수 들어오면 이상한 접근
			return new ResponseEntity<CityResultDto>(cityResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value ="/city/lawdcd")
	ResponseEntity<CityResultDto> lawdcdList(){
		System.out.println("/city/lawdcd");
		CityResultDto cityResultDto = new CityResultDto();
		cityResultDto = service.lawdcdList();
		if(cityResultDto.getResult()==SUCCESS) {
			return new ResponseEntity<CityResultDto>(cityResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<CityResultDto>(cityResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
