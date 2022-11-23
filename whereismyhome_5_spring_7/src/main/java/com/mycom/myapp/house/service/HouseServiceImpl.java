package com.mycom.myapp.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.house.dao.HouseDao;
import com.mycom.myapp.house.dto.HouseResultDto;


@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	HouseDao dao;

	private final int SUCCESS = 1;
	private final int FAIL = -1;
	
	@Override
	public HouseResultDto houseList(String lawdcd) {
		HouseResultDto houseResultDto = new HouseResultDto();
		try {
			houseResultDto.setList(dao.houseList(lawdcd));
			houseResultDto.setResult(SUCCESS);
		}catch (Exception e) {
			houseResultDto.setResult(FAIL);
		}
		return houseResultDto;
	}

	@Override
	public HouseResultDto houseDetail(long aptCode) {
		System.out.println("service");
		System.out.println(aptCode);
		HouseResultDto houseResultDto = new HouseResultDto();
		try {
			houseResultDto.setDealList(dao.houseDetail(aptCode));
			System.out.println("setHouseDealdto");
			houseResultDto.setResult(SUCCESS);
		}catch(Exception e){
			houseResultDto.setResult(FAIL);
		}
		return houseResultDto;
	}


}
