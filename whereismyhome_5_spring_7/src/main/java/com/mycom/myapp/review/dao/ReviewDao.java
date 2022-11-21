package com.mycom.myapp.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.review.dto.ReviewDto;
import com.mycom.myapp.review.dto.ReviewParamDto;

@Mapper
public interface ReviewDao {
	int reviewInsert(ReviewDto dto);
	int reviewDelete(int reviewId);

	ReviewDto reviewDetail(int reviewId);

	List<ReviewDto> reviewList(ReviewParamDto reviewParamDto);
	int reviewListTotalCnt();
}
