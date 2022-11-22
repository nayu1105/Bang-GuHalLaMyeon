package com.mycom.myapp.city.service;

import com.mycom.myapp.city.dto.CityCodeDto;
import com.mycom.myapp.city.dto.CityResultDto;

public interface CityService {
	CityResultDto cityList();
	CityResultDto gugunList(CityCodeDto cityCodeDto);
	CityResultDto dongList(CityCodeDto cityCodeDto);
	CityResultDto lawdcdList();
}
