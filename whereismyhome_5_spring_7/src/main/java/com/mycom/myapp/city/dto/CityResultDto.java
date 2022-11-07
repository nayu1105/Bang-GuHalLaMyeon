package com.mycom.myapp.city.dto;

import java.util.List;

public class CityResultDto {
	int result;
	List<CityCodeDto> list;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<CityCodeDto> getList() {
		return list;
	}

	public void setList(List<CityCodeDto> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "CityResultDto [result=" + result + ", list=" + list + "]";
	}

}
