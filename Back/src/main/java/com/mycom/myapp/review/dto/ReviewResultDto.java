package com.mycom.myapp.review.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewResultDto {
	private int result;
	private ReviewDto dto;
	private List<ReviewDto> list;
	private int count;

	private Integer avgRate;
}
