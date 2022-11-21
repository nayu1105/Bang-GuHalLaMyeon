package com.mycom.myapp.review.dto;

public class ReviewParamDto {

	// 리뷰 목록
	private int limit;
	private int offset;

	private int reviewId;
	private int houseNo;
	private String userEmail;

	public ReviewParamDto() {

	}

	public ReviewParamDto(int limit, int offset, int reviewId, int houseNo, String userEmail) {
		super();
		this.limit = limit;
		this.offset = offset;
		this.reviewId = reviewId;
		this.houseNo = houseNo;
		this.userEmail = userEmail;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "ReviewParamDto [limit=" + limit + ", offset=" + offset + ", reviewId=" + reviewId + ", houseNo="
				+ houseNo + ", userEmail=" + userEmail + "]";
	}

}
