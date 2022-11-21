package com.mycom.myapp.review.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.review.dto.ReviewParamDto;
import com.mycom.myapp.review.dto.ReviewResultDto;
import com.mycom.myapp.review.service.ReviewService;

@RestController
@CrossOrigin(
		// localhost:5500 과 127.0.0.1 구분
		origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
		allowCredentials = "true", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
				RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.HEAD, RequestMethod.OPTIONS })
public class ReviewController {

	@Autowired
	ReviewService service;

	private final int SUCCESS = 1;

	// reviewList
	@GetMapping(value = "/reviews")
	public ResponseEntity<ReviewResultDto> reviewList(ReviewParamDto reviewParamDto) {
		ReviewResultDto reviewResultDto;
		reviewResultDto = service.reviewList(reviewParamDto);

		// System.out.println(reviewParamDto);

		if (reviewResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<ReviewResultDto>(reviewResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<ReviewResultDto>(reviewResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// reviewDetail
	@GetMapping(value = "/reviews/{reviewId}")
	public ResponseEntity<ReviewResultDto> reviewDetail(@PathVariable int reviewId, HttpSession session) {
		System.out.println("detail");

		ReviewParamDto reviewParamDto = new ReviewParamDto();
		reviewParamDto.setReviewId(reviewId);

		ReviewResultDto reviewResultDto;
		System.out.println(reviewParamDto);
		reviewResultDto = service.reviewDetail(reviewParamDto);

		if (reviewResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<ReviewResultDto>(reviewResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<ReviewResultDto>(reviewResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}