package com.mycom.myapp.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mycom.myapp.house.dto.HouseDto;
import com.mycom.myapp.house.dto.HouseParamDto;
import com.mycom.myapp.house.dto.HouseResultDto;
import com.mycom.myapp.house.service.HouseService;

@RestController
public class HouseController {

	@Autowired
	HouseService service;

	private final int SUCCESS = 1;

	
	private final String SERVICE_URL = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
	private final String SERVICE_KEY = "s%2BgxQEYCcJodyCSOlob44s%2Fgj61vZR9gXEcFlYBdCHQfFaGKVwlH1k9usrKhkLQ9Gd3V%2FC1LtNheA3vnW02SGQ%3D%3D";
	
	// detail
	@GetMapping(value = "/houses/{houseSeq}")
	public ResponseEntity<HouseDto> houseDetail(@PathVariable int houseSeq) {
		HouseDto houseDto = service.houseDetail(houseSeq);
		System.out.println("detail"+houseDto);
		return new ResponseEntity<HouseDto>(houseDto, HttpStatus.OK);
	}

	// search
	@GetMapping(value = "/houses/search")
	public ResponseEntity<HouseResultDto> houseListSearch(HouseParamDto houseParamDto) {
		HouseResultDto houseResultDto = new HouseResultDto();
		System.out.println("잘왔다");
		System.out.println(houseParamDto);
		List<HouseDto> houseList = service.houseListSearch(houseParamDto);
		houseResultDto.setList(houseList);
		System.out.println(houseList);
		houseResultDto.setResult(SUCCESS);
		
		return new ResponseEntity<HouseResultDto>(houseResultDto, HttpStatus.OK);
	}

//	// list + cnt 조회
//	@GetMapping(value = "/houses")
//	public ResponseEntity<HouseResultDto> houseList(HouseParamDto houseParamDto) {
//		HouseResultDto houseResultDto = new HouseResultDto();
//		houseResultDto.setList(service.houseList(houseParamDto));
//
////		if (houseParamDto.getSido().equals("") && houseParamDto.getGugun().equals("")) {
////			houseResultDto.setHouseCnt(service.houseListTotalCnt(houseParamDto));
////		} else {
////			houseResultDto.setHouseCnt(service.houseListSearchTotalCnt(houseParamDto));
////		}
//		houseResultDto.setResult(SUCCESS);
//
//		return new ResponseEntity<HouseResultDto>(houseResultDto, HttpStatus.OK);
//	}

	
}
