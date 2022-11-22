package com.mycom.myapp.house.service;

import java.util.List;

import com.mycom.myapp.house.dto.HouseDto;
import com.mycom.myapp.house.dto.HouseParamDto;
import com.mycom.myapp.house.dto.HouseResultDto;

public interface HouseService {
	// 전체 조회
	HouseResultDto houseList(String lawdcd);

	// 실거래가 검색 (동별검색)
	List<HouseDto> houseListSearch(HouseParamDto houseParamDto);

	// 거래매매 상세조회
	HouseDto houseDetail(int houseSeq);

	// 조회 건수
	int houseListTotalCnt(HouseParamDto houseParamDto);

	// 검색 조회 건수
	int houseListSearchTotalCnt(HouseParamDto houseParamDto);

}
