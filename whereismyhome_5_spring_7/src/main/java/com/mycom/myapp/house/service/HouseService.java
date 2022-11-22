package com.mycom.myapp.house.service;

import com.mycom.myapp.house.dto.HouseResultDto;

public interface HouseService {
	// 전체 조회
	HouseResultDto houseList(String lawdcd);

	// 거래매매 상세조회
	HouseResultDto houseDetail(long aptCode);

}
