package com.mycom.myapp.house.dto;

import java.util.List;

public class HouseResultDto {
	// Spring에서 response를 json으로 처리하기 위해 미리 response 에 리턴값으로 사용하는 항목들을 Dto로 만든다.

	private int result;
	private List<HouseDealDto> dealList; // 상세
	private List<HouseDto> list; // 목록
	private int houseCnt;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<HouseDealDto> getDealList() {
		return dealList;
	}

	public void setDealList(List<HouseDealDto> dealList) {
		this.dealList = dealList;
	}

	public List<HouseDto> getList() {
		return list;
	}

	public void setList(List<HouseDto> list) {
		this.list = list;
	}

	public int getHouseCnt() {
		return houseCnt;
	}

	public void setHouseCnt(int houseCnt) {
		this.houseCnt = houseCnt;
	}

	@Override
	public String toString() {
		return "HouseResultDto [result=" + result + ", dealList=" + dealList + ", list=" + list + ", houseCnt="
				+ houseCnt + "]";
	}

}
