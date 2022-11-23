package com.mycom.myapp.review.service;

import com.mycom.myapp.review.dto.ReviewDto;
import com.mycom.myapp.review.dto.ReviewParamDto;
import com.mycom.myapp.review.dto.ReviewResultDto;

public interface ReviewService {
	ReviewResultDto reviewInsert(ReviewDto dto);
	ReviewResultDto reviewDelete(int reviewId);

	ReviewResultDto reviewDetail(ReviewParamDto reviewParamDto);
	
	ReviewResultDto reviewList(ReviewParamDto reviewParamDto);
	int reviewListTotalCnt(ReviewParamDto reviewParamDto);
}
