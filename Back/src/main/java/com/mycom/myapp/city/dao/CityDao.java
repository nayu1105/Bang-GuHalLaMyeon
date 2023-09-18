package com.mycom.myapp.city.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.city.dto.CityCodeDto;

@Mapper
public interface CityDao {
	List<CityCodeDto> cityList();
	List<CityCodeDto> gugunList(CityCodeDto cityCodeDto);
	List<CityCodeDto> dongList(CityCodeDto cityCodeDto);
	List<CityCodeDto> lawdcdList();
}
