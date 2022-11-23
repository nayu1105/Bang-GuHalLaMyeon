package com.mycom.myapp.house.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HouseResultDto {
	// Spring에서 response를 json으로 처리하기 위해 미리 response 에 리턴값으로 사용하는 항목들을 Dto로 만든다.

	private int result;
	private List<HouseDealDto> dealList; // 상세
	private List<HouseDto> list; // 목록
	private int houseCnt;

	private List<HouseDealDto> avgDealAmount;

}
