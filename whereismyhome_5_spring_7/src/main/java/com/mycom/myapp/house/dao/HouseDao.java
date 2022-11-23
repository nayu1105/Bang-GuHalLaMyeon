package com.mycom.myapp.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.house.dto.HouseDealDto;
import com.mycom.myapp.house.dto.HouseDto;

@Mapper
public interface HouseDao {
	// 조회
	List<HouseDto> houseList(String lawdcd);

	// 거래매매 상세조회
	List<HouseDealDto> houseDetail(long aptCode);

	// 월별 평균 거래가 조회
	List<HouseDealDto> houseDealMonthAmount(long aptCode);
}
