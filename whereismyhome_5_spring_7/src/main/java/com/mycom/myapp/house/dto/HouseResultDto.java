package com.mycom.myapp.house.dto;

import java.util.List;

public class HouseResultDto {
	// Spring에서 response를 json으로 처리하기 위해 미리 response 에 리턴값으로 사용하는 항목들을 Dto로 만든다.

	private int result;
	private HouseDto dto; // 게시글 하나
	private List<HouseDto> list; // 게시글 목록
	private int houseCnt;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public HouseDto getDto() {
		return dto;
	}

	public void setDto(HouseDto dto) {
		this.dto = dto;
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

}
