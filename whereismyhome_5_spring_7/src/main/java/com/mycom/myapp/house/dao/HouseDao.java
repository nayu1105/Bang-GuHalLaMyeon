package com.mycom.myapp.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.house.dto.HouseDto;
import com.mycom.myapp.house.dto.HouseParamDto;

@Mapper
public interface HouseDao {
	// 조회
	List<HouseDto> houseList(HouseParamDto houseParamDto);

	// 실거래가 검색 (동별 검색)
	List<HouseDto> houseListSearch(HouseParamDto houseParamDto);

	// 거래매매 상세조회
	HouseDto houseDetail(int houseSeq);

	// 조회 건수
	int houseListTotalCnt(HouseParamDto houseParamDto);

	// 검색 조회 건수
	int houseListSearchTotalCnt(HouseParamDto houseParamDto);
}
