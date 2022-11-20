package com.mycom.myapp.review.dto;

import java.util.List;

public class ReviewResultDto {
	private int result;
	private ReviewDto dto;
	private List<ReviewDto> list;
	private int count;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public ReviewDto getDto() {
		return dto;
	}

	public void setDto(ReviewDto dto) {
		this.dto = dto;
	}

	public List<ReviewDto> getList() {
		return list;
	}

	public void setList(List<ReviewDto> list) {
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ReviewResultDto [result=" + result + ", dto=" + dto + ", list=" + list + ", count=" + count + "]";
	}

}
