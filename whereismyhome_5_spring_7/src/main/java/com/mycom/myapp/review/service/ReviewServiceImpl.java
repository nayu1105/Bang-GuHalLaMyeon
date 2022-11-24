package com.mycom.myapp.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.review.dao.ReviewDao;
import com.mycom.myapp.review.dto.ReviewDto;
import com.mycom.myapp.review.dto.ReviewParamDto;
import com.mycom.myapp.review.dto.ReviewResultDto;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao dao;

	private final int SUCCESS = 1;
	private final int FAIL = -1;

	@Override
	public ReviewResultDto reviewInsert(ReviewDto dto) {
		ReviewResultDto reviewResultDto = new ReviewResultDto();
		reviewResultDto.setResult(dao.reviewInsert(dto));
		return reviewResultDto;
	}

	@Override
	public ReviewResultDto reviewDelete(int reviewId) {
		ReviewResultDto reviewResultDto = new ReviewResultDto();
		reviewResultDto.setResult(dao.reviewDelete(reviewId));
		return reviewResultDto;
	}
	
	@Override
	public ReviewResultDto reviewList(ReviewParamDto reviewParamDto) {
		ReviewResultDto reviewResultDto = new ReviewResultDto();
		try {
			// 목록, 총건수를 가져온다.
			List<ReviewDto> list = dao.reviewList(reviewParamDto);
			int count = dao.reviewListTotalCnt(reviewParamDto);
			Integer avgRate = dao.reviewAvgRate(reviewParamDto);
			reviewResultDto.setAvgRate(avgRate);
			reviewResultDto.setList(list);
			reviewResultDto.setCount(count);
			reviewResultDto.setResult(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			reviewResultDto.setResult(FAIL);
		}
		return reviewResultDto;
	}

	@Override
	public int reviewListTotalCnt(ReviewParamDto reviewParamDto) {
		return dao.reviewListTotalCnt(reviewParamDto);
	}

	@Override
	public ReviewResultDto reviewDetail(ReviewParamDto reviewParamDto) {
		ReviewResultDto reviewResultDto = new ReviewResultDto();

		try {
			ReviewDto reviewDto = dao.reviewDetail(reviewParamDto.getReviewId());
			reviewResultDto.setDto(reviewDto);
			reviewResultDto.setResult(SUCCESS);
			return reviewResultDto;
		} catch (Exception e) {
			e.printStackTrace();
			reviewResultDto.setResult(FAIL);
		}
		return reviewResultDto;
	}

}
