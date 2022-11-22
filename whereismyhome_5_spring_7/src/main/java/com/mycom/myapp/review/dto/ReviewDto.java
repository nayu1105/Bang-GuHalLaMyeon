package com.mycom.myapp.review.dto;

public class ReviewDto {

	private int reviewId;
	private int houseNo;
	private int rate;
	private String userEmail;
	private String userName;
	private String title;
	private String content;

	public ReviewDto() {

	}

	public ReviewDto(int reviewId, int houseNo, int rate, String userEmail, String userName, String title,
			String content) {
		super();
		this.reviewId = reviewId;
		this.houseNo = houseNo;
		this.rate = rate;
		this.userEmail = userEmail;
		this.userName = userName;
		this.title = title;
		this.content = content;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReviewDto [reviewId=" + reviewId + ", houseNo=" + houseNo + ", rate=" + rate + ", userEmail="
				+ userEmail + ", userName=" + userName + ", title=" + title + ", content=" + content + "]";
	}

}
