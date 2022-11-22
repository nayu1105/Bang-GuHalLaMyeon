package com.mycom.myapp.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.house.dao.HouseDao;
import com.mycom.myapp.house.dto.HouseDto;
import com.mycom.myapp.house.dto.HouseParamDto;
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
			System.out.println(dao.houseList(lawdcd));
			houseResultDto.setList(dao.houseList(lawdcd));
			houseResultDto.setResult(SUCCESS);
		}catch (Exception e) {
			houseResultDto.setResult(FAIL);
		}
		return houseResultDto;
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
