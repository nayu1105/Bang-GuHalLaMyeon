package com.mycom.myapp.review.service;

import com.mycom.myapp.review.dto.ReviewParamDto;
import com.mycom.myapp.review.dto.ReviewResultDto;

public interface ReviewService {
	ReviewResultDto reviewList(ReviewParamDto reviewParamDto);
	int reviewListTotalCnt();
	
	ReviewResultDto reviewDetail(ReviewParamDto reviewParamDto);
}
