package com.mycom.myapp.house.dto;

import java.util.List;

public class HouseResultDto {
	// Spring에서 response를 json으로 처리하기 위해 미리 response 에 리턴값으로 사용하는 항목들을 Dto로 만든다.

	private int result;
	private HouseDealDto houseDealdto; // 상세
	private List<HouseDto> list; // 목록
	private int houseCnt;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public HouseDealDto getHouseDealdto() {
		return houseDealdto;
	}

	public void setHouseDealdto(HouseDealDto houseDealdto) {
		this.houseDealdto = houseDealdto;
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
		return "HouseResultDto [result=" + result + ", houseDealdto=" + houseDealdto + ", list=" + list + ", houseCnt="
				+ houseCnt + "]";
	}

}
