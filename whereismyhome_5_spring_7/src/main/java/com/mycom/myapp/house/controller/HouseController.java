package com.mycom.myapp.house.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.house.dto.HouseDto;
import com.mycom.myapp.house.dto.HouseParamDto;
import com.mycom.myapp.house.dto.HouseResultDto;
import com.mycom.myapp.house.service.HouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	
	// detail
//	@ApiOperation(value = "아파트 detail", notes = "지역코드와 매매계약월을 기준으로 아파트 목록을 반환한다.", response = List.class)
	@GetMapping(value = "/houses/{houseSeq}")
	public ResponseEntity<HouseDto> houseDetail(@PathVariable int houseSeq) {
		HouseDto houseDto = service.houseDetail(houseSeq);
		System.out.println("detail"+houseDto);
		return new ResponseEntity<HouseDto>(houseDto, HttpStatus.OK);
	}
	
	// lawdcd 에 맞는 list 
	@GetMapping(value="/houses")
	public ResponseEntity<HouseResultDto> houseList(String lawdcd) {
		System.out.println("lawdcd");
		System.out.println(lawdcd);
		HouseResultDto houseResultDto = service.houseList(lawdcd);
		if(houseResultDto.getResult() == SUCCESS) {
			System.out.println(houseResultDto.getList());
			return new ResponseEntity<HouseResultDto>(houseResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<HouseResultDto>(houseResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
