package com.mycom.myapp.city.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.city.dao.CityDao;
import com.mycom.myapp.city.dto.CityCodeDto;
import com.mycom.myapp.city.dto.CityResultDto;

@Service
public class CityServiceImpl implements CityService {

	final int SUCCESS = 1;

	@Autowired
	CityDao dao;

	@Override
	public CityResultDto cityList() {
		CityResultDto cityResultDto = new CityResultDto();
		cityResultDto.setList(dao.cityList());
		System.out.println(dao.cityList());
		cityResultDto.setResult(SUCCESS);
		return cityResultDto;
	}

	@Override
	public CityResultDto gugunList(CityCodeDto cityCodeDto) {
		CityResultDto cityResultDto = new CityResultDto();
		cityResultDto.setList(dao.gugunList(cityCodeDto));
		cityResultDto.setResult(SUCCESS);
		return cityResultDto;
	}

	@Override
	public CityResultDto dongList(CityCodeDto cityCodeDto) {
		CityResultDto cityResultDto = new CityResultDto();
		cityResultDto.setList(dao.dongList(cityCodeDto));
		cityResultDto.setResult(SUCCESS);
		return cityResultDto;
	}

	@Override
	public CityResultDto lawdcdList() {
		CityResultDto cityResultDto = new CityResultDto();
		cityResultDto.setList(dao.lawdcdList());
		cityResultDto.setResult(SUCCESS);
		return cityResultDto;
	}

}
