package com.mycom.myapp.city.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.city.dto.CityCodeDto;
import com.mycom.myapp.city.dto.CityResultDto;
import com.mycom.myapp.city.service.CityService;

@RestController
public class CityController {

	final int SUCCESS = 1;

	@Autowired
	CityService service;

	@GetMapping(value = "/city") // city_name 가져오기
	ResponseEntity<CityResultDto> houseList(CityCodeDto cityCodeDto) {
		CityResultDto cityResultDto = new CityResultDto();
		
		System.out.println(cityCodeDto);

		if (cityCodeDto.getOption() == 1) { // get city
			cityResultDto = service.cityList();

			if (cityResultDto.getResult() == SUCCESS) {
				return new ResponseEntity<CityResultDto>(cityResultDto, HttpStatus.OK);
			} else {
				return new ResponseEntity<CityResultDto>(cityResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else if (cityCodeDto.getOption() == 2) { // get gugun

			cityResultDto = service.gugunList(cityCodeDto);

			if (cityResultDto.getResult() == SUCCESS) {
				return new ResponseEntity<CityResultDto>(cityResultDto, HttpStatus.OK);
			} else {
				return new ResponseEntity<CityResultDto>(cityResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else if (cityCodeDto.getOption() == 3) { // get dong
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
}
