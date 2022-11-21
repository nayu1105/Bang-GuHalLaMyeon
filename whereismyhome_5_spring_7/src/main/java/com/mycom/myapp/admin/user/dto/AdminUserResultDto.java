package com.mycom.myapp.admin.user.dto;

import java.util.List;

public class AdminUserResultDto {
	private int result;
	private List<AdminUserDto> list;
	private int count;
	private AdminUserDto dto;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<AdminUserDto> getList() {
		return list;
	}

	public void setList(List<AdminUserDto> list) {
		this.list = list;
	}

	public AdminUserDto getDto() {
		return dto;
	}

	public void setDto(AdminUserDto dto) {
		this.dto = dto;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AdminUserResultDto [result=" + result + ", list=" + list + ", count=" + count + ", dto=" + dto + "]";
	}

}
