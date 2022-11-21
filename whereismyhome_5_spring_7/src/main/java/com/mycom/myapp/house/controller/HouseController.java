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
@Api("Map 컨트롤러")
@RequestMapping("/houses")
public class HouseController {

	@Autowired
	HouseService service;

	private final int SUCCESS = 1;

	
	private final String SERVICE_URL = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
	private final String SERVICE_KEY = "s%2BgxQEYCcJodyCSOlob44s%2Fgj61vZR9gXEcFlYBdCHQfFaGKVwlH1k9usrKhkLQ9Gd3V%2FC1LtNheA3vnW02SGQ%3D%3D";
	
	// detail
	@ApiOperation(value = "아파트 detail", notes = "지역코드와 매매계약월을 기준으로 아파트 목록을 반환한다.", response = List.class)
	@GetMapping(value = "/{houseSeq}")
	public ResponseEntity<HouseDto> houseDetail(@PathVariable int houseSeq) {
		HouseDto houseDto = service.houseDetail(houseSeq);
		System.out.println("detail"+houseDto);
		return new ResponseEntity<HouseDto>(houseDto, HttpStatus.OK);
	}

	// search
	@ApiOperation(value = "아파트 search", notes = "지역코드와 매매계약월을 기준으로 아파트 목록을 반환한다.", response = List.class)
	@GetMapping(value = "/search/{lawd_cd}/{deal_ymd}")
	public ResponseEntity<String> houseListSearch(@PathVariable("lawd_cd") String lawdCd, @PathVariable("deal_ymd") String dealYmd) throws IOException {
		StringBuilder urlBuilder = new StringBuilder(SERVICE_URL);
		System.out.println(dealYmd);
		System.out.println(lawdCd);
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + SERVICE_KEY);
//		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); // 페이지번호 
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="+ URLEncoder.encode("100", "UTF-8")); // 한 페이지 결과 수 
		urlBuilder.append("&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "=" + URLEncoder.encode(lawdCd, "UTF-8")); // 지역코드 
		urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "=" + URLEncoder.encode(dealYmd, "UTF-8")); // 계약월 
		URL url = new URL(urlBuilder.toString());
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		JSONObject json = XML.toJSONObject(sb.toString());
		String jsonStr = json.toString();
		
		return new ResponseEntity<String>(jsonStr, HttpStatus.OK);
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
