package com.mycom.myapp.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.house.dao.HouseDao;
import com.mycom.myapp.house.dto.HouseDto;
import com.mycom.myapp.house.dto.HouseParamDto;


@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	HouseDao dao;

	@Override
	public List<HouseDto> houseList(HouseParamDto houseParamDto) {
		return dao.houseList(houseParamDto);
	}


	@Override
	public List<HouseDto> houseListSearch(HouseParamDto houseParamDto) {
		return dao.houseListSearch(houseParamDto);
	}


	@Override
	public HouseDto houseDetail(int houseSeq) {
		return dao.houseDetail(houseSeq);
	}


	@Override
	public int houseListTotalCnt(HouseParamDto houseParamDto) {
		return dao.houseListTotalCnt(houseParamDto);
	}


	@Override
	public int houseListSearchTotalCnt(HouseParamDto houseParamDto) {
		return dao.houseListSearchTotalCnt(houseParamDto);
	}

}
